package com.jstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de documentación OpenAPI para Swagger.
 *
 * @author Juan Salgado
 * @version 1.0
 */
@Configuration
public class OpenApiConfig {


    /**
     * Configuración general de la API.
     *
     * @return información de la API.
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("JStore Backend API")
                                .version("1.0")
                                .description(
                                        "API REST para la gestión de productos " +
                                        "de la tienda online JStore"
                                )
                );
    }

}
