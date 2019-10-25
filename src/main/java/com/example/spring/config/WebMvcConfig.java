package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * "@Configuation"等价于<Beans></Beans>
 * "@Bean"等价于<Bean></Bean>
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
}
