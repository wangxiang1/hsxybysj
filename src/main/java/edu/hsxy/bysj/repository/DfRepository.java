package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.hsxy.bysj.domain.DFInfo;

public interface DfRepository extends CrudRepository<DFInfo, Serializable> {

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 order by d1.date desc")
	List<DFInfo> findLastDfxx(int ssid);

	@Query("select d1 from DFInfo d1 where d1.ssid=?1 and d1.date=?2")
	DFInfo findDfxxBydate(int ssid, String date);
}
