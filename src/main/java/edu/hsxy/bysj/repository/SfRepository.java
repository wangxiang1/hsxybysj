package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.SFInfo;

@Transactional
public interface SfRepository extends PagingAndSortingRepository<SFInfo, Serializable> {

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<SFInfo> findSfxx(int ssid);

	@Query("select s1 from SFInfo s1 where s1.ssid=?1")
	Page<SFInfo> findSfxx(int ssid, Pageable pageable);

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 and s1.date=?2")
	SFInfo findSfxxBydate(int ssid, String date);

	@Query("select s1.date from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<String> findAllDate(int ssid);

	@Modifying
	@Query("update SFInfo s set s.sfjf = 1 where s.sfid = ?1")
	int updateSfjf(int sfid);
}
