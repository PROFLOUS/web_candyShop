package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;

public interface LoaiSPService {
    public List<LoaiSP> getLoaiSanPhams();

    public LoaiSP getLoaiSanPhamById(int id);
}
