package com.aidun.demo.service.impl;

import com.aidun.demo.bean.User;
import com.aidun.demo.mapper.UserMapper;
import com.aidun.demo.service.UserService;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        User user1 = userMapper.selectByAccount(user.getAccount());
        if (user1 != null) {
            throw new RuntimeException("该用户已存在");
        }
        userMapper.insertSelective(user);
    }


    @Override
    public List<User> selecctAll() {
        return userMapper.selectAll();
    }

    @Override
    public User login(User user) {

        return userMapper.selectByAccount(user.getAccount());
    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
