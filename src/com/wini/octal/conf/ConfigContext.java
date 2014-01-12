package com.wini.octal.conf;

import kr.re.nsri.ARIAEngine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public enum ConfigContext {
	CONFIG_INSTNACE;
	
	private ApplicationContext context = new AnnotationConfigApplicationContext(
			AppConfig.class);
	
	public ThreadPoolTaskScheduler getThreadPool() {
		return (ThreadPoolTaskScheduler) context.getBean("taskScheduler");
	}
	
	public ApplicationContext getContext() {
		return context;
	}
	
	public Runnable getService(String service, Object... args) {
		return (Runnable) context.getBean(service,args);
	}
	
	public ARIAEngine getAriaEngine() {
		return (ARIAEngine) context.getBean("getAriaEngine");
	}
	
	public String getProperty(String name) {
		return (String)context.getBean(name);
	}
	
	public int getProperty2Int(String name) {
		return Integer.parseInt((String) context.getBean(name));
	}
	
	
}
