package com.se.iuh.web_candy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
	
	@Id
    @Column(name = "ten_tai_khoan")
    private String tenTK;
	
	@Column(name="mat_khau")
	private String matKhau;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ma_khach_hang")
	private KhachHang khachHang;

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TaiKhoan() {
		super();
	}

	
	public TaiKhoan(String tenTK, String matKhau, KhachHang khachHang) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTK=" + tenTK + ", matKhau=" + matKhau + ", maKH=" + khachHang + "]";
	}
	
	

}
