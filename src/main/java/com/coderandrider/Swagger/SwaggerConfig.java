package com.coderandrider.Swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("Swagger API Documentations")
						.description("Swagger documentation using spring boot.")
						.version("1.0.0")
						.contact(new Contact()
								.name("Shubham Meshram")
								.email("shubhammeshram0099@gmail.com")
								.url("http://shubhammeshram.org"))
						.license(new License()
								.name("Apache License, Version 2.0")
								.url("http://www.apache.org/licenses/")));
	}
}
