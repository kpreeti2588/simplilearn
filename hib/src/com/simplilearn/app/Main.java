package com.simplilearn.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.model.EmployeeDetails;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
             Metadata metadata =new MetadataSources(standardRegistry).getMetadataBuilder().build();
             SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session= sessionFactory.openSession();
             
             EmployeeDetails employeedetails = new EmployeeDetails();
             employeedetails.setId(14393);
             employeedetails.setName("mirza");
             employeedetails.setPhone("53434343");
             employeedetails.setSalary(1212.43f);
             employeedetails.setGender('M');
             employeedetails.setCompany("CTS");
             
             EmployeeDetails details = session.get(EmployeeDetails.class, 12);
             System.out.println("Loaded details "+details);
             
             details.setPhone("1223242");
             details.setGender('F');
             
             Transaction transaction = session.getTransaction();
             transaction.begin();
             
             session.save(employeedetails);
             
             session.delete(employeedetails);
             
             transaction.commit();
             session.close();
	}
}
