package com.example.demo.infrastructure.configuration;

import com.example.demo.service.PrajituraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PrajituraConfig {
    @Value("${addressservice.base.url}")
    private String addressBaseUrl;

//    @Bean
//    public PrajituraService prajituraBean() {
//        return new PrajituraService();
//    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(addressBaseUrl).build();
    }

}