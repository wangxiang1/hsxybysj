package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.SsInfo;

@Transactional
public interface SsRepository extends JpaRepository<SsInfo, Serializable> {

	SsInfo findBySsh(String ssh);

	@Query("select distinct s.sslh from SsInfo s order by s.sslh desc")
	List<String> findSslhs();

	@Query("select s.ssh from SsInfo s where s.sslh=?1")
	List<String> findSshsBySslh(String sslh);

	@Query("select s.ssid from SsInfo s where s.sslh=?1")
	List<Integer> findSsidsBySslh(String sslh);

	@Modifying
	@Query("update SsInfo s set s.ssye = ?2 where s.ssid = ?1")
	int updateYue(int ssid, String ssye);

	@Query("from SsInfo s where s.ssid = ?1 and s.ssh like CONCAT('%',?2,'%')")
	SsInfo findBySshAndId(int ssid, String ssh);

	@Query("from SsInfo s where s.ssid = ?1 and s.sslh like CONCAT('%',?2,'%')")
	SsInfo findBySslhAndId(int ssid, String sslh);

	@Query("from SsInfo s where s.sslh like CONCAT('%',?1,'%') and s.ssh like CONCAT('%',?2,'%') and s.ssid = ?3")
	SsInfo findBySslhAndSshAndId(String sslh, String ssh, int ssid);

	@Query("select COUNT(s.sslh) from  SsInfo s where s.sslh = ?1")
	int findSsgs(String sslh);

	@Query("select s.ssid from  SsInfo s where s.sslh = ?1")
	List<Integer> findSsids(String sslh);

	@Query("select s.ssid from  SsInfo s ")
	List<Integer> findAllSsids();

	@Query("select s.ssid from  SsInfo s where s.sslh like CONCAT('%',?1,'%')")
	List<Integer> findAllSsidsBySslh(String sslh);

	@Query("select s.ssid from  SsInfo s where s.ssh like CONCAT('%',?1,'%')")
	List<Integer> findAllSsidsBySsh(String ssh);

	@Query("select s.ssid from  SsInfo s where s.sslh like CONCAT('%',?1,'%') and s.ssh like CONCAT('%',?2,'%')")
	List<Integer> findAllSsidsBySslhAndSsh(String sslh, String ssh);

}
