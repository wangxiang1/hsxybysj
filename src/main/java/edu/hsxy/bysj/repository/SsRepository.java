package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.hsxy.bysj.domain.SsInfo;

public interface SsRepository extends CrudRepository<SsInfo, Serializable> {

	@Query("from SsInfo s where s.ssh = ?1")
	SsInfo findBySsh(String ssh);
}
