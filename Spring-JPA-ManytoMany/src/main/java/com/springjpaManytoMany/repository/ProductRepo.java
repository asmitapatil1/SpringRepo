package com.springjpaManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpaManytoMany.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
