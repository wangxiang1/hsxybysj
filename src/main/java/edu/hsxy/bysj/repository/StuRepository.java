package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.StuInfo;

@Transactional
public interface StuRepository extends JpaRepository<StuInfo, Serializable> {

	@Query("select COUNT(s.stuid) from StuInfo s where s.ssh in ?1")
	int findSsrs(List<String> sshs);

	@Modifying
	@Query("update StuInfo s set s.sex = ?2,s.xl = ?3,s.xb = ?4,s.zy = ?5,s.ssh = ?6 where s.stuid = ?1")
	int updateStu(Integer stuid, Integer sex, String xl, String xb, String zy, String ssh);

	@Modifying
	@Query("delete from StuInfo u where u.stuid in ?1 ")
	int deleteById(List<Integer> ids);
}
