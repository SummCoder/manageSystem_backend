package com.example.manage_backend.controller;

import com.example.manage_backend.common.R;
import com.example.manage_backend.domain.entity.User;
import com.example.manage_backend.domain.vo.LoginInfo;
import com.example.manage_backend.domain.vo.RegisterInfo;
import com.example.manage_backend.domain.vo.UserVO;
import com.example.manage_backend.service.UserService;
import com.example.manage_backend.utils.TokenUtils;
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
    public Boolean createUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping(path="/{id}", consumes="application/json")
    public Boolean updateUser(@PathVariable("id") Integer id,
                              @RequestBody User user){
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
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

    @PostMapping("login")
    public R login(@RequestBody LoginInfo loginInfo){
        Boolean result = userService.login(loginInfo);
        if(result){
            String token = TokenUtils.genToken(loginInfo.getUsername(), loginInfo.getPassword());
            UserVO userVO = new UserVO(loginInfo.getUsername(), token);
            return R.success(userVO);
        }
        return R.error(999, "用户名或密码错误");
    }

    @PostMapping("register")
    public R register(@RequestBody RegisterInfo registerInfo){
        Boolean result = userService.register(registerInfo);
        if(result){
            String token = TokenUtils.genToken(registerInfo.getUsername(), registerInfo.getPassword());
            UserVO userVO = new UserVO(registerInfo.getUsername(), token);
            return R.success(userVO);
        }
        return R.error(999, "该用户名已存在");
    }

}
