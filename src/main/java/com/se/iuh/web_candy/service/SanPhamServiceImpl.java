package com.se.iuh.web_candy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.SanPhamRepository;
import com.se.iuh.web_candy.entity.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	private SanPhamRepository sanPhamRespository;

	@Autowired
	public SanPhamServiceImpl(SanPhamRepository theSanPhamRespository) {
		sanPhamRespository = theSanPhamRespository;
	}

	@Override
	public List<SanPham> getSanPhams() {
		// TODO Auto-generated method stub
		return sanPhamRespository.findAll();
	}

}
