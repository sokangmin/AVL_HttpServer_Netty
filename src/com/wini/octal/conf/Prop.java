package com.wini.octal.conf;

public final class Prop {
	private Prop(){}
	
	// SERVER
	public static final String ServerPort = "getServerPort";
	
	// FTP
	public static final String FtpDownLoadHour = "getFtpDownloadHour";
	public static final String FtpDownLoadMinute = "getFtpDownloadMinute";
	public static final String FtpIp = "getFtpIp";
	public static final String FtpPort = "getFtpPort";
	public static final String FtpId = "getFtpId";
	public static final String FtpPasswd = "getFtpPassword";
	public static final String FtpType = "getFtpType";
	
	// SSL
	public static final String KeyStorePath = "getSslKeyStorePath";
	public static final String KeyStorePasswd = "getSslKeyStorePassword";
	public static final String CertificatePasswd = "getSslcertificatePassword";
	
	// TIS
	public static final String TisIp = "getTisIp";
	public static final String TisPort = "getTisPort";
}
