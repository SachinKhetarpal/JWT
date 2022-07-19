package com.sachinkhetarpal.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKeys(){
        return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
    }

    private List<SecurityContext> securityContexts(){
        return Arrays.asList(SecurityContext.builder().securityReferences(securityReferences()).build());
    }
    private List<SecurityReference> securityReferences(){
        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
        return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[]{scope}));
    }

    @Bean
    public Docket swaggerConfiguration(){

       return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Arrays.asList(apiKeys()))
                .securityContexts(securityContexts())
                .select()
                .paths(PathSelectors.ant("/*"))
                .apis(RequestHandlerSelectors.basePackage("com.sachinkhetarpal.jwt.controller"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Sachin API",
                "Sample data",
                "1.0",
                "Free to use",
                new Contact("Sachin Khetarpal","sachinkhetarpal.com","abc@gmail.com"),
                "",
                "",
                Collections.emptyList());

    }
}
