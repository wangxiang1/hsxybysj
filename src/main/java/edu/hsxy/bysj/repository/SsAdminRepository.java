package edu.hsxy.bysj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hsxy.bysj.domain.SSAdmin;

public interface SsAdminRepository extends JpaRepository<SSAdmin, Serializable> {

}
