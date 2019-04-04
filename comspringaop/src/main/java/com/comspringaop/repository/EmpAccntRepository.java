package com.comspringaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comspringaop.employeeAccountmodel.EmployeeAccount;

public interface EmpAccntRepository extends JpaRepository<EmployeeAccount, Integer>{

}
