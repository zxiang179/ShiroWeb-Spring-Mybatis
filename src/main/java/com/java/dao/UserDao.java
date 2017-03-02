package com.java.dao;

import java.util.Set;

import com.java.entity.User;

public interface UserDao {
	
	/**
	 * 根据用户名查询用户
	 */
	public User getByUserName(String username);
	
	/**
	 * 根据用户名查询角色
	 * @param username
	 * @return
	 */
	public Set<String> getRoles(String username);
	
	/**
	 * 根据用户名查询权限信息
	 * @param username
	 * @return
	 */
	public Set<String> getPermissions(String username);
	
	

}
