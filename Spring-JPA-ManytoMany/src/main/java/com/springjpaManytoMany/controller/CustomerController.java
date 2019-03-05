package com.springjpaManytoMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjpaManytoMany.model.Customer;
import com.springjpaManytoMany.repository.CustRepo;

@RestController
public class CustomerController {
	
	@Autowired
	CustRepo repo;
	
	@PostMapping(value="/save") 
	public String savedata(@RequestBody Customer customer)
	{
		
		repo.save(customer);
		return "data saved";
	}
	
	@GetMapping(value="/getcust")
	public List<Customer> getCust()
	{
		
		List<Customer> list=repo.findAll();
		return list;
	}

}
