package com.github.allanccruz.POC1.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("POC1 - Invillia API")
                        .description("API to register a customer with up to 5 addresses")
                        .version("v0.0.1"));
    }
}
