package com.spring.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.demo.entity.Product;
import com.spring.demo.repository.ProductRepo;
import com.spring.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/home")
	public String getProducts(Model m) {
		
//		List<Product> list = service.getListOfProducts();
//		m.addAttribute("list", list);
//		
//		return "Home";
		return findPages(0, m);
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPages(@PathVariable Integer pageNo,Model m) {
		Page<Product> plist = service.getPages(pageNo, 2);
		m.addAttribute("plist", plist);
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("totalPages", plist.getTotalPages());
		m.addAttribute("totalItems", plist.getTotalElements());
		return "Home";
	}
	
	@GetMapping("/search")
	public String getSearch(Model m,@Param("keyword") String name) {
		
		 Optional<Product> listProducts = repo.searchProduct(name);
	        m.addAttribute("listProducts", listProducts);
	        m.addAttribute("name", name);
		
		return "Home";
	}
}
