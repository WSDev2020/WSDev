package com.study.wsdev.config;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.study.wsdev.vo.User;

public class ProxyIntercepter implements HandlerInterceptor{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		User usr = (User) request.getSession().getAttribute("usr");

		if(!Objects.isNull(usr)) {

			modelAndView.addObject("usr", usr);
		}

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
