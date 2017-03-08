package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query("from User u where u.dlzh=?1 and u.pwd=?2")
	User findUser(String dlzh, String pwd);

	@Modifying
	@Query("update User u set u.pwd = ?2 where u.yhid = ?1")
	int updatePwd(int yhid, String pwd);

	@Modifying
	@Query("update User u set u.yhm = ?2,u.sjhm = ?3,u.sfbz = ?4 where u.yhid = ?1 ")
	int updateUser(int yhid, String yhm, String sjhm, String sfbz);

	Page<User> findBySfbz(String sfbz, Pageable pageable);

	Page<User> findBySfbzIn(Collection<String> userList, Pageable pageable);

	User findByDlzh(String dlzh);

	@Modifying
	@Query("delete from User u where u.yhid in ?1 ")
	int deleteById(List<Integer> ids);

}
