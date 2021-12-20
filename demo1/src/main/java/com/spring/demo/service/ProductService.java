package com.spring.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.demo.entity.Product;

public interface ProductService {

	List<Product> getListOfProducts();
	
	Page<Product> getPages(Integer currentPage,Integer size);
	
}
