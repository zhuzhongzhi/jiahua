package com.xgit.iot;

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
 * 类注释
 *
 * @author: hz
 * @date: 2019/03/08
 * @since: 1.0
 */
@Configuration
@EnableSwagger2
public class IotServiceSwagger2 {
    @Bean
      public Docket createRestApi() {
              return new Docket(DocumentationType.SWAGGER_2)
                       .apiInfo(apiInfo())
                      .select()
                      .apis(RequestHandlerSelectors.basePackage("com.xgit.iot.web"))
                      .paths(PathSelectors.any())
                      .build();
            }
       private ApiInfo apiInfo() {
              return new ApiInfoBuilder()
                      //页面标题
                       .title("RESTFUL接口")
                      //描述
                      .description("设备上云API")
                      //创建人
                        .contact(new Contact("xgit","","dev@xgit.com"))
                      //版本
                         .version("1.0")
                       .build();
           }
}
