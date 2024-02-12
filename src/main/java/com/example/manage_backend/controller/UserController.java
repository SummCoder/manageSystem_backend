package com.example.manage_backend.controller;

import com.example.manage_backend.entity.User;
import com.example.manage_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping(path="/{id}", consumes="application/json")
    public Integer updateUser(@PathVariable("id") Integer id,
                              @RequestBody User user){
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }

    @GetMapping("/page")
    public Map<String, Object> getUsersByPage(@RequestParam Integer pageNum,
                                              @RequestParam Integer pageSize,
                                              @RequestParam String username) {
        pageNum = (pageNum - 1) * pageSize;
        int totalNum = userService.getTotalNum(username);
        List<User> users = userService.getUsersByPage(pageNum, pageSize, username);
        Map<String, Object> res = new HashMap<>();
        res.put("data", users);
        res.put("total", totalNum);
        return res;
    }
}
