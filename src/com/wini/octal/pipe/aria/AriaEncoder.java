package com.wini.octal.pipe.aria;

import kr.re.nsri.ARIAEngine;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.CharsetUtil;

import static com.wini.octal.conf.ConfigContext.*;


public class AriaEncoder extends OneToOneEncoder  {

	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {
		ChannelBuffer buffer = (ChannelBuffer)msg;
		String plainText =buffer.toString(CharsetUtil.UTF_8);
		ARIAEngine aria = CONFIG_INSTNACE.getAriaEngine();
		
		buffer.clear();
		buffer.writeBytes(aria.getEncrypt(plainText).getBytes());
	
		return buffer;
	}


}
