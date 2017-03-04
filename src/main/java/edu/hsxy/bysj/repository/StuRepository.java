package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.hsxy.bysj.domain.StuInfo;

public interface StuRepository extends JpaRepository<StuInfo, Serializable> {

	@Query("select COUNT(s.stuid) from StuInfo s where s.ssh in ?1")
	int findSsrs(List<String> sshs);
}
