package com.james.example.boot.hello.dao.impl;

import com.james.example.boot.hello.dao.UserDao;
import com.james.example.boot.hello.domain.User;
import org.springframework.stereotype.Component;

/**
 * 用户相关的数据访问层，具体实现
 *
 * @author James
 * @date 2020/5/25
 */
@Component
public class UserDaoImpl implements UserDao {

    @Override
    public User selectUser(Long id) {

        // 从数据库获取用户数据，在此不做具体实现，仅做模拟
        User user = new User();
        user.setId(1L);
        user.setUsername("James");
        user.setPassword("James-Password");
        user.setDeptId(1L);
        user.setSex((byte) 2);

        return user;
    }

    @Override
    public int insertUser(User user) {
        // 插入成功一般会返回数字 1 代表数据库受影响的行数为 1，更新、删除同理
        return 1;
    }

    @Override
    public int updateUser(User user) {
        return 1;
    }

    @Override
    public int deleteUser(Long id) {
        return 1;
    }
}
