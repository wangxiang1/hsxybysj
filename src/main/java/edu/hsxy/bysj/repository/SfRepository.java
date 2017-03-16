package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.SFInfo;

@Transactional
public interface SfRepository extends JpaRepository<SFInfo, Serializable> {

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<SFInfo> findSfxx(int ssid);

	@Query("select s1 from SFInfo s1 where s1.ssid=?1")
	Page<SFInfo> findSfxx(int ssid, Pageable pageable);

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 and s1.date=?2")
	SFInfo findSfxxBydate(int ssid, String date);

	@Query("select s1.date from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<String> findAllDate(int ssid);

	@Query("select distinct s1.date from SFInfo s1 order by s1.date desc")
	List<String> findAllDate2();

	@Modifying
	@Query("update SFInfo s set s.sfjf = 1 where s.sfid = ?1")
	int updateSfjf(int sfid);

	@Query("select s1 from SFInfo s1 where s1.sfjf = ?1 and s1.ssid in ?2")
	Page<SFInfo> findSfxxBySfjf(String sfjf, List<Integer> ssids, Pageable pageable);

	@Query("select s1 from SFInfo s1 where s1.date = ?1 and s1.ssid in ?2")
	Page<SFInfo> findSfxxByDate(String date, List<Integer> ssids, Pageable pageable);

	@Query("select s1 from SFInfo s1 where s1.date = ?1 and s1.sfjf = ?2 and s1.ssid in ?3 ")
	Page<SFInfo> findSfxxByDateAndSfjf(String date, String sfjf, List<Integer> ssids, Pageable pageable);

	@Query("select SUM(s.sf) from SFInfo s where s.date between ?1 and ?2")
	Double countSf(String qssj, String jzsj);

	@Query("select SUM(s.ysl) from SFInfo s where s.date between ?1 and ?2")
	Double countYsl(String qssj, String jzsj);

	@Query("select SUM(s.sf) from SFInfo s where s.date between ?1 and ?2 and s.ssid in ?3")
	Double countSfL(String qssj, String jzsj, List<Integer> ssids);

	@Query("select SUM(s.ysl) from SFInfo s where s.date between ?1 and ?2 and s.ssid in ?3")
	Double countYslL(String qssj, String jzsj, List<Integer> ssids);

	@Query("from SFInfo s1 where s1.ssid in ?1")
	Page<SFInfo> findAllInSsids(List<Integer> ssids, Pageable pageable);

}
