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

    /**
     * 正常方式，在 Controller 自动注入 Service。
     *
     * @return  user info
     */
    @GetMapping("/user")
    public String getUser(){
        return userService.getUser();
    }

    /**
     * 使用单例对象中自动注入的 UserService 的方法
     *
     * @return  UserSingleton Exception: userService is null
     */
    @GetMapping("/user/singleton/ioc")
    public String getUserFromSingletonForIoc(){
        return UserSingleton.getInstance().getUser();
    }

    /**
     * 使用单例对象中手动实例化的 UserService 的方法
     *
     * @return  user info
     */
    @GetMapping("/user/singleton/new")
    public String getUserFromSingletonForNew(){
        return UserSingleton.getInstance().getUserForNew();
    }

    /**
     * 使用单例对象中手动实例化的 UserService 的方法，在 UserService 中，通过 DAO 获取数据
     *
     * @return  UserServiceImpl Exception: userDao is null
     */
    @GetMapping("/user/singleton/new/dao")
    public String getUserFromSingletonForNewFromDao(){
        return UserSingleton.getInstance().getUserForNewFromDao();
    }

    /**
     * 使用 SpringContextUtils 获取的的 UserService 的方法，在 UserService 中，通过 DAO 获取数据
     *
     * @return  user info for dao
     */
    @GetMapping("/user/singleton/tool/dao")
    public String getUserFromSingletonForToolFromDao(){
        return UserSingleton.getInstance().getUserForToolFromDao();
    }
}
