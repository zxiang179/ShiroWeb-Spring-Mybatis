package com.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUserName(),user.getPassword());
		
		try {
			subject.login(token);
			Session session = subject.getSession();
			System.out.println("SessionHost:"+session.getHost());
			System.out.println("Session过期时间："+session.getTimeout());
			System.out.println("SessionId:"+session.getId());
			session.setAttribute("Info", "保存在session中的信息");
			return "redirect:/success.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("User", user);
			request.setAttribute("errorMsg", "用户名或者密码错误");
			return "index";
			
		}
		
	}

}
