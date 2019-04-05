package com.comspringaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;


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
	 
	 @AfterReturning( pointcut="execution (* com.comspringaop.controller.EmpAccntController.isHigher(..))",returning ="returnval")
	 public void checkaround(boolean returnval)
	 {
		 if(returnval==true)
		 {
		 System.out.println(" balance is available"); 
		
		 }
		 else { System.out.println(" balance is not available");}
	 }
}
