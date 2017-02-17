package edu.hsxy.bysj.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.hsxy.bysj.domain.SFInfo;

public interface SfRepository extends CrudRepository<SFInfo, Serializable> {

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<SFInfo> findLastSfxx(int ssid);

	@Query("select s1 from SFInfo s1 where s1.ssid=?1 and s1.date=?2")
	SFInfo findSfxxBydate(int ssid, String date);

	@Query("select s1.date from SFInfo s1 where s1.ssid=?1 order by s1.date desc")
	List<String> findAllDate(int ssid);
}
