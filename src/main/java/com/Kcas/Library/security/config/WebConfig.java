package com.Kcas.Library.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;


@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public TemplateEngine templateEngine() {
        return new TemplateEngine();
    }


}
