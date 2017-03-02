package com.java.service;

import java.util.Set;

import com.java.entity.User;

public interface UserService {
	
	/**
	 * 根据用户名获取用户
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	
	/**
	 * 根据用户名获取角色
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * 根据用户名获取权限
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);

}
