package com.example.demo.config;

import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class MessageI18NConfig {
    /**
     * 国际化配置
     * @return
     */
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource() ;
        resourceBundleMessageSource.setBasename ("messages/message" ) ;
        // 设置默认地区为中国
        resourceBundleMessageSource.setDefaultLocale (Locale.US) ;
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        // 设置快速失败，Hibernate 验证框架默认验证所有字段设置的所有规则，并返回错误集合。
        // 快速失败则是只要验证时出现一个错误，立马返回，不执行后面的验证规则
        factoryBean.getValidationPropertyMap().put("hibernate.validator.fail_fast", "true");
        //为Validator配置国际化
        factoryBean.setValidationMessageSource(resourceBundleMessageSource());
        return factoryBean;
    }
}
