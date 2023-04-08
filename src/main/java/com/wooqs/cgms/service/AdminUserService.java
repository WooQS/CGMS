package com.wooqs.cgms.service;

import com.wooqs.cgms.mapper.UserMapper;
import com.wooqs.cgms.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    private final UserMapper userMapper;

    // 构造函数注入UserMapper对象
    public AdminUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 获取所有用户信息
    public List<User> getAllUsers() {
        return userMapper.getAll();
    }

    // 根据用户ID获取用户信息
    public User getUserById(Long userId) {
        return userMapper.getById(userId);
    }

    // 创建新用户
    public void createUser(User user) {
        userMapper.insert(user);
    }

    // 更新用户信息
    public void updateUser(User user) {
        userMapper.update(user);
    }

    // 根据用户ID删除用户信息
    public void deleteUser(Long userId) {
        userMapper.deleteById(userId);
    }

}