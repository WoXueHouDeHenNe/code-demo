package com.example.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/message")
public class SpringBootI18nController {
    @Resource
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @GetMapping("/{locale}")
    public String getMessage(@PathVariable String locale) {
        Locale region = null;
        if ("zh".equals(locale)) {
            region = Locale.CHINA;
        } if ("us".equals(locale)) {
            region = Locale.US;
        }

        System.out.println(region);

        String message = resourceBundleMessageSource.getMessage("MESSAGE", null, region);
        System.out.println(message);

        return message;
    }
}
