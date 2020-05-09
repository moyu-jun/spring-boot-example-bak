package com.james.example.boot.file.upload;

import com.james.example.boot.file.upload.property.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Spring Boot 启动类
 *
 * @author James
 * @date 2020/5/9
 */
@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
})
public class FileUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }
}
