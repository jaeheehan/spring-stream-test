package com.vkein.springstreamtest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("API Document")
                .version("v1.0")
                .description("API 명세서입니다.");

        return new OpenAPI()
                .components(new Components())
                //.addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .info(info);
    }

}
