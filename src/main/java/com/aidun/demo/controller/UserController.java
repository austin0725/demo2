package com.aidun.demo.controller;

import com.aidun.demo.bean.User;
import com.aidun.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "/api",description = "用户操作API")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/add")
    @ApiOperation(value = "注册" ,httpMethod = "Post")
    public String addUser(@RequestBody User user){

        userService.addUser(user);
        return "success";
    }

    @PostMapping("user/login")
    @ApiOperation(value="用户登录",tags={"用户登录"})
    public String login(@RequestBody User user,HttpSession httpSession){

        User user1 = userService.login(user);
        if(user1 == null){
            return "你所输入的账号或者密码不正确";
        }
        if(!user1.getPassword().equals(user.getPassword())){
            return "你输入的密码有误";
        }
        httpSession.setAttribute("user",user.getAccount());
        return "success";
    }

    @PostMapping("user/info")
    //@ApiOperation(value = "注册" ,httpMethod = "Post")
    public User selecctAll(HttpSession httpSession){

        String account = (String)httpSession.getAttribute("user");
        User user = userService.selectByAccount(account);
        return user;
    }

}
