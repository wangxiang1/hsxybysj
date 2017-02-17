package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import edu.hsxy.bysj.domain.StuInfo;

public interface StuRepository extends CrudRepository<StuInfo, Serializable> {

}
