package com.reiras.redisscorerank.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)				
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.reiras.redisscorerank.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Score Rank",
				"Register score points and rank users with Redis",
				"Version 1.0",
				"https://github.com/reirasdev/score-rank",
				new Contact("Raphael Eiras", "https://www.linkedin.com/in/reirasdev/", "reiras.dev@gmail.com"),
				"Allowed copy for students and development professionals",
				"https://github.com/reirasdev/score-rank",
				Collections.emptyList()
		);
	}

}
