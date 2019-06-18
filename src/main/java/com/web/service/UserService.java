package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.dao.UserMapper;
import com.web.entity.User;

@Repository("userService")
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public Integer addUser(User user) {
		
		return userMapper.insertSelective(user);
	}
	
	public User selectByAccount(User user) {
		
		return userMapper.selectByAccount(user);
	}

	public User login(User user) {
		
		return userMapper.login(user);
	}
}
