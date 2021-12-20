package com.spring.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("select p.price from Product p where p.name=:name")
	public Optional<Product> searchProduct(String name);
	
}
