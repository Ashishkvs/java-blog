package com.imagegrafia.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerDocketConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select() //Api selector builder
				.paths(PathSelectors.ant("/api/*")) //include only baser-url with this
				.apis(RequestHandlerSelectors.basePackage("com.imagegrafia.blog")) //filter spring based docs like error
				.build()
				.apiInfo(apiDetails()); //api documentation meta-deta
	}
	
	private ApiInfo apiDetails() {
		ApiInfo apiInfo =new ApiInfo("Imagegrafia Blog API", "Java based blog system", "1.0", "https:www.imagegrafia.com/terms", "Ashish Yadhuvanshi", "Api License", "https:www.imagegrafia.com/license");
					return apiInfo;
	}
}
