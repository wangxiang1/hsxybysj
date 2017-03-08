package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.SSAdmin;

@Transactional
public interface SsAdminRepository extends JpaRepository<SSAdmin, Serializable> {

	@Modifying
	@Query("update SSAdmin s set s.sex = ?2,s.sslh = ?3 where s.ssglyid = ?1")
	int updateAdmin(Integer ssglyid, Integer sex, String sslh);

	@Modifying
	@Query("delete from SSAdmin u where u.ssglyid in ?1 ")
	int deleteById(List<Integer> ids);
}
