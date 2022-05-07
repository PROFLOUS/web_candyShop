package com.se.iuh.web_candy.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.LoaiSPService;
import com.se.iuh.web_candy.service.SanPhamService;

@RestController
@RequestMapping("api")
public class LoaiSPRestController {
	
private LoaiSPService loaiSanPhamService;
	
	@Autowired
	public LoaiSPRestController(LoaiSPService theLoaiSP) {
		// TODO Auto-generated constructor stub
		loaiSanPhamService = theLoaiSP;
	}
	
	@GetMapping("/loaisanphams")
	public List<LoaiSP> listLoaiSanPhams() {
		return loaiSanPhamService.getLoaiSanPhams();
	}
	
	@GetMapping("/loaisanphams/{ten}")
	public List<LoaiSP> listLoaiSanPhamsByName(@PathVariable String ten) {
		return loaiSanPhamService.searchLoaiSanPhams(ten);
	}

}
