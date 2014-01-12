package com.wini.octal.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPUtil {
	private static final Logger logger = LoggerFactory.getLogger(SFTPUtil.class);
	private Session session = null;

	private Channel channel = null;
	private ChannelSftp channelSftp = null;
	
	public boolean init(String host, String userName, String password, int port) {
	    JSch jsch = new JSch();
	    try {
	    	session = jsch.getSession(userName, host, port);
	    	session.setPassword(password);
	
	    	java.util.Properties config = new java.util.Properties();
	    	config.put("StrictHostKeyChecking", "no");
	    	session.setConfig(config);
	    	session.connect();
	
	    	channel = session.openChannel("sftp");
	    	channel.connect();
	     } catch (JSchException e){
	    	 logger.error("SFTPUtil Error.", e);
	    	 return false;
	     }
	     
	     channelSftp = (ChannelSftp) channel;
	     
	     return true;
	 }
	
	
	public void upload(String dir, File file) {
		FileInputStream in = null;
	    try {
	        in = new FileInputStream(file);
	        channelSftp.cd(dir);
	        channelSftp.put(in, file.getName());
	    } catch (SftpException e) {
	        logger.error("SFTP Upload Error.", e);
	    } catch (FileNotFoundException e) {
	    	logger.error("SFTP Upload Error.", e);
	    } finally {
	    	if( in != null) try {in.close();} catch (IOException e) {}
	    }
	}
	 
	
	public void download(List<Map<String, String>> iImageList, String path) {
		/*boolean result = false;        
		int reply = 0; */ 
		
		if(iImageList.size() > 0) {
			try {
				for (Map<String, String> iItem : iImageList) {					
						download(iItem.get("FILE_PATH"), iItem.get("FILE_NAME"), path);
				}	
				
			} catch (Exception e) {
				logger.error("SFTP Download Error.", e);
			}
		} 
	}
	 
	 public void download(String dir, String downloadFileName, String path) {
	     InputStream in = null; 
	     FileOutputStream out =null;
	     try {
	         channelSftp.cd(dir);
	         in = channelSftp.get(downloadFileName);
	  
	         out = new FileOutputStream(new File(path+downloadFileName));
	         int i;
	
	         while ((i = in.read()) != -1) {
	        	 out.write(i);
	         }
	     } catch (SftpException e) {
	    	 logger.error("SFTP Download Error.", e);
	     } catch (IOException e) {
	    	 logger.error("SFTP Download Error.", e);
	     } finally {
	    	 if ( in != null) try {in.close();} catch (IOException e) {}
	    	 if ( out != null) try {out.close();} catch (IOException e) {}
	     }
	 }
	
	 public void disconnection() {
		 channelSftp.disconnect();
		 channelSftp.quit();	     
	 }
}
