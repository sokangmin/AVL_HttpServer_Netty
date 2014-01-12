package com.wini.octal.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.activation.MimetypesFileTypeMap;

import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wini.octal.exception.HttpFileNotFound;

@Component
@Scope("prototype")
public class NGAVL_StaticSVC extends SvcIF implements Runnable {
	private File file = null;
	
	public NGAVL_StaticSVC(MessageEvent e, HttpRequest request, File file) {
		this.e = e;
		this.request = request;
		this.file = file;
	}
	
	@Override
	public void run() {
		String mimeType = new MimetypesFileTypeMap().getContentType(file);
		FileInputStream in = null;
		byte[] bytes = new byte[(int) file.length()];
		try {
			in = new FileInputStream(file);
			in.read(bytes);
	
			writeResponse(e, mimeType, bytes);
		} catch (IOException exception) {
			logger.error("Unexpected HttpFileNotFoundException.", exception.getCause());
			throw new HttpFileNotFound(e, exception);
		} finally {
			if(in != null) try {in.close();} catch (IOException e) {}
		}
	}

}
