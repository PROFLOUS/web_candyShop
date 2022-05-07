package com.se.iuh.web_candy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer>, JpaSpecificationExecutor<SanPham>{
	
	public List<SanPham> findByTenSP(String tenSP);
	public List<SanPham> findByMaLoaiSP(LoaiSP loaiSP);

}
