package com.springjpaManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpaManytoMany.model.Customer;

public interface CustRepo extends JpaRepository<Customer, Integer>{
	

	
}
