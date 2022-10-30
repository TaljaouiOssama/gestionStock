package com.ossama.gestionstock.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.ossama.gestionstock.other.Constants.APP_ROOT;

//@Configuration
public class SwaggerConfiguration {
//    public  Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(
//                new ApiInfoBuilder()
//                    .description("GestionStock API Documentation")
//                        .title("GestionStock REST API")
//                        .build()
//        )
//        .groupName("REST API V1")
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("com.ossama.gestionstock"))
//        .paths(PathSelectors.ant(APP_ROOT+"/**"))
//        .build();
//    }
//    @Bean
//    public GroupedOpenApi publicApi() {
//        System.out.println("GroupedOpenApi");
//        return GroupedOpenApi.builder()
//                .group("REST API V1")
//                .pathsToMatch("com.ossama.gestionstock")
//                .build();
//    }
}
