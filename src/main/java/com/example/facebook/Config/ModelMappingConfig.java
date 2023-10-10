package com.example.facebook.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {
  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
