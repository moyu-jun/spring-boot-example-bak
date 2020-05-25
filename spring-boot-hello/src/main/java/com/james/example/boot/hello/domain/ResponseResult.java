package com.james.example.boot.hello.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用请求返回对象
 *
 * @author James
 * @date 2020/5/16
 */
@Data
@EqualsAndHashCode
@ToString
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 5805390369358950390L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回数据对象
     */
    private Object data;

    public ResponseResult() {
    }

    /**
     * 根据通用状态码实例化返回数据对象
     * 无返回数据
     *
     * @param responseCode 通用状态码
     */
    public ResponseResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    /**
     * 根据通用状态码实例化返回数据对象
     * 使用自定义 message
     *
     * @param responseCode 通用状态码
     * @param message      自定义 message
     */
    public ResponseResult(ResponseCode responseCode, String message) {
        this.code = responseCode.getCode();
        this.message = message;
    }

    /**
     * 根据通用状态码实例化返回数据对象
     * 添加返回数据
     *
     * @param responseCode 通用状态码
     * @param data         需要返回的数据
     */
    public ResponseResult(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    /**
     * 根据通用状态码实例化返回数据对象
     * 使用自定义 message, 但不建议！！
     * 添加返回数据
     *
     * @param responseCode 通用状态码
     * @param message      自定义 message
     * @param data         需要返回的数据
     */
    public ResponseResult(ResponseCode responseCode, String message, Object data) {
        this.code = responseCode.getCode();
        this.message = message;
        this.data = data;
    }

    /**
     * 请求正常返回
     * 使用默认的返回码及消息
     */
    public static ResponseResult ok() {
        return new ResponseResult(ResponseCode.SUCCESS);
    }

    /**
     * 请求正常返回
     * 使用默认的返回码及消息
     * 附带返回数据
     *
     * @param message 通用状态码
     */
    public static ResponseResult ok(String message) {
        return new ResponseResult(ResponseCode.SUCCESS, message);
    }

    /**
     * 请求正常返回
     * 使用默认的返回码及消息
     * 附带返回数据
     *
     * @param data 通用状态码
     */
    public static ResponseResult ok(Object data) {
        return new ResponseResult(ResponseCode.SUCCESS, data);
    }

    /**
     * 请求正常返回
     * 使用默认的返回码，自定义消息
     * 附带返回数据
     *
     * @param message 自定义消息
     * @param data    通用状态码
     */
    public static ResponseResult ok(String message, Object data) {
        return new ResponseResult(ResponseCode.SUCCESS, message, data);
    }

    /**
     * 请求返回异常
     * 默认状态码为系统异常
     */
    public static ResponseResult error() {
        return new ResponseResult(ResponseCode.SYSTEM);
    }

    /**
     * 请求返回异常
     *
     * @param message 错误消息
     */
    public static ResponseResult error(String message) {
        return new ResponseResult(ResponseCode.SYSTEM, message);
    }

    /**
     * 请求返回异常
     *
     * @param responseCode 通用异常状态码
     */
    public static ResponseResult error(ResponseCode responseCode) {
        return new ResponseResult(responseCode);
    }

    /**
     * 请求返回异常
     *
     * @param responseCode 通用异常状态码
     * @param message      自定义错误消息
     */
    public static ResponseResult error(ResponseCode responseCode, String message) {
        return new ResponseResult(responseCode, message);
    }

    /**
     * 请求返回异常
     *
     * @param responseCode 通用异常状态码
     * @param data         携带数据
     */
    public static ResponseResult error(ResponseCode responseCode, Object data) {
        return new ResponseResult(responseCode, data);
    }

    /**
     * 请求返回异常
     *
     * @param responseCode 通用异常状态码
     * @param message      自定义错误消息
     * @param data         携带数据
     */
    public static ResponseResult error(ResponseCode responseCode, String message, Object data) {
        return new ResponseResult(responseCode, message, data);
    }

}
