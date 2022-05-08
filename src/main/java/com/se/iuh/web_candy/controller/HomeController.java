package com.se.iuh.web_candy.controller;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.service.LoaiSPService;
import com.se.iuh.web_candy.service.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  private SanPhamService sanPhamService;

  @Autowired
  private LoaiSPService loaiSPService;

  @GetMapping("/")
  public String showHomePage() {
    return "redirect:/api/sanphams";
  }

  @GetMapping("/home")
  public String showShopHome() {

    return "index";
  }

  @GetMapping("/shop")
  public String showShop(Model model) {
    model.addAttribute("listProduct", sanPhamService.getSanPhams());
    model.addAttribute("listLoaiSP", loaiSPService.getLoaiSanPhams());
    return "shop";
  }

}
