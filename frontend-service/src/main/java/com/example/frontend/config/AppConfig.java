package com.example.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);   // Log client information
        loggingFilter.setIncludeQueryString(true);  // Log query string
        loggingFilter.setIncludeHeaders(true);      // Log HTTP headers
        loggingFilter.setIncludePayload(true);      // Log request body
        loggingFilter.setMaxPayloadLength(10000);   // Maximum length of payload to log
        return loggingFilter;
    }
}
