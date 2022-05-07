package com.se.iuh.web_candy.dao;

import com.se.iuh.web_candy.entity.LoaiSP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoaiSPRepository extends JpaRepository<LoaiSP, Integer>,JpaSpecificationExecutor<LoaiSP> {
	
	public List<LoaiSP> findByTenLoaiSP(String tenLSP);

}
