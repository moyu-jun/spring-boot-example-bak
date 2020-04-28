package com.james.example.boot.singleton.ioc.service.impl;

import com.james.example.boot.singleton.ioc.dao.UserDao;
import com.james.example.boot.singleton.ioc.dao.UserDaoImpl;
import com.james.example.boot.singleton.ioc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/28
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public String getUser() {
        return "user info";
    }

    @Override
    public String getUserForDao(){
        if(null == userDao){
            log.debug("UserServiceImpl Exception: userDao is null");
            return "UserServiceImpl Exception: userDao is null";
        }
        return userDao.select();
    }
}
