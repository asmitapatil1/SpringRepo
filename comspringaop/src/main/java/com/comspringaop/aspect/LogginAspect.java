package com.comspringaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.comspringaop.controller.EmpAccntController;




@Aspect
@Component

public class LogginAspect {
	
	EmpAccntController empacnt;
	 @Around("execution(* com.comspringaop.controller.EmpAccntController.withdraw(..) )")
	
	public void checkBalance()
	{
		System.out.println("Check the balance");
	}
	 
	 @ After("execution (* com.comspringaop.controller.EmpAccntController.diposite(..))")
	 public void updateBalance()
	 {
		 System.out.println("Please update the balance");
	 }
	 
	 @AfterReturning("execution (* com.comspringaop.controller.EmpAccntController.isHigher(..))")
	 public void checkaround()
	 {
		
		 if(true)
		 {
		 System.out.println(" balance is available");
		 }
		 System.out.println("balance is not available"); 
	 }

}
