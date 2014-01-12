package com.wini.octal.pipe;


import javax.net.ssl.SSLEngine;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import org.jboss.netty.handler.ssl.SslHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*import com.wini.octal.pipe.aria.HttpContentDecoderAria;
import com.wini.octal.pipe.aria.HttpContentEncoderAria;*/
import com.wini.octal.pipe.ssl.SecureSslContextFactory;


public class PortUnificationServerHandler extends FrameDecoder {
	private final boolean detectSsl;
	private static final Logger logger = LoggerFactory.getLogger(PortUnificationServerHandler.class);
	
	public PortUnificationServerHandler() {
		this(true);
	}
	
	public PortUnificationServerHandler(boolean detectSsl) {
		this.detectSsl = detectSsl;
	}
	
	@Override
    public void handleUpstream(
            ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof ChannelStateEvent) {
            logger.info(e.toString());
        }
        super.handleUpstream(ctx, e);
    }
	
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer) throws Exception {
		// Will use the first five bytes to detect a protocal.
		if (buffer.readableBytes() < 5) {
			return null;
		}
		
		if (isSsl(buffer)) {
			enableSsl(ctx);
		} else {
			int index = buffer.readerIndex();
			final int char1 = buffer.getUnsignedByte(index);
			final int char2 = buffer.getUnsignedByte(index+1);
			
			if(isHttpPost(char1, char2)) {
				switch2HttpPost(ctx);
			} else if(isHttpGet(char1, char2)) {
				switch2HttpGet(ctx);
			} else {
				// Unknown protocol; discard everything and close the connection.
				buffer.skipBytes(buffer.readableBytes());
				ctx.getChannel().close();
				return null;
			}
		}
		
		// Forward the current read buffer as is to the new handlers.
		return buffer.readBytes(buffer.readableBytes());
	}
	
	private boolean isSsl(ChannelBuffer buffer) {
		if (detectSsl) {
			return SslHandler.isEncrypted(buffer);
		}
		return false;
	}
	
	private boolean isHttpPost(int char1, int char2) {
		return char1 == 'P' && char2 == 'O'; // POST
	}
	
	private boolean isHttpGet(int char1, int char2) {
		return char1 == 'G' && char2 == 'E'; // GET
	}
	
	private void enableSsl(ChannelHandlerContext ctx) {
		ChannelPipeline p = ctx.getPipeline();
		
		SSLEngine engine = SecureSslContextFactory.getServerContext().createSSLEngine();
        engine.setUseClientMode(false);
        p.addLast("ssl", new SslHandler(engine));
        p.addLast("unification", new PortUnificationServerHandler(false));
        p.remove(this);
	}
	
	private void switch2HttpPost(ChannelHandlerContext ctx) {
		ChannelPipeline p = ctx.getPipeline();
        
        p.addLast("HttpDecoder", new HttpRequestDecoder());
        
        // Uncomment the following line if you don't want to handle HttpChunks.
        p.addLast("aggregator", new HttpChunkAggregator(1048576));       
        
        p.addLast("HttpEncoder", new HttpResponseEncoder());
        
        // Aria Encryption
        /* p.addLast("AriaDecoder", new HttpContentDecoderAria());
        p.addLast("AriaEncoder", new HttpContentEncoderAria()); */
        
        p.addLast("handler", new HttpServerHandler());
        
        p.remove(this);
	}
	
	private void switch2HttpGet(ChannelHandlerContext ctx) {
		ChannelPipeline p = ctx.getPipeline();
        
        p.addLast("HttpDecoder", new HttpRequestDecoder());
        
        // Uncomment the following line if you don't want to handle HttpChunks.
        p.addLast("aggregator", new HttpChunkAggregator(1048576));       
        
        p.addLast("HttpEncoder", new HttpResponseEncoder());
        
        p.addLast("handler", new HttpServerHandler());
        
        p.remove(this);
	}
	
	
}