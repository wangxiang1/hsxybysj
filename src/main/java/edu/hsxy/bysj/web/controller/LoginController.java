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

	/*
	 * @Autowired private SfRepository sfRepository;
	 * 
	 * @Autowired private DfRepository dfRepository;
	 */

	@RequestMapping("/")
	public String goLogin() {

		/*
		 * SFInfo sfInfo = new SFInfo(3, "2017-06-16 22:14:32", "0", "10",
		 * "2.35", "23.5", "1", "140", "150", "1"); SFInfo sfInfo1 = new
		 * SFInfo(4, "2017-06-16 22:14:32", "0", "100", "2.35", "235", "1",
		 * "600", "700", "1"); DFInfo dfInfo = new DFInfo(3,
		 * "2017-06-16 22:14:32", "0", "10", "0.52", "5.2", "1", "140", "150",
		 * "1"); DFInfo dfInfo1 = new DFInfo(4, "2017-06-16 22:14:32", "0",
		 * "100", "0.52", "52", "1", "600", "700", "1");
		 * sfRepository.save(sfInfo); sfRepository.save(sfInfo1);
		 * dfRepository.save(dfInfo); dfRepository.save(dfInfo1);
		 */

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
