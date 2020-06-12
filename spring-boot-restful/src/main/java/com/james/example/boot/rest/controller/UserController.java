package com.james.example.boot.rest.controller;


import com.james.example.boot.rest.domain.ResponseResult;
import com.james.example.boot.rest.domain.User;
import com.james.example.boot.rest.domain.request.UserRequest;
import com.james.example.boot.rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * GET     /api/v1/books        所有书单
 * GET     /api/v1/books/{id}   获取一条书单
 * POST    /api/v1/books        新建一条书单
 * PUT     /api/v1/books/{id}   更新一条书单，提供全部信息
 * PATCH   /api/v1/books/{id}   更新一条书单，提供部分信息
 * DELETE  /api/v1/books/{id}   删除一条书单
 * DELETE  /API/v1/books        删除所有书单
 *
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
     * 获取用户列表 - 待定
     *
     * @return
     */
//    @GetMapping("")
//    public String getUsers(){
//        return "获取所有用户，不分页";
//    }

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
        return "获取用户列表，pageNo = " + userRequest.getPageNo() + "; pageSize = " + userRequest.getPageSize();
    }

    @GetMapping("/{userId}")
    public ResponseResult getUser(@PathVariable Long userId){
        return ResponseResult.ok(userService.getUser(userId));
    }

    /**
     * 创建一个用户信息
     *
     * @param user 用户数据
     * @return
     */
    @PostMapping("")
    public String addUser(@RequestBody User user){

        if(user == null){
            return "";
        }
        return "保存用户信息成功";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){

        return "删除用户信息：userId = " + userId;
    }
}
