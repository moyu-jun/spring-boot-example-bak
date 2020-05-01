package com.james.example.boot.singleton.ioc.service;

/**
 * @author James
 * @date 2020/4/28
 */
public interface UserService {

    /**
     * 获取用户信息
     *
     * @return
     */
    String getUser();

    /**
     * 获取用户信息，从 DAO 层获取数据
     *
     * @return
     */
    String getUserForDao();
}
