package com.wini.octal.pipe;
/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


import static org.jboss.netty.handler.codec.http.HttpHeaders.*;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.*;
import static org.jboss.netty.handler.codec.http.HttpVersion.*;
import static com.wini.octal.conf.ConfigContext.*;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

/*import kr.re.nsri.ARIAEngine;*/

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpChunk;
import org.jboss.netty.handler.codec.http.HttpChunkTrailer;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wini.octal.exception.HttpFileNotFound;
import com.wini.octal.services.NGAVL_StaticSVC;

public class HttpServerHandler extends SimpleChannelUpstreamHandler {

    private boolean readingChunks;
    /** Buffer that stores the response content */
    private final StringBuilder buf = new StringBuilder();
    
    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    
    @Override
    public void handleUpstream(
            ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof ChannelStateEvent) {
            logger.info(e.toString());
        }
        super.handleUpstream(ctx, e);
    }
    
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    	// Transfer-Encoding: chunked == N
    	if (!readingChunks) {
            HttpRequest request = (HttpRequest) e.getMessage();

            // Http헤더에 다음과 같은 헤더가 포함되고 request body가 넘어오지 않는 경우가 있음
            // Expect: 100-continue
            // cli가 Header를 먼저 보내서 serv의 allow여부에 따라 request body를 넘길지 판단
            if (is100ContinueExpected(request)) {
                send100Continue(e);
            }
            
            if (request.isChunked()) {
                readingChunks = true;
            } else {
                String method = request.getMethod().getName();
                String uri = request.getUri();
                String[] uriTokens;
                int lenTokens;
                
                // only NGAVL
                if(uri.startsWith("NGAVL", 1)) {
	                if(method.equalsIgnoreCase("POST")) {
	                    // requst uri : /NGAVL/ws/SQL.CONFIG.NGAVL_VL00001.service
	                	uriTokens = StringUtils.split(uri, "[/.]");
	                    lenTokens = uriTokens.length;
	                    /*String svcExt = uriTokens[lenTokens - 1];*/
	                	String svcNm = uriTokens[lenTokens - 2];
	                	
	                	// proxy service
	                    if(svcNm.equalsIgnoreCase("service")) {
	                		ChannelBuffer buffer = (ChannelBuffer)request.getContent();
	                		String param =buffer.toString(CharsetUtil.UTF_8);
	                		param = param.substring(param.indexOf("=")+1);

	                		@SuppressWarnings("unchecked")
							HashMap<String, String> map = gson.fromJson(param, java.util.HashMap.class);
	                		
	                		svcNm = map.get("ServiceNm");
	                		svcNm = svcNm.substring(svcNm.lastIndexOf(".")+1);
	               
	                		buffer.clear();
	                		buffer.writeBytes(param.getBytes());
	                		request.setContent(buffer);                		
	                	} 
	                   
	                    try {	                		
	                		Runnable task = CONFIG_INSTNACE
	                				.getService(svcNm, e, request);
	                	
	                		CONFIG_INSTNACE.getThreadPool().execute(task);
	                	} catch (BeansException excp) {
	                		throw new HttpFileNotFound(e);
	                	}
	              
	                } 
	                else if(method.equalsIgnoreCase("GET")) {
	                	// request uri : /NGAVL/[AAA]/[BBB.CCC] 
	                	URL url = getClass().getResource(uri);
	                	if(url == null) throw new HttpFileNotFound(e);
	                	
	                	File file = new File(url.getPath());
	                	if(file.exists()) {
	                		Runnable task = CONFIG_INSTNACE
		                			.getService(NGAVL_StaticSVC.class.getName(), 
		                					e, request, file);
		                	
	                		CONFIG_INSTNACE.getThreadPool().execute(task);
	                	} else {
	                		throw new HttpFileNotFound(e);
	                	}
	                	
	                }
	                // else request Not Found 
	                else {
	                	throw new HttpFileNotFound(e);
	                }
                }
            }
        } 
    	// Transfer-Encoding: chunked == Y
    	else {
            HttpChunk chunk = (HttpChunk) e.getMessage();
            if (chunk.isLast()) {
                readingChunks = false;
                buf.append("END OF CONTENT\r\n");

                HttpChunkTrailer trailer = (HttpChunkTrailer) chunk;
                if (!trailer.getHeaderNames().isEmpty()) {
                    buf.append("\r\n");
                    for (String name: trailer.getHeaderNames()) {
                        for (String value: trailer.getHeaders(name)) {
                            buf.append("TRAILING HEADER: " + name + " = " + value + "\r\n");
                        }
                    }
                    buf.append("\r\n");
                }

                //writeResponse(e);
            } else {
                buf.append("CHUNK: " + chunk.getContent().toString(CharsetUtil.UTF_8) + "\r\n");
            }
        }
    }


    private static void send100Continue(MessageEvent e) {
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
        e.getChannel().write(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
            throws Exception {
        logger.error("Unexpected exception from downstream.", e.getCause());
        e.getChannel().close();
    }
}
