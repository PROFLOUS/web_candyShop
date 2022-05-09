package com.se.iuh.web_candy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.se.iuh.web_candy.entity.Quyen;
import com.se.iuh.web_candy.entity.TaiKhoan;

public interface QuyenRespository extends JpaRepository<Quyen, String>,JpaSpecificationExecutor<Quyen>{

}
