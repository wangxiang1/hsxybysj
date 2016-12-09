/**
 * Company:	
 * Project Name:spring
 * File Name:Application.java
 * Package Name:com.spring.springboot
 * Copyright (C) 2016,rgl. All rights reserved.
 * 
 */
package com.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * JDK 1.8 <br/>
 * ClassName: Application <br/> 
 * author rgl <br/>
 * date: 2016年11月21日 下午5:46:23 <br/> 
 * 
 * 功能描述:
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
