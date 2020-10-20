package com.ymail.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ymail.model.EmployeeDetails;

public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//public void saveEmployee(EmployeeDetails details) {
	public void saveEmployee() {
		jdbcTemplate.update("insert into emp values(?,?,?,?,?,?)", 
				new Object[]{new Integer(1249),
			new String("azizaa"),new Float(541212),new String("4512122"),"M",new String("snp")});		
	}
	
	public void updateEmployee(EmployeeDetails details) {
		int count=jdbcTemplate.update("update emp set company=?, gender=?, name=?, phone=?,salary=? where id=? ", 
				new Object[] {details.getCompany(),details.getGender()+"",details.getName(),details.getPhone(),details.getSalary(),details.getId()});
			//	new String("ITC"),"M",new String("raj"),new String("121222"),new Float(121),new String("snp"));		
	System.out.println("  emp  "+count +" updated");
	}

	public void deleteEmployee(EmployeeDetails details) {
		int count=jdbcTemplate.update("delete from emp where id=? ", 
				new Object[] {details.getId()});
			//	new String("ITC"),"M",new String("raj"),new String("121222"),new Float(121),new String("snp"));		
	   System.out.println("  emp  "+count +" deleted");
	}
	
	public List<EmployeeDetails> getDetails(){	
	return jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper(EmployeeDetails.class));
}
}
