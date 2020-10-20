package com.simplilearn.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;
import com.simplilearn.service.IEmployeeDao;

public class UIPAge {

	public UIPAge() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EmployeeDao dao=new EmployeeDao();
	
		EmployeeDaoService dao=new EmployeeDaoService();
		
		System.out.println("Want to update emp details");
Scanner sc=new Scanner(System.in);


System.out.println("Want to delete emp details");
System.out.println("Enter empid to delete");
int id2=Integer.parseInt(sc.nextLine());
try {
	int deleted=dao.deleteEmpDetails(id2);
System.out.println("deleted "+deleted);

} catch (SQLException e4) {
	// TODO Auto-generated catch block
	e4.printStackTrace();
}


		System.out.println("Enter user id");
		int id=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter new phone");
		String newPhone=sc.nextLine();
		
		System.out.println("Enter new salary");
		float newSalary=   Float.parseFloat(sc.nextLine());
		
		EmployeeDetails empUpdateObject=new EmployeeDetails();
		empUpdateObject.setId(id);
		empUpdateObject.setPhone(newPhone);;
		empUpdateObject.setSalary(newSalary);
		
	int updated;
	try {
		updated = dao.updateEmpDetails(empUpdateObject);
		System.out.println("updated---"+updated);
		
		
	
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
		
		System.out.println("Avaialable emp details");
		List<EmployeeDetails> list;
		try {
			list = dao.getEmpDetails();
			System.out.println(list);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		//Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		String uname=sc.nextLine();
		
		System.out.println("Enter password");
		String password=sc.nextLine();
		
		try {
			int status=dao.validateUserDetails(uname, password);
		
			if(status==1){
				System.out.println("User login");
			}else{
				System.out.println("Login failed");
				
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//String n=sc.nextLine();
		//int nn=Integer.parseInt(n);
		
			
		// set values ?
		System.out.println("Enter name");
		String name=sc.nextLine();
		System.out.println("Enter salary");
		float salary=Float.parseFloat(sc.nextLine());
		System.out.println("Enter phone");
		String phone=sc.nextLine();
		
		System.out.println("Enter gender");
		char gender=sc.nextLine().charAt(0);

		
		System.out.println("Enter company");
		String company=sc.nextLine();
		EmployeeDetails employeeDetails=new EmployeeDetails(name, salary, phone, gender, company);
		
		
			
 try {
			int flag = dao.saveEmpDetails(employeeDetails);
		
 System.out.println("Your id is "+flag);
 } catch (SQLException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	
	System.out.println(e.getMessage());
}

		
		

	}

}
