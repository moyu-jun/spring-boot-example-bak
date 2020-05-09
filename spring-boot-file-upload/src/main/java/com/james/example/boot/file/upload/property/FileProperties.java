package com.james.example.boot.file.upload.property;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件相关的配置参数
 *
 * @author James
 * @date 2020/5/9
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
