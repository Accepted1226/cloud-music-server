package com.xxx;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("com.xxx.**.mapper")
public class MusicServerApplication {
    @Bean
    public Interceptor[] plugins() {
        return new Interceptor[]{new PageInterceptor()};
    }


    public static void main(String[] args) {
    SpringApplication.run(MusicServerApplication.class, args);
        System.out.println("访问swagger地址：http://localhost:8888/doc.html");

    }
}
