package com.james.example.boot.rest.service.impl;

import com.james.example.boot.rest.dao.UserDao;
import com.james.example.boot.rest.domain.User;
import com.james.example.boot.rest.domain.response.UserResponse;
import com.james.example.boot.rest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户操作的逻辑层，具体实现
 *
 * @author James
 * @date 2020/5/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserResponse getUser(Long id) {
        User user = userDao.selectUser(id);

        UserResponse userResponse = new UserResponse(user);
        userResponse.setDeptName("XX机构");
        return userResponse;
    }
}
