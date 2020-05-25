package com.james.example.boot.hello.controller;

import com.james.example.boot.hello.domain.ResponseResult;
import com.james.example.boot.hello.domain.User;
import com.james.example.boot.hello.domain.request.UserRequest;
import com.james.example.boot.hello.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/5/11
 */
@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 分页获取用户列表
     *
     * @param userRequest 请求参数
     * @return
     */
    @GetMapping("")
    public String getUsers(@RequestBody UserRequest userRequest){
        if(userRequest == null || userRequest.getPageNo() == null){
            return "获取用户列表";
        }
        return "分页获取用户列表，pageNo = " + userRequest.getPageNo() + "; pageSize = " + userRequest.getPageSize();
    }

    /**
     * 创建一个用户信息
     *
     * @param user 用户数据
     * @return
     */
    @PostMapping("")
    public String postUsers(@RequestBody User user){

        if(user == null){
            return "";
        }
        return "保存用户信息成功";
    }

    @GetMapping("/{userId}")
    public ResponseResult getUser(@PathVariable Long userId){
        return ResponseResult.ok(userService.getUser(userId));
    }

}
