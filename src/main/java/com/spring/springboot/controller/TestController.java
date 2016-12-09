/**
 * Company:	
 * Project Name:spring
 * File Name:TestController.java
 * Package Name:com.spring.springboot.controller
 * Copyright (C) 2016,rgl. All rights reserved.
 * 
 */
package com.spring.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * JDK 1.8 <br/>
 * ClassName: TestController <br/> 
 * author rgl <br/>
 * date: 2016年11月21日 下午5:46:23 <br/> 
 * 
 * 功能描述:
 */
@RestController
public class TestController {
	
	@RequestMapping("/")
	public String test(){
		return "hello world";
	}
}
