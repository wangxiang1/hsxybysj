/**
 * Company:	
 * Project Name:spring
 * File Name:TestController.java
 * Package Name:com.spring.springboot.controller
 * Copyright (C) 2016,rgl. All rights reserved.
 * 
 */
package edu.hsxy.bysj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangxiang 功能描述：测试类
 * @data 2016年12月9日
 */
@Controller
@RequestMapping("/abc")
public class TestController {

	@RequestMapping("/")
	public String test11() {
		return "login";
	}
}
