package org.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Projeto Blog Pessoal")
						.description("Projeto para postagens de diversos temas")
						.version("v0.0.1")
						.license(new License()
								.name("Generation Brasil")
								.url("https://brazil.generation.org/"))
						.contact(new Contact()
								.name("Github Anderson")
								.url("https://github.com/yMendyllKDll")
								.email("and_mendescosta@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github Project")
						.url("https://github.com/yMendyllKDll/BlogPessoal"));					
	}

	@Bean
	public OpenApiCustomiser customerGlobalResponseStatus() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				ApiResponses api = operation.getResponses();
				
				api.addApiResponse("200", createApiResponse("Sucesso!"));
				api.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				api.addApiResponse("204", createApiResponse("Objeto Excluido!"));
				api.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				api.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				api.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				api.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);

	}
}
