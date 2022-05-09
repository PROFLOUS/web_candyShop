package com.se.iuh.web_candy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.iuh.web_candy.entity.KhachHang;

@RepositoryRestResource(path = "nguoidungs")
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>, JpaSpecificationExecutor<KhachHang>{
	@Query(value = "select * from khach_hang s where s.ten_khach_hang like %:keyword% or s.sdt like %:keyword%", nativeQuery = true)
	List<KhachHang> findByKeyword(@Param("keyword") String keyword);
}
