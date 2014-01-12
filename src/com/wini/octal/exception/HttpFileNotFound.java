package com.wini.octal.exception;

import static org.jboss.netty.handler.codec.http.HttpResponseStatus.*;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;

public class HttpFileNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private MessageEvent event;
	
	public HttpFileNotFound(MessageEvent event, Throwable cause) {
		super(cause);
		
		this.event = event;
		sendErrorMessage();
	}
	
	public HttpFileNotFound(MessageEvent event) {
		this(event, null);
	}
	
	private void sendErrorMessage() {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, NOT_FOUND);
		
		ChannelFuture future = event.getChannel().write(response);

		future.addListener(ChannelFutureListener.CLOSE);
	}
}
