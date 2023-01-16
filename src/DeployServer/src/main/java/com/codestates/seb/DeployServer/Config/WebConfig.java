package com.codestates.seb.DeployServer.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Value("${config.domain}")
  private String domain;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins(domain).allowedMethods("GET", "POST", "OPTIONS").allowCredentials(true)
        .exposedHeaders("authorization");
  }
}