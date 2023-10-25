package com.henriquebarucco.api.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server serverLocal = new Server();
        serverLocal.setUrl("/");
        serverLocal.setDescription("Local");

        Server serverDev = new Server();
        serverDev.setUrl("/");
        serverDev.setDescription("Desenvolvimento");

        Server serverProd = new Server();
        serverProd.setUrl("/");
        serverProd.setDescription("Produção");

        Info info = new Info()
                .title("Henrique API")
                .version("1.0.0")
                .description("API de exemplo utilizando Spring Boot e Swagger com autenticação JWT.")
                .termsOfService("https://henriquebarucco.com.br/");

        return new OpenAPI().info(info).servers(List.of(serverLocal, serverDev, serverProd));
    }
}
