package com.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.util.SessionFactoryUtil;

public class EmployeeDao {

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	SessionFactory util = SessionFactoryUtil.getSessionFactory();
	public void register(EmployeeDetails details) {
		Session session= util.openSession();
	
		Transaction transaction = session.getTransaction();
        transaction.begin();
		session.save(details);
		transaction.commit();
		
		EmployeeDetails emp =session.load(EmployeeDetails.class,details.getId());
		
		if(emp!=null) {
			System.out.println("data is saved");
		}
		else {
			System.out.println("data is not saved ");
		}
		
		session.close();
	}
	
	public EmployeeDetails getEmployeeById(int id) {
		EmployeeDetails details =null;
		System.out.println(util);
		Session session= util.openSession();
		
		details= session.load(EmployeeDetails.class, id);
		session.close();
		return details;
	}
	
	//want to update phone 
	public void updateEmployee(int id,String phone) {
		Session session = util.openSession();
		EmployeeDetails emp =session.load(EmployeeDetails.class,id);
		
		emp.setPhone(phone);
		Transaction transaction = session.getTransaction();
        transaction.begin();
        
		session.update(emp);
				
		transaction.commit();
		System.out.println("data updated");
		session.close();
		
	}
	
	//want to delete phone 
	public void deleteEmployee(int id) {
		Session session = util.openSession();
		EmployeeDetails emp =session.load(EmployeeDetails.class, id);
		
		Transaction transaction = session.getTransaction();
        transaction.begin();
        
		session.delete(emp);
				
		transaction.commit();
		
		EmployeeDetails emp1 =session.load(EmployeeDetails.class, id);
		if(emp1==null) {		
		System.out.println("data deleted");
		}else {
			System.out.println("data not deleted");
		}
		session.close();
		
	}
}
