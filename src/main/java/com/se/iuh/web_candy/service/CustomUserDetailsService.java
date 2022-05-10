package com.se.iuh.web_candy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.TaiKhoanRespository;
import com.se.iuh.web_candy.entity.TaiKhoan;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private TaiKhoanRespository taiKhoanRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = taiKhoanRespository.findByTenTK(username);
		if (taiKhoan == null) {
            System.out.println("User not found! " + taiKhoan);
            throw new UsernameNotFoundException("Không tìm thấy tài khoản này!");
        }
		return new CustomUserDetails(taiKhoan);
	}
}
