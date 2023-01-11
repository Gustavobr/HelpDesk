package br.com.qintess.configuration;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
//@EnableSwagger2
public class OpenApiConfig {

	/*
	 * @Bean public OpenAPI customOpenAPI() { return new OpenAPI().info(new
	 * Info().title("Api").version("1.1.0")
	 * .description("API de transação de pagamentos.").termsOfService(
	 * "http://swagger.io/terms/") .license(new
	 * License().name("Apache 2.0").url("http://springdoc.org"))); }
	 */

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

}
