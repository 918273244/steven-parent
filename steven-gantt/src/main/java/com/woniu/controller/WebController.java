package com.woniu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.woniu.bean.Users;
import com.woniu.mapper.UserMaper;

@RestController
@RequestMapping("/web")
public class WebController {
	@Autowired
	private UserMaper mapper;
	
	
	@RequestMapping("/index")
	@ResponseBody
	public List<Users> selectAge(int age){
		/*
		 * 第一个参数是第几页；第二个参数是每页显示条数。
		 */
		PageHelper.startPage(1,age);
		return mapper.Select(age);
	}
}
