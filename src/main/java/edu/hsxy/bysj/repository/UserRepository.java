package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Serializable> {

	@Query("from User u where u.dlzh=?1 and u.pwd=?2")
	User findUser(String dlzh, String pwd);

	@Modifying
	@Query("update User u set u.pwd = ?2 where u.yhid = ?1")
	int updatePwd(int yhid, String pwd);
}
