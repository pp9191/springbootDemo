package com.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.entity.User;
import com.web.service.UserService;

@Controller
@RequestMapping("/userinfo")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(User user) {		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute @Valid User user, BindingResult result) {	
		if(result.hasErrors()) {
			// 校验报错
			
		}else if(userService.selectByAccount(user) != null) {
			FieldError error = new FieldError("user", "account", "账号已存在");
			result.addError(error );
			
		}else if(userService.addUser(user) == 1) {
			// 注册成功，跳转登录
			return "login";
		}
		return "signup";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(User user) {
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute @Valid User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			// 校验报错
			return "login";
		}
		User logUser = userService.login(user);
		if(logUser != null) {
			// 登录成功
			session.setAttribute("curUser", logUser);
			return "redirect:/index";
		}else {
			FieldError error = new FieldError("user", "account", "账号或密码错误");
			result.addError(error );
		}
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("curUser");
		return "redirect:/index";
	}
	
}
