package com.example.manage_backend.service.impl;

import com.example.manage_backend.domain.entity.User;
import com.example.manage_backend.domain.vo.LoginInfo;
import com.example.manage_backend.domain.vo.RegisterInfo;
import com.example.manage_backend.mapper.UserMapper;
import com.example.manage_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public Boolean insertUser(User user) {
        if(userMapper.queryUser(user.getUsername()) != null){
            return false;
        }
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Boolean deleteUser(Integer id) {
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

    @Override
    public Boolean login(LoginInfo loginInfo) {
        User user = userMapper.queryUser(loginInfo.getUsername());
        return user != null && Objects.equals(user.getPassword(), loginInfo.getPassword());
    }

    @Override
    public Boolean register(RegisterInfo registerInfo) {
        User user = userMapper.queryUser(registerInfo.getUsername());
        if (user != null){
            return false;
        }
        user = new User();
        user.setUsername(registerInfo.getUsername());
        user.setPassword(registerInfo.getPassword());
        user.setAddress(registerInfo.getAddress());
        userMapper.insertUser(user);
        return true;
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.queryUser(username);
    }
}
