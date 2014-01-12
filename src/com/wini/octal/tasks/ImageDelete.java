package com.wini.octal.tasks;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ImageDelete implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(ImageDelete.class);
	
	@Override
	public void run() {
		String path;
		
		path = getClass().getResource("/").getPath()
				.replaceAll("/WEB-INF/classes/", "/")+"/NGAVL/gi_data/";
		
		logger.info("ImageDelete Start - "+ System.currentTimeMillis());
		
		deleteDir(new File(path));
		
		logger.info("ImageDelete End - "+ System.currentTimeMillis());
	}
	
	private void deleteDir(File file) {
		if(file.exists()) {
			File[] files = file.listFiles();
			
			for (File f : files) {
				if(f.isDirectory()) {
					deleteDir(f);
				} else {
					Calendar startCal = new GregorianCalendar();
					startCal.setTimeInMillis(f.lastModified());
					long startTime = startCal.getTime().getTime();
					
					Calendar endCal = Calendar.getInstance();
					long endTime = endCal.getTime().getTime();
					
					long min = (endTime - startTime) / 60000;
					
					// 60 * 24 = 1day
					if (min > (60*24)) f.delete();
				}
				
			}
		}
	}

}
