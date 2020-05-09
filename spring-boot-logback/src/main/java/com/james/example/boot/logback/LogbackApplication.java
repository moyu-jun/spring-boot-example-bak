package com.james.example.boot.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 *
 * @author James
 * @date 2020/5/9
 */
@SpringBootApplication
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }
}
