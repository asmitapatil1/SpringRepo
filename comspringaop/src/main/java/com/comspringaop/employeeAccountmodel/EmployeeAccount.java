package com.comspringaop.employeeAccountmodel;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity

public class EmployeeAccount {
	public Integer getAccntId() {
		return accntId;
	}
	public void setAccntId(Integer accntId) {
		this.accntId = accntId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAcctBalance() {
		return acctBalance;
	}
	public void setAcctBalance(int acctBalance) {
		this.acctBalance = acctBalance;
	}
	@Id
	private Integer accntId;
	private String empName;
	private int acctBalance;
	
	
	
	

}
