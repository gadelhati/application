package com.institutohidrografico.application.configuration;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${BASE_PACKAGE}")
    private static String BASE_PACKAGE;
    @Value("${TITLE}")
    private static String TITLE;
    @Value("${DESCRIPTION}")
    private static String DESCRIPTION;
    @Value("${VERSION}")
    private static String VERSION;
    @Value("${CONTACT_NAME}")
    private static String CONTACT_NAME;
    @Value("${CONTACT_URL}")
    private static String CONTACT_URL;
    @Value("${CONTACT_EMAIL}")
    private static String CONTACT_EMAIL;
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