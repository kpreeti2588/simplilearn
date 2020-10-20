package com.simplilearn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressDetails {

	public AddressDetails() {
		// TODO Auto-generated constructor stub
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="aid")
   private int aid;
   
   @Column(name="street")
   private String street;
   
   @Column(name="pincode")
   private int pincode;
   
   @Column(name="city")
   private String city;
   
   @Column(name="state")
   private String state;
   
   @Column(name="country")
   private String country;
   
   //collection-- one address for many employee
   @OneToMany(fetch=FetchType.LAZY)
   private  Set<EmployeeDetails> employeeDetails = new HashSet<>();
   
public Set<EmployeeDetails> getEmployeeDetails() {
	return employeeDetails;
}
public void setEmployeeDetails(Set<EmployeeDetails> employeeDetails) {
	this.employeeDetails = employeeDetails;
}

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
@Override
public String toString() {
	return "AddressDetails [aid=" + aid + ", street=" + street + ", pincode=" + pincode + ", city=" + city + ", state="
			+ state + ", country=" + country + ", employeeDetails=" + employeeDetails + "]";
}
public AddressDetails(int aid, String street, int pincode, String city, String state, String country,
		Set<EmployeeDetails> employeeDetails) {
	super();
	this.aid = aid;
	this.street = street;
	this.pincode = pincode;
	this.city = city;
	this.state = state;
	this.country = country;
	this.employeeDetails = employeeDetails;
}


   
	
}
