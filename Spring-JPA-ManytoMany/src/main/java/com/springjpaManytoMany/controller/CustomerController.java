package com.springjpaManytoMany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjpaManytoMany.model.Customer;
import com.springjpaManytoMany.repository.CustRepo;

import ch.qos.logback.core.net.SyslogOutputStream;

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
	
	@GetMapping (value="/getcust/{id}")
	public Optional<Customer> getCustById(@PathVariable(value="id") int id)
	{
		

		return repo.findById(id);
	}
	@PutMapping(value="/getcust/{id}")
	public  String updateCustomer(@PathVariable(value="id")int id,@RequestBody Customer cust)
	{
		
		Optional<Customer> customer=repo.findById(id);
		System.out.println(customer.get());
		if(customer.isPresent())
		{
			customer.get().setCustName(cust.getCustName());
			customer.get().setCustCity(cust.getCustCity());
			repo.save(customer.get());
			
		}
		
	
		
	         return "data successfully updated";
	}
}
