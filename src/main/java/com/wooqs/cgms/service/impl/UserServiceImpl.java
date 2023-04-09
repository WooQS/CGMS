package com.wooqs.cgms.service.impl;

import com.wooqs.cgms.mapper.UserMapper;
import com.wooqs.cgms.model.User;
import com.wooqs.cgms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    // 根据id获取用户信息
    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    // 根据用户名获取用户信息
    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    // 获取所有用户信息
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    // 保存用户信息
    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    // 更新用户信息
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    // 根据id删除用户信息
    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }
}
