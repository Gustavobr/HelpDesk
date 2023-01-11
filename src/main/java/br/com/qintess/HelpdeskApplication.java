package br.com.qintess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);

	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Api").version("1.1.0").description("API - HelpDesk.")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

	/*
	@SuppressWarnings("deprecation")
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("HelpDesk - API").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.qintess.service.")).paths(PathSelectors.any()).build();

	}

	@Bean

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("HelpDesk - API").description("HelpDesk App")
				.licenseUrl("http://localhost:8080").version("1.1.0").build();

	}
	
	*/

}
