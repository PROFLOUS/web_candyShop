package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;

public interface LoaiSPService {
    public List<LoaiSP> getLoaiSanPhams();
    public void saveLoaiSanPham(LoaiSP theLoaiSanPham);
    public LoaiSP getLoaiSanPhamById(int id);
    public List<LoaiSP> searchLoaiSanPhams(String theSearchName);
    public void deleteLoaiSanPham(int id);
}
