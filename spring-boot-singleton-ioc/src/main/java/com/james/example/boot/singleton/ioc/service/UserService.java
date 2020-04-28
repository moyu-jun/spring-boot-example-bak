package com.james.example.boot.singleton.ioc.service;

/**
 * @author James
 * @date 2020/4/28
 */
public interface UserService {

    /**
     * 获取用户信息
     *
     * @return  @link{String}
     */
    String getUser();

    /**
     * 获取用户信息
     *
     * @return  @link{String}
     */
    String getUserForDao();
}
