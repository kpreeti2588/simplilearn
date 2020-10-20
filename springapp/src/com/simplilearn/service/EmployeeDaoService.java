package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.EmployeeDetails;

@Component
public class EmployeeDaoService implements IEmployeeDao {

	public EmployeeDaoService() {
		// TODO Auto-generated constructor stub
	}
private EmployeeDao dao=EmployeeDao.getEmpDao();
	
	public int deleteEmpDetails(int id) throws SQLException {
		return dao.deleteEmpDetails(id);
	}

	public int updateEmpDetails(EmployeeDetails employeeDetails) throws SQLException {
  return  dao.updateEmpDetails(employeeDetails);
	}

	public List<EmployeeDetails> getEmpDetails() throws SQLException {
	return dao.getEmpDetails();
	}

	public int validateUserDetails(String username, String password) throws SQLException {
	
	return dao.validateUserDetails(username, password);
	}

	public int saveEmpDetails(EmployeeDetails employeeDetails) throws SQLException {
	return dao.saveEmpDetails(employeeDetails);
	
	}

}
