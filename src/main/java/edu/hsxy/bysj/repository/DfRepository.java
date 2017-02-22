package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.hsxy.bysj.domain.DFInfo;

@Transactional
public interface DfRepository extends PagingAndSortingRepository<DFInfo, Serializable> {

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 order by d1.date desc")
	List<DFInfo> findDfxx(int ssid);

	@Query("select d1 from DFInfo d1 where d1.ssid=?1")
	List<DFInfo> findDfxx(int ssid, Pageable pageable);

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 and d1.date=?2")
	DFInfo findDfxxBydate(int ssid, String date);

	@Modifying
	@Query("update DFInfo d set d.sfjf = 1 where d.dfid = ?1")
	int updateSfjf(int dfid);
}
