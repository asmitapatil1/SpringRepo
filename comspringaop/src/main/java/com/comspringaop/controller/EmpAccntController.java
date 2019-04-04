package com.comspringaop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.comspringaop.employeeAccountmodel.EmployeeAccount;
import com.comspringaop.repository.EmpAccntRepository;

@EnableAspectJAutoProxy
@Component
@RestController
public class EmpAccntController {
	
	@Autowired
	private EmpAccntRepository repo;
	
	EmployeeAccount empacnt =new EmployeeAccount();
	
	
	@GetMapping(value="/allrecords")
	public List<EmployeeAccount> getAllRecord()
	{
		List<EmployeeAccount> list=repo.findAll();
		
		return list;
	}
	
	@PostMapping(value="/addrecaords")
	public EmployeeAccount addEmployee(@RequestBody EmployeeAccount empacnt)
	
    {
				
		return repo.save(empacnt);
	}
	
	@GetMapping(value="/getbalance/{id}")
	public boolean isHigher( @PathVariable (value="id")int id)
	{
	   Optional<EmployeeAccount> emp=repo.findById(id);
	   int balance=emp.get().getAcctBalance();
	    if (balance >0)
		
	    	return true;
	    else
	
	    	return false;
	}
	
	@PutMapping(value="/depositemoney/{id}/{accbalance}")
	public void diposite (@PathVariable(value="id")int id,@PathVariable(value="accbalance")int accbalance)
	{
		Optional<EmployeeAccount> emp=repo.findById(id);
		int balance=emp.get().getAcctBalance();
		int salary=balance +accbalance;
		emp.get().setAcctBalance(salary);
		repo.save(emp.get());
	}
	@GetMapping(value="/withdraw/{id}/{withdrawamt}")
	public void withdraw(@PathVariable (value="id")int id,@PathVariable(value="withdrawamt")int withdrawamt)
	
	{
		Optional<EmployeeAccount> emp=repo.findById(id);
		int balance=emp.get().getAcctBalance();
		if(isHigher(id)==true)
		{
			System.out.println("Inside ishigher true");
			int finalbalance=balance-withdrawamt;
			emp.get().setAcctBalance(finalbalance);
			repo.save(emp.get());
			
		}
		
	}
}
