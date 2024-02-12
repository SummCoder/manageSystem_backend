package com.example.manage_backend.service.impl;

import com.example.manage_backend.entity.User;
import com.example.manage_backend.mapper.UserMapper;
import com.example.manage_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username) {
        return userMapper.getUsersByPage(pageNum, pageSize, username);
    }

    @Override
    public int getTotalNum(String username) {
        return userMapper.getTotalNum(username);
    }
}
