package com.eccomerce.Ikhlas_eccomerce.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//bean will make it to be autowired anywhere
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }
}
