package com.simplilearn.app;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.EmployeeDetails;

public class Main2 {

	public Main2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         EmployeeDao dao = new EmployeeDao();
         
         dao.updateEmployee(2, "8885545");
         dao.deleteEmployee(6);
         
         EmployeeDetails detail = dao.getEmployeeById(1);
         if(detail==null) {
        	 System.out.println("emp not found");
         }else {
        	 System.out.println("emp found");
        	 System.out.println("Details are "+detail);
         }
         

         
         
	}

}
