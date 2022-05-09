package com.se.iuh.web_candy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;

public interface TaiKhoanRespository extends JpaRepository<TaiKhoan, String>,JpaSpecificationExecutor<TaiKhoan>{
	
	public TaiKhoan findByKhachHang(KhachHang khachHang);
}
