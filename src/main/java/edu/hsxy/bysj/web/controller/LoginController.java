package edu.hsxy.bysj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.hsxy.bysj.service.quartz.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String login() {
		System.out.println(loginService.findUser("201340513251", "123456"));
		return "test";
	}
}
