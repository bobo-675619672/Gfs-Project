package com.dw.gfs.taskcenter.config;

import com.dw.gfs.common.annotation.EnableBeanValidator;
import com.dw.gfs.common.utils.TokenUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableKnife4j
@EnableSwagger2
@EnableBeanValidator
public class SwaggerConfig {

    @Autowired
    private ServletContext servletContext;

    @Bean(value = "taskcenterApi")
    @Order(value = 1)
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/taskcenter";
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dw.gfs.taskcenter.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(getHeader());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("作业中心接口")
                .description("作业中心接口swagger")
                .termsOfServiceUrl("http://localhost:8930/")
                .contact(new Contact("liaodewen", "" , "675619672@qq.com"))
                .version("1.0") .build();
    }

    private List<Parameter> getHeader(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = newArrayList();
        parameterBuilder.name(TokenUtil.TOKEN_NAME)
                .description("By Access Token")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }

}
