package com.james.example.boot.file.upload.exception;

/**
 * 文件操作异常
 *
 * @author James
 * @date 2020/5/9
 */
public class FileException extends RuntimeException{
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
