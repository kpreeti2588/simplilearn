package com.simplilearn.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	
	private int id;
	
	private String name;
	
	private float salary;
	
	private String phone;

	private char gender;

	private String company;
	
	//@XmlElement
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	//@XmlElement
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		System.out.println("set name");
		this.name = name;
	}
	//@XmlElement
	public float getSalary() {
		return salary;
	}
	@XmlElement
	public void setSalary(float salary) {
		this.salary = salary;
	}
	//@XmlElement
	public String getPhone() {
		return phone;
	}
	@XmlElement
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	@XmlElement
	public char getGender() {
		return gender;
	}
	@XmlElement
	public void setGender(char gender) {
		this.gender = gender;
	}
//	@XmlElement
	public String getCompany() {
		return company;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", salary=" + salary + ", phone=" + phone + ", gender=" + gender
				+ ", company=" + company + "]";
	}
	
	@XmlElement
	public void setCompany(String company) {
		this.company = company;
	}
	public EmployeeDetails(String name, float salary, String phone, char gender, String company) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.company = company;
	}
	
	
	

}
