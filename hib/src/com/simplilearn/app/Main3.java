package com.simplilearn.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.model.AddressDetails;
import com.simplilearn.model.EmployeeDetails;


public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
             Metadata metadata =new MetadataSources(standardRegistry).getMetadataBuilder().build();
             SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session= sessionFactory.openSession();
             
				/*
				 * EmployeeDetails employeedetails = new EmployeeDetails();
				 * employeedetails.setId(14993); employeedetails.setName("mirza rihan");
				 * employeedetails.setPhone("53434343"); employeedetails.setSalary(1212.43f);
				 * employeedetails.setGender('M'); employeedetails.setCompany("CTS");
				 * 
				 * EmployeeDetails employeedetails2 = new EmployeeDetails();
				 * employeedetails2.setId(14193); employeedetails2.setName("rafiq");
				 * employeedetails2.setPhone("4545454"); employeedetails2.setSalary(133412.43f);
				 * employeedetails2.setGender('M'); employeedetails2.setCompany("TCS");
				 * 
				 * AddressDetails addressDetails = new AddressDetails();
				 * addressDetails.setCity("South Delhi"); addressDetails.setState("Delhi");
				 * addressDetails.setCountry("India"); addressDetails.setPincode(12345);
				 * addressDetails.setStreet("saket");
				 * 
				 * employeedetails.setAddressDetails(addressDetails);
				 */
             
          /*   Set<EmployeeDetails> set = new HashSet<>();
             set.add(employeedetails);
             set.add(employeedetails2);
             
             addressDetails.setEmployeeDetails(set);*/
				/*
				 * EmployeeDetails details = session.get(EmployeeDetails.class, 12);
				 * System.out.println("Loaded details "+details);
				 * 
				 * details.setPhone("1223242"); details.setGender('F');
				 */
             
             Transaction transaction = session.getTransaction();
             transaction.begin();
             
             Query query = session.createQuery("select e from EmployeeDetails e");
             List<EmployeeDetails> list= query.getResultList();
             
             System.out.println(list);
             
          //   session.save(addressDetails);
             
             
          //   session.save(employeedetails);
             
            // session.delete(employeedetails);
             
             transaction.commit();
             session.close();
	}
}
