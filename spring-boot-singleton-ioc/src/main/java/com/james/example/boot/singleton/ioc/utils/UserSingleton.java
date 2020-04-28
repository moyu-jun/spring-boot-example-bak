package com.james.example.boot.singleton.ioc.utils;

import com.james.example.boot.singleton.ioc.service.UserService;
import com.james.example.boot.singleton.ioc.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/28
 */
@Slf4j
public class UserSingleton {

    private static volatile UserSingleton INSTANCE;

    @Resource
    private UserService userService;

    private UserService userServiceForNew;
    private UserService userServiceForTool;

    private UserSingleton() {
        userServiceForNew = new UserServiceImpl();
        userServiceForTool = SpringContextUtils.getBean(UserService.class);
    }

    public static UserSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (UserSingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new UserSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public String getUser() {
        if (null == userService) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userService.getUser();
    }

    public String getUserForNew() {
        if (null == userServiceForNew) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForNew.getUser();
    }

    public String getUserForNewFromDao() {
        if (null == userServiceForNew) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForNew.getUserForDao();
    }

    public String getUserForToolFromDao() {
        if (null == userServiceForTool) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForTool.getUserForDao();
    }
}
