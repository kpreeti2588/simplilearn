package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.model.EmployeeDetails;

public interface IEmployeeDao {
	public int deleteEmpDetails(int id) throws SQLException ;
	public int updateEmpDetails(EmployeeDetails employeeDetails) throws SQLException;
	public List<EmployeeDetails> getEmpDetails() throws SQLException;
	public int validateUserDetails(String username, String password) throws SQLException;
	public int saveEmpDetails(EmployeeDetails employeeDetails) throws SQLException;
}
