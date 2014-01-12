package com.wini.octal.pipe.aria;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.embedder.DecoderEmbedder;
import org.jboss.netty.handler.codec.http.HttpContentDecoder;


public class HttpContentDecoderAria extends HttpContentDecoder {

	@Override
	protected DecoderEmbedder<ChannelBuffer> newContentDecoder(
			String contentEncoding) throws Exception {
		return new DecoderEmbedder<ChannelBuffer>(new AriaDecoder());
	}

}
