package com.james.example.boot.singleton.ioc.controller;

import com.james.example.boot.singleton.ioc.service.UserService;
import com.james.example.boot.singleton.ioc.utils.UserSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/28
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    public String getUser(){
        return userService.getUser();
    }

    @GetMapping("/user/singleton/ioc")
    public String getUserFromSingletonForIoc(){
        return UserSingleton.getInstance().getUser();
    }

    @GetMapping("/user/singleton/new")
    public String getUserFromSingletonForNew(){
        return UserSingleton.getInstance().getUserForNew();
    }

    @GetMapping("/user/singleton/new/dao")
    public String getUserFromSingletonForNewFromDao(){
        return UserSingleton.getInstance().getUserForNewFromDao();
    }

    @GetMapping("/user/singleton/tool/dao")
    public String getUserFromSingletonForToolFromDao(){
        return UserSingleton.getInstance().getUserForToolFromDao();
    }
}
