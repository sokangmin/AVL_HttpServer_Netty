package com.wini.octal.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPUtil
{
	private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);
	
    public boolean FtpPut(String ip, int port, String id, String password, 
         String uploaddir, String makedir, List files) {
 
    	boolean result = false;
        FTPClient ftp = null;
        int reply = 0;
        
        try {
            ftp = new FTPClient();
            ftp.connect(ip, port);
            
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            
            if(!ftp.login(id, password)) {
             ftp.logout();
             return result;
            }

            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            ftp.changeWorkingDirectory(uploaddir);
            ftp.makeDirectory(makedir);
            ftp.changeWorkingDirectory(makedir);
            
            for(int i=0; i<files.size(); i++) {
            	String sourceFile = (String)files.get(i); // dir+file_name

            	File uploadFile = new File(sourceFile);
            	FileInputStream fis = null;
            	try {
            		fis = new FileInputStream(uploadFile);
            		boolean isSuccess = ftp.storeFile(uploadFile.getName(), fis);
            		if (isSuccess) {
                	 logger.info(sourceFile+" file upload success");
            		}
            	} catch(IOException ioe) {
            		logger.error("FTPUtil file upload error.", ioe);
            	} finally {
            		if (fis != null) try { fis.close(); } catch(IOException ioe) {}
            	}
            }
            
            ftp.logout();
            result = true;
            
        } catch (SocketException se) {
        	logger.error("FTPUtil file upload error.", se);
        } catch (IOException ioe) {
        	logger.error("FTPUtil file upload error.", ioe);
        } catch (Exception e) {
        	logger.error("FTPUtil file upload error.", e);
        } finally {
            if (ftp != null && ftp.isConnected()) try { ftp.disconnect(); } catch (IOException e) {}
        }

        return result;
    }
    
  
    public boolean FtpGet(String ip, int port, String id, String password, 
    	String localdir, List<Map<String, String>> iImageList) {
        boolean result = false;
        FTPClient ftp = null;
        int reply = 0;
        
        if(iImageList.size() > 0) {
	        try {
	            ftp = new FTPClient();
	            
	            //FTPClientConfig conf = new
				//FTPClientConfig(FTPClientConfig.SYST_NT); // Window type
	            FTPClientConfig conf = new FTPClientConfig(
	            FTPClientConfig.SYST_UNIX); // Unix type
				ftp.configure(conf);
				ftp.setControlEncoding("UTF-8");
				ftp.connect(ip, port);
	            
	            reply = ftp.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftp.disconnect();
	                return result;
	            }
	             
	            if(!ftp.login(id, password)) {
	             ftp.logout();
	             return result;
	            }
	
	            ftp.setFileType(FTP.BINARY_FILE_TYPE);
	            ftp.enterLocalPassiveMode();	            
	
	//            ftp.changeWorkingDirectory(serverdir);
	
	            for (Map<String, String> iItem : iImageList) {
		            File f = new File(localdir, iItem.get("FILE_NAME"));
		            FileOutputStream fos = null;
		            try {
		                fos = new FileOutputStream(f);
		               // String filepath = iItem.get("FILE_PATH") + iItem.get("FILE_NAME");
		                boolean isSuccess = ftp.retrieveFile(iItem.get("FILE_PATH") + iItem.get("FILE_NAME"), fos);
		                if (isSuccess) {
		                	logger.info(iItem.get("FILE_NAME") + " download success.");
		                } else {                    
		                	logger.info("Download fail.");
		                }
		            } catch(IOException ioe) {
		            	logger.error("FTPUtil file download error.", ioe);
		            } finally {
		                if (fos != null) try { fos.close(); } catch(IOException ex) {}
		            }
	            }
	            
	            ftp.logout();
	            result = true;
	        } catch (SocketException se) {
	        	logger.error("FTPUtil file download error.", se);
	        } catch (IOException ioe) {
	        	logger.error("FTPUtil file download error.", ioe);
	        } catch (Exception e) {
	        	logger.error("FTPUtil file download error.", e);
	        } finally {
	            if (ftp != null && ftp.isConnected()) try { ftp.disconnect(); } catch (IOException e) {}    
	        }
        }

        return result;
    }
}   
