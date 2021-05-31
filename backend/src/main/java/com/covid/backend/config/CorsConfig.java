package com.covid.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //frontend port
                .allowedOrigins("http://localhost:8080")//modified!
                .allowedMethods("*")
                .allowedHeaders("*")
                //false is optional
                .allowCredentials(true);
    }
}
