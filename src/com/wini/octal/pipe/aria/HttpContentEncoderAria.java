package com.wini.octal.pipe.aria;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.embedder.EncoderEmbedder;
import org.jboss.netty.handler.codec.http.HttpContentEncoder;
import org.jboss.netty.handler.codec.http.HttpMessage;


public class HttpContentEncoderAria extends HttpContentEncoder {

	@Override
	protected EncoderEmbedder<ChannelBuffer> newContentEncoder(HttpMessage msg,
			String acceptEncoding) throws Exception {
		return new EncoderEmbedder<ChannelBuffer>(new AriaEncoder());
	}

	@Override
	protected String getTargetContentEncoding(String acceptEncoding)
			throws Exception {
		return "";
	}

}
