package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;

public interface SanPhamService {
	public List<SanPham> getSanPhams();
	public List<SanPham> searchSanPhams(String theSearchName);
	public void saveSanPham(SanPham theSanPham);
    public SanPham getSanPham(int id);
    public void deleteSanPham(int id);
    public List<SanPham> searchByLoaiSanPhams(LoaiSP loaiSP);
}
