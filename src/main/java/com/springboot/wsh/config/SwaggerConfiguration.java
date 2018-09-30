package com.springboot.wsh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: SwaggerConfiguration
 * @ProjectName springboot_swagger
 * @Description: Swagger配置类
 * @Author WeiShiHuai
 * @Date 2018/9/29 17:36
 * <p>
 * 说明: Swagger2可以帮助我们快速生成API接口文档，方便我们进行调试。只需要在对应的Controller方法上加上一些注解即可，
 * 访问地址: http://主机名称:端口号/swagger-ui.html  ( 如：http://localhost:8080/swagger-ui.html)
 */
//@Configuration表示这是一个配置类
@Configuration
//@EnableSwagger2: 开启Swagger2生成api文档功能
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * 配置api信息(标题、描述、版本号等)
     *
     * @return api信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("使用Swagger2生成API接口文档")   //标题
                .description("swagger2提供了强大的接口文档功能，方便接口调试")  //描述信息
                .version("1.0")   //版本号
                .termsOfServiceUrl("https://blog.csdn.net/Weixiaohuai")  //服务URL地址
                .build();
    }

    /**
     * 配置Docket对象，配置一些信息(文档类型、api信息、生成接口文档需要扫描的包等)
     *
     * @return Docket对象
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)  //指定文档类型
                .apiInfo(apiInfo()) //指定Api相关信息
                .select()  //选择那些路径和api会生成文档
                .apis(RequestHandlerSelectors.basePackage("com.springboot.wsh.controller"))  //指定生成文档扫描的包
                .paths(PathSelectors.any())  //指定对所有路径进行监控
                .build();

    }

}
