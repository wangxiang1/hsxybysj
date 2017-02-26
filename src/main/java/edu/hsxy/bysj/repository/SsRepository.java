package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.SsInfo;

@Transactional
public interface SsRepository extends CrudRepository<SsInfo, Serializable> {

	@Query("from SsInfo s where s.ssh = ?1")
	SsInfo findBySsh(String ssh);

	@Modifying
	@Query("update SsInfo s set s.ssye = ?2 where s.ssid = ?1")
	int updateYue(int ssid, String ssye);

	@Query("from SsInfo s where s.ssid = ?1 and s.ssh like CONCAT('%',?2,'%')")
	SsInfo findBySshAndId(int ssid, String ssh);

	@Query("from SsInfo s where s.ssid = ?1 and s.sslh like CONCAT('%',?2,'%')")
	SsInfo findBySslhAndId(int ssid, String sslh);

	@Query("from SsInfo s where s.sslh like CONCAT('%',?1,'%') and s.ssh like CONCAT('%',?2,'%') and s.ssid = ?3")
	SsInfo findBySslhAndSshAndId(String sslh, String ssh, int ssid);

}
