package com.wooqs.cgms.service;

import com.wooqs.cgms.model.User;

import java.util.List;

public interface UserService {
    // 根据id获取用户信息
    User getById(Long id);
    // 根据用户名获取用户信息
    User getByUsername(String username);
    // 获取所有用户信息
    List<User> getAll();
    // 保存用户信息
    void save(User user);
    // 更新用户信息
    void update(User user);
    // 根据id删除用户信息
    void deleteById(Long id);
}
