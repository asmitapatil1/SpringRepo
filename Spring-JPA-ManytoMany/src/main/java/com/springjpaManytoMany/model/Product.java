package com.springjpaManytoMany.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Product {
	@Id
	private Integer id;
	private String prodNmae;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="cust_prod",joinColumns=@JoinColumn(name="cust_id",referencedColumnName="id") ,inverseJoinColumns=@JoinColumn(name="prod_id",referencedColumnName="id"))
	
	private Set<Customer> customer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdNmae() {
		return prodNmae;
	}
	public void setProdNmae(String prodNmae) {
		this.prodNmae = prodNmae;
	} 

	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

}
