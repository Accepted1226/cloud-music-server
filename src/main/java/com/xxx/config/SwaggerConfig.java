package com.xxx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2 // 开启Swagger2的自动配置
public class SwaggerConfig {
    // 配置docket以配置Swagger具体参数
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("公瑾")  // 配置分组,默认是default
                .enable(flag) // 配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select() // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                // .apis(RequestHandlerSelectors.basePackage("com.xxx.admin.controller"))
                .apis(RequestHandlerSelectors.basePackage("com.xxx.customer.controller"))
                .build();

    }

    private ApiInfo apiInfo() {
        Contact DEFAULT_CONTACT = new Contact("公瑾", "http://localhost:8081/", "1378291419@qq.com");
        return new ApiInfo("公瑾的SwaggerAPI文档",  // 标题
                "世间万物,可期不渴望!",    // 描述
                "1.0", //版本
                "http://www.baidu.com/", // 组织链接
                DEFAULT_CONTACT,  //联系人信息
                "Apache 2.0",  // 许可
                "http://www.apache.org/licenses/LICENSE-2.0",  // 许可链接
                new ArrayList()); // 扩展
    }

}
