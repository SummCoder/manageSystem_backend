package com.example.manage_backend.service;

import com.example.manage_backend.domain.entity.User;
import com.example.manage_backend.domain.vo.LoginInfo;
import com.example.manage_backend.domain.vo.RegisterInfo;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    Boolean insertUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Integer id);

    List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username);

    int getTotalNum(String username);

    Boolean login(LoginInfo loginInfo);

    Boolean register(RegisterInfo registerInfo);

    User getUserByName(String username);
}
