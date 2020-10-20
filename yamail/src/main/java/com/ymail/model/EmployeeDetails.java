package com.ymail.model;

public class EmployeeDetails {

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name,phone,company;
	private float salary;
	private char gender;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public EmployeeDetails(int id, String name, String phone, String company, float salary, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.company = company;
		this.salary = salary;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", phone=" + phone + ", company=" + company
				+ ", salary=" + salary + ", gender=" + gender + "]";
	}

	
	
}
