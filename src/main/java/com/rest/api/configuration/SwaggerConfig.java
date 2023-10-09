package com.rest.api.configuration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	  public GroupedOpenApi publicApi() {
	   return GroupedOpenApi.builder()
			   .group("com.rest.api.controller")
			   .packagesToScan("com.rest.api.controller")
			   .build();
	  }
	
	@Bean OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info().title("Users Rest Api")
				.description("SpringBoot Application Test.")
				.version("v1.0.0")
				.license(new License()
						.name("Carlos Mendoza")
						.url("https://github.com/CarMata/")));
		
	}
}
