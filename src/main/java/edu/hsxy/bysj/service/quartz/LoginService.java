package edu.hsxy.bysj.service.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User findUser(String dlzh, String pwd) {
		return userRepository.findUser(dlzh, pwd);
	}
}
