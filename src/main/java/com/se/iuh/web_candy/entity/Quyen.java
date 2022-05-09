package com.se.iuh.web_candy.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quyen")
public class Quyen implements Serializable{
	@Id
//	@OneToOne(cascade = CascadeType.ALL)
	private String tenTaiKhoan;
	
	@Column(name="role")
	private String role;

	

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Quyen(String tenTaiKhoan, String role) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.role = role;
	}

	public Quyen() {
		super();
		this.tenTaiKhoan = null;
		this.role = null;
	}
	
	
	
}
