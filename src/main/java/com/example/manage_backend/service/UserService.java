package com.example.manage_backend.service;

import com.example.manage_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username);

    int getTotalNum(String username);
}
