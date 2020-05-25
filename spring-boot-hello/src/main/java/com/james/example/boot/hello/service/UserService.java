package com.james.example.boot.hello.service;

import com.james.example.boot.hello.domain.response.UserResponse;

/**
 * 用户操作的逻辑层，接口定义
 *
 * @author James
 * @date 2020/5/25
 */
public interface UserService {

    /**
     * 通过用户 ID 获取用户信息
     *
     * @param id 用户 ID
     * @return
     */
    UserResponse getUser(Long id);
}
