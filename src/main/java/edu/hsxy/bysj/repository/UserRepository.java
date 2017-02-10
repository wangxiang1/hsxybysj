package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.hsxy.bysj.domain.User;

public interface UserRepository extends CrudRepository<User, Serializable> {

	@Query("from User u where u.dlzh=?1 and u.pwd=?2")
	User findUser(String dlzh, String pwd);
}
