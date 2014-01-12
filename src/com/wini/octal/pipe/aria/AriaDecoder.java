package com.wini.octal.pipe.aria;

import kr.re.nsri.ARIAEngine;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.CharsetUtil;

import static com.wini.octal.conf.ConfigContext.*;


public class AriaDecoder extends OneToOneDecoder {

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {		
		ChannelBuffer buffer = (ChannelBuffer)msg;
		String cyperText = buffer.toString(CharsetUtil.UTF_8);
		ARIAEngine aria = CONFIG_INSTNACE.getAriaEngine();
		
		buffer.clear();
		buffer.writeBytes(aria.getDecrypt(cyperText).getBytes());
	
		return buffer;
	}

}
