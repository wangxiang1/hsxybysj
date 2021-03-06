package edu.hsxy.bysj.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.service.ImportExcelService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ImportExcelService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String upload1() {
		return "student/testfile";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public List<Sdfxx> upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		List<Sdfxx> result = userService.readExcelFile(file);
		return result;
	}
}
