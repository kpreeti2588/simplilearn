package com.simplilearn.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		// find driver name
		
		//1.
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Statement statement=null;
		Connection connectionObject=null;
		//2.
		try {
		//step1
			DriverManager.registerDriver(new Driver());
	//step 2
			 connectionObject=
			DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8", "root", "admin123");
	//	prepare qury
			//insert into emploe
	//insert into employee(name,salary,phone,gender,company) values("aahmed",50
	//		000,"1234567890",'M','simplilearn');
	//step3
		 statement=	connectionObject.createStatement();
	int count=	statement.executeUpdate("insert into employee(name,salary,phone,gender,company)"
				+ " values('arani',50001,'1234567861','M','simplilearn')");

	//step 4
	System.out.println("inserted ="+count);
	String query="update employee set salary=25000,phone='12345' where gender='F'";
	int countUpdate=	statement.executeUpdate(query);
	System.out.println("updated ="+countUpdate);
	String deleteQuery="delete from employee where salary=25000";
	int countdelete=	statement.executeUpdate(deleteQuery);
	System.out.println("deleted ="+countdelete);
	
	
	
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	     e.printStackTrace();
	     System.out.println(e.getMessage());
		}finally {
			
			
			//step 5
			if(connectionObject!=null){
				try {
					connectionObject.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error in closing the resource");
				}
			}

			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error in closing the resource");
				}
			}
			
			
			
		}
		
		
		
		
		
		
	}

}
