package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.Quyen;
import com.se.iuh.web_candy.entity.TaiKhoan;

public interface QuyenService {
	public List<Quyen> getQuyens();
    public void saveQuyen(Quyen theQuyen);
    public Quyen getQuyenById(String id);
    public void deleteQuyen(String id);
}
