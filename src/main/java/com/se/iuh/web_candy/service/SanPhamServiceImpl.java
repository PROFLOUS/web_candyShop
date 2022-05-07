package com.se.iuh.web_candy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.SanPhamRepository;
import com.se.iuh.web_candy.entity.LoaiSP;
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

	@Override
	public List<SanPham> searchSanPhams(String theSearchName) {
		// TODO Auto-generated method stub
		return sanPhamRespository.findByTenSP(theSearchName);
	}

	@Override
	public void saveSanPham(SanPham theSanPham) {
		sanPhamRespository.save(theSanPham);
		
	}

	@Override
	public SanPham getSanPham(int id) {
		// TODO Auto-generated method stub
		return sanPhamRespository.getById(id);
	}

	@Override
	public void deleteSanPham(int id) {
		sanPhamRespository.deleteById(id);
		
	}

	@Override
	public List<SanPham> searchByLoaiSanPhams(LoaiSP loaiSP) {
		// TODO Auto-generated method stub
		return sanPhamRespository.findByMaLoaiSP(loaiSP);
	}

}
