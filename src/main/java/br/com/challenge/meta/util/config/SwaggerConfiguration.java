package br.com.challenge.meta.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.List;

/**
 * Class that implements the necessary settings for using Swagger as an API documentation tool.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Configuration
@Profile({"dev"})
@EnableSwagger2
public class SwaggerConfiguration {

  @Value("${release.version}")
  private String releaseVersion;

  @Value("${api.version}")
  private String apiVersion;

  /**
   * Method that configure all the endpoint's mapped in the documentation.
   *
   * @author Felipe Santiago
   * @since 2021-03-12
   *
   * @return <code>Docket</code> object
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.challenge.meta.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo())
        .securityContexts(Collections.singletonList(securityContext()))
        .securitySchemes(Collections.singletonList(apiKey()))
        .directModelSubstitute(Temporal.class, String.class);
  }

  /**
   * Method that configure the information's about the API.
   *
   * @author Felipe Santiago
   * @since 2021-03-12
   *
   * @return <code>ApiInfo</code> object
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Approval Processing API")
        .description("Approval Processing Management API - Endpoint's documentation")
        .license("Apache Licence Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .version(releaseVersion.concat("_").concat(apiVersion))
        .build();
  }

  private ApiKey apiKey() {
    return new ApiKey("JWT", "Authorization", "header");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.regex("/api/.*"))
        .build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
  }
}
