package com.se.iuh.web_candy.dto;

import com.se.iuh.web_candy.entity.LoaiSP;

public class SanPhamDTO {
	
	private int maSP;
	private String tenSP;
	private int soLuong;
	private double donGia;
	private String hinhAnh;
	private double khuyenMai;
	private String thongTinSP;
	private int maLoaiSP;
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public double getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(double khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public String getThongTinSP() {
		return thongTinSP;
	}
	public void setThongTinSP(String thongTinSP) {
		this.thongTinSP = thongTinSP;
	}
	public int getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public SanPhamDTO(int maSP, String tenSP, int soLuong, double donGia, String hinhAnh, double khuyenMai,
			String thongTinSP, int maLoaiSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.khuyenMai = khuyenMai;
		this.thongTinSP = thongTinSP;
		this.maLoaiSP = maLoaiSP;
	}
	public SanPhamDTO() {
		super();
	}
	
	

}
