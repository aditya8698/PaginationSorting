package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.demo.entity.Product;
import com.spring.demo.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo repo;
	
	@Override
	public List<Product> getListOfProducts() {
		
		return repo.findAll();
	}

	@Override
	public Page<Product> getPages(Integer currentPage, Integer size) {
		Sort sort = Sort.by(Direction.ASC, "name");
		Pageable pageable = PageRequest.of(currentPage, size, sort);
		return repo.findAll(pageable);
	}

}
