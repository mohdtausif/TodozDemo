package com.tausif.todoz.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.todoz.entity.User;

@RestController
public interface UserController {
	@PostMapping("/public/user/sign-up")
    public void signUp(@RequestBody User user);
}
