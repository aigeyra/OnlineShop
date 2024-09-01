package com.example.onlineshop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Product API",
                description = "API for managing products",
                version = "v1"
        )
)
public class OpenApiConfig {
}