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
public class SanPhamRestController {
	
	private SanPhamService sanPhamService;
	private LoaiSPService loaiSPService;
	
	@Autowired
	public SanPhamRestController(SanPhamService theSanPhamService,LoaiSPService theLoaiSPService) {
		sanPhamService= theSanPhamService;
		loaiSPService= theLoaiSPService;
	}
	
	@GetMapping("/sanphams")
	public List<SanPham> listSanPhams() {
		return sanPhamService.getSanPhams();
	}
	
	@GetMapping("/sanphams/{ten}")
	public List<SanPham> listSanPhamsByTen(@PathVariable String ten) {
		return sanPhamService.searchSanPhams(ten);
	}
	
	@GetMapping("/sanphams/searchloaisp/{id}")
	public List<SanPham> listSanPhamsByLoai(@PathVariable int id) {
		LoaiSP loaiSP= loaiSPService.getLoaiSanPhamById(id);
		return sanPhamService.searchByLoaiSanPhams(loaiSP);
	}

}
