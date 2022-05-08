package com.se.iuh.web_candy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.se.iuh.web_candy.dto.SanPhamDTO;
import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.LoaiSPService;
import com.se.iuh.web_candy.service.SanPhamService;
import com.se.iuh.web_candy.validator.LoaiSPValidator;
import com.se.iuh.web_candy.validator.SanPhamDTOValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	  private SanPhamService sanPhamService;

	@Autowired
	private LoaiSPService loaiSPService;
	  
	@Autowired
	private SanPhamDTOValidator sanPhamDTOValidator;
	
	@Autowired
	private LoaiSPValidator loaiSPValidator;
	
	@GetMapping("/sanpham")
	public String sanPham(Model model) {
		
		model.addAttribute("listProduct", sanPhamService.getSanPhams());
	    model.addAttribute("listLoaiSP", loaiSPService.getLoaiSanPhams());
		return "admin/SanPham/SanPham";
	}
	
	@GetMapping("")
	public String homeAdmin() {
		return "admin/homeAdmin";
	}
	
	@GetMapping("/sanpham/themsanpham")
	public String showThemSP(Model model) {
		SanPhamDTO theSP = new SanPhamDTO();
		model.addAttribute("loaiSP", loaiSPService.getLoaiSanPhams());
		model.addAttribute("sanpham", theSP);
		model.addAttribute("formTitle", "Thêm sản phẩm");
		model.addAttribute("formButton", "Lưu sản phẩm");
		return "admin/sanpham/FormSanPham";
	}
	
	@GetMapping("/sanpham/update")
	public String showUpdateSP(Model model,@RequestParam("maSP") int id) {
		SanPham sp = sanPhamService.getSanPham(id);
		MultipartFile hinhAnh= null;
		MultipartFile hinhAnh1=null;
		MultipartFile hinhAnh2=null;
		MultipartFile hinhAnh3=null;
		SanPhamDTO theSP = new SanPhamDTO(sp.getMaSP(),sp.getTenSP(),sp.getSoLuong(),sp.getDonGia(),hinhAnh,hinhAnh1,hinhAnh2,hinhAnh3,sp.getKhuyenMai(),sp.getThongTinSP(),sp.getMaLoaiSP().getMaLoaiSP());
		model.addAttribute("loaiSP", loaiSPService.getLoaiSanPhams());
		model.addAttribute("sanpham", theSP);
		model.addAttribute("formTitle", "Sửa sản phẩm");
		model.addAttribute("formButton", "Cập nhật sản phẩm");
		return "admin/sanpham/FormSanPham";
	}
	
	@PostMapping("sanpham/save")
	public String saveOrUpdateSanPham(@ModelAttribute("sanpham") SanPhamDTO theSP,BindingResult bindingResult,Model model) {
		
		sanPhamDTOValidator.validate(theSP, bindingResult);
		
		if (bindingResult.hasErrors()) {
			if(theSP.getMaSP() == 0) {
				model.addAttribute("loaiSP", loaiSPService.getLoaiSanPhams());
				model.addAttribute("sanpham", theSP);
				model.addAttribute("formTitle", "Thêm sản phẩm");
				model.addAttribute("formButton", "Lưu sản phẩm");
				return "admin/sanpham/FormSanPham";
			}
			model.addAttribute("loaiSP", loaiSPService.getLoaiSanPhams());
			model.addAttribute("sanpham", theSP);
			model.addAttribute("formTitle", "Sửa sản phẩm");
			model.addAttribute("formButton", "Cập nhật sản phẩm");
			return "admin/sanpham/FormSanPham";
		}
		
		LoaiSP loaiSP= loaiSPService.getLoaiSanPhamById(theSP.getMaLoaiSP());
		
		// save the sanpham
		sanPhamService.saveSanPham(new SanPham(theSP.getMaSP(), theSP.getTenSP(), theSP.getSoLuong(), theSP.getDonGia(), doUpload(theSP.getHinhAnh()), doUpload(theSP.getHinhAnh1()),doUpload(theSP.getHinhAnh2()), doUpload(theSP.getHinhAnh3()), theSP.getKhuyenMai(), theSP.getThongTinSP(), loaiSP ));
		
		return "redirect:/admin/sanpham";
	}
	
	
	@GetMapping("/sanpham/delete")
	public String deleteSP(@RequestParam("maSP") int id) {
		sanPhamService.deleteSanPham(id);
		return "redirect:/admin/sanpham";
	}
	
	
	
	@GetMapping("/loaisanpham")
	public String loaiSanPham(Model model) {
		
		model.addAttribute("listLoaiProduct", loaiSPService.getLoaiSanPhams());
		return "admin/LoaiSanPham/LoaiSanPham";
	}
	
	@GetMapping("/loaisanpham/themloaisanpham")
	public String showThemLoaiSP(Model model) {
		LoaiSP theLSP = new LoaiSP();
		model.addAttribute("loaisanpham", theLSP);
		model.addAttribute("formTitle", "Thêm loại sản phẩm");
		model.addAttribute("formButton", "Lưu loại sản phẩm");
		return "admin/loaisanpham/FormLoaiSanPham";
	}
	
	@GetMapping("/loaisanpham/update")
	public String showUpdateLoaiSP(Model model,@RequestParam("maLSP") int id) {
		model.addAttribute("loaisanpham", loaiSPService.getLoaiSanPhamById(id));
		model.addAttribute("formTitle", "Sửa loại sản phẩm");
		model.addAttribute("formButton", "Cập nhật loại sản phẩm");
		return "admin/loaisanpham/FormLoaiSanPham";
	}
	
	@PostMapping("loaisanpham/save")
	public String saveOrUpdateLoaiSanPham(@ModelAttribute("loaisanpham") LoaiSP theLSP,BindingResult bindingResult,Model model) {
		
		loaiSPValidator.validate(theLSP, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loaisanpham", theLSP);
			model.addAttribute("formTitle", "Thêm loại sản phẩm");
			model.addAttribute("formButton", "Lưu loại sản phẩm");
			return "admin/loaisanpham/FormLoaiSanPham";
		}
		
		if(theLSP.getMaLoaiSP() == 0) {
			loaiSPService.saveLoaiSanPham(theLSP);
		}else {
		
		// save the sanpham
		loaiSPService.saveLoaiSanPham(theLSP);
		}
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/loaisanpham";
	}
	
	
	@GetMapping("/loaisanpham/delete")
	public String deleteLoaiSP(@RequestParam("maLSP") int id) {
		List<SanPham> listsp= sanPhamService.getSanPhams();
		int kq=0;
		for(int i=0;i<listsp.size();i++) {
			if(id == listsp.get(i).getMaLoaiSP().getMaLoaiSP()) {
				kq=1;
			}
		}
		if(kq==0) {
			loaiSPService.deleteLoaiSanPham(id);
		}else {
			return "admin/LoaiSanPham/errorDeleteLSP";
		}
		
		return "redirect:/admin/loaisanpham";
	}
	
	
	private String doUpload(MultipartFile hinhanh) {
		
			String name = hinhanh.getOriginalFilename();
			String fileLocation = new File("src\\main\\resources\\static\\img\\shop").getAbsolutePath() + "\\" + name;
			if (name != null && name.length() > 0) {
				try {
										
					File serverFile = new File(fileLocation);

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(hinhanh.getBytes());
					stream.close();
					// 
				} catch (Exception e) {
				}
			}
			return "img/shop/"+name;
		}

	

}
