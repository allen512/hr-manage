package com.example.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@MapperScan("com.example.spring.mapper") //"@ComponentScan"等价于<context:component-scan base-package=”com.*.*”/>
@EnableCaching
public class SpringLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);


    }
}
