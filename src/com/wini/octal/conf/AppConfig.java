package com.wini.octal.conf;

import java.security.InvalidKeyException;

import kr.re.nsri.ARIAEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@ComponentScan(basePackages={"com.wini.octal.services", 
		"com.wini.octal.conf"})
public class AppConfig {
	@Value("${ssl.keystore.path}")
	private String SslKeyStorePath;
	
	@Value("${ssl.keystore.password}")
	private String SslKeystorePassword;
	
	@Value("${ssl.certificate.password}")
	private String SslCertificatePassword;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${ftp.ip}")
	private String ftp_ip;
	
	@Value("${ftp.port}")
	private String ftp_port;
	
	@Value("${ftp.id}")
	private String ftp_id;
	
	@Value("${ftp.pwd}")
	private String ftp_password;
	
	@Value("${ftp.type}")
	private String ftp_type;
	
	@Value("${ftp.ftp_download_hour}")
	private String ftp_download_hour;
	
	@Value("${ftp.ftp_download_minute}")
	private String ftp_download_minute;
	
	@Value("${tis.ip}")
	private String tis_ip;
	
	@Value("${tis.port}")
	private String tis_port;
	
	private Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	/*@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(100);
		pool.setMaxPoolSize(150);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		
		return pool;
	}*/
	
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
		pool.setPoolSize(30);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		
		return pool;
	}
	
	@Bean
	public ARIAEngine getAriaEngine() {
		ARIAEngine aria = null;
		try {
			aria = new ARIAEngine(256);
		} catch (InvalidKeyException e) {
			logger.error("AriaEngine InvalidKey", e.getCause());
		}
		
		return aria;
	}
	
	@Bean
	public String getSslKeyStorePath() {
		return SslKeyStorePath;
	}
	
	@Bean
	public String getSslKeyStorePassword() {
		return SslKeystorePassword;
	}
	
	@Bean
	public String getSslcertificatePassword() {
		return SslCertificatePassword;
	}
	
	@Bean
	public String getServerPort() {
		return port;
	}
	
	@Bean
	public String getFtpDownloadHour() {
		return ftp_download_hour;
	}
	
	@Bean
	public String getFtpDownloadMinute() {
		return ftp_download_minute;
	}
	
	@Bean
	public String getTisIp() {
		return tis_ip;
	}
	
	@Bean
	public String getTisPort() {
		return tis_port;
	}
	
	@Bean
	public String getFtpIp() {
		return ftp_ip;
	}
	
	@Bean 
	public String getFtpPort() {
		return ftp_port;
	}
	
	@Bean
	public String getFtpId() {
		return ftp_id;
	}
	
	@Bean
	public String getFtpPassword() {
		return ftp_password;
	}
	
	@Bean 
	public String getFtpType() {
		return ftp_type;
	}
}
