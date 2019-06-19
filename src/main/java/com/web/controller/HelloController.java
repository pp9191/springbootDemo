package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.annotation.Layout;

@Controller
public class HelloController {
	
	// 默认首页
	@Layout
	@RequestMapping({"/","/index"})
	public String homepage(Model model) {
		System.out.println("index");
		
		return "index";
	}
	
}
