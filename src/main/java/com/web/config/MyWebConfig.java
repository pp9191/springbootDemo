package com.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.interceptor.LayoutInterceptor;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {	
	
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("index");
	 * registry.setOrder(Ordered.HIGHEST_PRECEDENCE); }
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LayoutInterceptor()).addPathPatterns("/**");
	}
}
