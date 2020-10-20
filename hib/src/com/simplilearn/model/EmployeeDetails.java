package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeDetails {

	public EmployeeDetails(int id, String name, float salary, String phone, char gender, String company) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.company = company;
	}
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)   //Autoincremented line
	 @Column(name="id")
	private int id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name="salary")
		private float salary;
		
	 @Column(name="phone")
		private String phone;
		
	 @Column(name="gender")
		private char gender;
		
	 @Column(name="company")
		private String company;
	 
	 //many employee have one address -- collection	
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="fk_id",nullable=false)
	 AddressDetails addressDetails;
	
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", salary=" + salary + ", phone=" + phone + ", gender="
				+ gender + ", company=" + company + ", addressDetails=" + addressDetails + "]";
	}
	public EmployeeDetails(int id, String name, float salary, String phone, char gender, String company,
			AddressDetails addressDetails) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.company = company;
		this.addressDetails = addressDetails;
	}
	
	
	
	
	

}
