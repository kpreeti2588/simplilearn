package com.simplilearn.model;

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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private float salary;
	private String phone;
	private char gender;
	private String company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("set name");
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
	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", salary=" + salary + ", phone=" + phone + ", gender=" + gender
				+ ", company=" + company + "]";
	}
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
