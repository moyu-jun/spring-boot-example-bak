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

    /**
     * 自动注入获取的对象
     */
    @Resource
    private UserService userService;

    /**
     * 使用 new UserService() 创建的对象
     * 加上 ForNew 后缀来和之前两种方式创建的对象作区分
     */
    private UserService userServiceForNew;

    /**
     * 使用 SpringContextUtils 获取的对象
     * 加上 ForTool 后缀来和之前两种方式创建的对象作区分
     */
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

    /**
     * 使用自动依赖注入获取 UserService 对象
     *
     * @return
     */
    public String getUser() {
        if (null == userService) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userService.getUser();
    }

    /**
     * 使用 new UserService() 获取 UserService 对象
     *
     * @return
     */
    public String getUserForNew() {
        if (null == userServiceForNew) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForNew.getUser();
    }

    /**
     * 使用 new UserService() 获取 UserService 对象，并从 UserDao 中获取数据
     *
     * @return
     */
    public String getUserForNewFromDao() {
        if (null == userServiceForNew) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForNew.getUserForDao();
    }

    /**
     * 使用 SpringContextUtils 获取 UserService 对象，并从 UserDao 中获取数据
     *
     * @return
     */
    public String getUserForToolFromDao() {
        if (null == userServiceForTool) {
            log.debug("UserSingleton userService is null");
            return "UserSingleton Exception: userService is null";
        }
        return userServiceForTool.getUserForDao();
    }
}
