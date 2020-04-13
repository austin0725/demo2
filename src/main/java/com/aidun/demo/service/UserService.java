package com.aidun.demo.service;

import com.aidun.demo.bean.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> selecctAll();

    User login(User user);

    User selectByAccount(String account);
}
