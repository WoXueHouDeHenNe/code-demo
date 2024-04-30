package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageI18NConfig {
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource () {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource() ;
        resourceBundleMessageSource.setBasename ("messages/message" ) ;
        // 设置默认地区为中国
        resourceBundleMessageSource.setDefaultLocale (Locale.US) ;
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }
}
