package com.james.example.boot.hello.dao;

import com.james.example.boot.hello.domain.User;

/**
 * 用户相关的数据访问层，负责从数据源中新增、查询、修改、删除等
 * 直接与数据源交互，数据源可为数据库、缓存、ES 等
 *
 * @author James
 * @date 2020/5/25
 */
public interface UserDao {
    /**
     * 从数据库通过用户 ID 获取用户信息
     *
     * @param id 用户 ID
     * @return
     */
    User selectUser(Long id);

    /**
     * 插入用户信息
     *
     * @param user 用户信息
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 需要更新的用户信息
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户 ID 删除用户信息
     *
     * @param id 用户 ID
     * @return
     */
    int deleteUser(Long id);
}
