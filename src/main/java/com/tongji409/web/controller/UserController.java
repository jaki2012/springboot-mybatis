package com.tongji409.web.controller;

import com.tongji409.domain.User;
import com.tongji409.web.Service.UserService;
import com.tongji409.web.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijiechu
 * @create on 16/12/3
 * @description
 */

@RestController
@RequestMapping(value = "/home")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user(){
        User user = userMapper.findUserByName("jaki");
        if(null == user){
            return "User named jaki not found!";
        }
        return user.getName()+"-----"+user.getAge();
    }

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    @ResponseBody
    public String insertUser(@RequestBody User user){
        userService.insertUser(user);
        return "Successfully insert user!";
    }
}
