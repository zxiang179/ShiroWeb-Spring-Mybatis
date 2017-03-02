package com.java.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	public User getByUserName(String userName) {
		return dao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return dao.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return dao.getPermissions(userName);
	}

}
