package com.se.iuh.web_candy.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

@RestController
@RequestMapping("api")
public class SanPhamRestController {
	
	private SanPhamService sanPhamService;
	
	@Autowired
	public SanPhamRestController(SanPhamService theSanPhamService) {
		sanPhamService= theSanPhamService;
	}
	
	@GetMapping("/sanphams")
	public List<SanPham> listSanPhams() {
		return sanPhamService.getSanPhams();
	}

}
