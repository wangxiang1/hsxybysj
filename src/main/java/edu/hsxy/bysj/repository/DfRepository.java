package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.DFInfo;

@Transactional
public interface DfRepository extends JpaRepository<DFInfo, Serializable> {

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 order by d1.date desc")
	List<DFInfo> findDfxx(int ssid);

	@Query("select d1 from DFInfo d1 where d1.ssid=?1")
	List<DFInfo> findDfxx(int ssid, Pageable pageable);

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 and d1.date=?2")
	DFInfo findDfxxBydate(int ssid, String date);

	@Modifying
	@Query("update DFInfo d set d.sfjf = 1 where d.dfid = ?1")
	int updateSfjf(int dfid);

	@Query("select d1 from DFInfo d1 where d1.sfjf = ?1")
	List<DFInfo> findDfxxBySfjf(String sfjf, Pageable pageable);

	@Query("select d1 from DFInfo d1 where d1.date = ?1")
	List<DFInfo> findDfxxByDate(String date, Pageable pageable);

	@Query("select d1 from DFInfo d1 where d1.date = ?1 and d1.sfjf = ?2")
	List<DFInfo> findDfxxByDateAndSfjf(String date, String sfjf, Pageable pageable);

	@Query("select SUM(d1.df) from DFInfo d1 where d1.date between ?1 and ?2")
	Double countDf(String qssj, String jzsj);

	@Query("select SUM(d1.ydl) from DFInfo d1 where d1.date between ?1 and ?2")
	Double countYdl(String qssj, String jzsj);

	@Query("select SUM(d1.df) from DFInfo d1 where d1.date between ?1 and ?2 and d1.ssid in ?3")
	Double countDf(String qssj, String jzsj, List<Integer> ssids);

	@Query("select SUM(d1.ydl) from DFInfo d1 where d1.date between ?1 and ?2 and d1.ssid in ?3")
	Double countYdl(String qssj, String jzsj, List<Integer> ssids);

}
