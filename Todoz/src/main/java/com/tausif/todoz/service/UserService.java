package com.tausif.todoz.service;

import org.springframework.stereotype.Service;

import com.tausif.todoz.entity.User;

@Service
public interface UserService {
	public void signUp(User user);
}
