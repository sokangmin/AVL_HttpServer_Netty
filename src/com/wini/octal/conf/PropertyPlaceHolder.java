package com.wini.octal.conf;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class PropertyPlaceHolder extends PropertyPlaceholderConfigurer {
	
	public PropertyPlaceHolder() {
        this.setLocation(new ClassPathResource("App.properties"));
    }
}
