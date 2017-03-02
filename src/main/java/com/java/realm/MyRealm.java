package com.java.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.entity.User;
import com.java.service.UserService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.getRoles(username));
		authorizationInfo.setStringPermissions(userService.getPermissions(username));
		return authorizationInfo;
	}

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userService.getByUserName(username);
		if (user != null) {
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
					user.getUserName(), user.getPassword(), "xx");
			return simpleAuthenticationInfo;
		} else {
			return null;
		}
	}

}
