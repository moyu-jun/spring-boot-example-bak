package com.james.example.boot.nginx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 *
 * @author James
 * @date 2020/5/9
 */
@SpringBootApplication
public class NginxApplication {
    public static void main(String[] args) {
        SpringApplication.run(NginxApplication.class, args);
    }
}
