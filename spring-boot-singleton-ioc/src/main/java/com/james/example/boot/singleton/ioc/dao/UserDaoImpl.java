package com.james.example.boot.singleton.ioc.dao;

import org.springframework.stereotype.Component;

/**
 * @author James
 * @date 2020/4/28
 */
@Component
public class UserDaoImpl implements UserDao{

    /**
     *
     * @return
     */
    @Override
    public String select(){
        return "user info for dao";
    }
}
