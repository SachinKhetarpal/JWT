package com.sachinkhetarpal.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class JwtApplication {

    public static String DBUSER = System.getenv("DBUSER");
    public static void main(String[] args) {
        System.out.println("SACHIN="+DBUSER);
        SpringApplication.run(JwtApplication.class, args);
    }


}
