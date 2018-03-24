package com.tausif.todoz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.todoz.dao.UserRepository;
import com.tausif.todoz.entity.User;
import com.tausif.todoz.service.UserServiceImpl;

@RestController
public class UserControllerImpl implements UserController{
	@Autowired
	UserServiceImpl userService;
	
    @Override
    public void signUp(@RequestBody User user) {
    	userService.signUp(user);
    }
}
