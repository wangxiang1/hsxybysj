package edu.hsxy.bysj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.UserRepository;

@Controller
@RequestMapping("/hsxy/sdjf")
@SessionAttributes({ "user", "user" })
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String goLogin() {
		// MsgSender.sendMsg("18330822332",
		// "近日武林大乱，系屠龙宝刀重现江湖，血流成河，武林侠士奔走相告，欲求阁下脸皮制成宝盾，以救万民于水火！");
		return "login";
	}

	@RequestMapping("/login")
	@ResponseBody
	public User login(String dlzh, String pwd, Model model) {
		User user = userRepository.findUser(dlzh, pwd);
		if (user != null) {
			model.addAttribute("user", user);
		}
		return user;
	}
}
