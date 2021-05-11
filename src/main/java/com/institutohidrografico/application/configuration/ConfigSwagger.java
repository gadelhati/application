package com.institutohidrografico.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	19/06/2020
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@Configuration
@EnableSwagger2
public class ConfigSwagger {
    private static final String BASE_PACKAGE = "com.institutohidrografico.application";
    private static final String TITLE = "Api Documentation";
    private static final String DESCRIPTION = "API Manager";
    private static final String VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Marcelo Gadelha";
    private static final String CONTACT_URL = "github.com/gadelhati";
    private static final String CONTACT_EMAIL = "gadelha.ti@gmail.com";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
                .build();

    }
}