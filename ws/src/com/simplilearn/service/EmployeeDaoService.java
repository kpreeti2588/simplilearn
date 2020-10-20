package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.EmployeeDetails;

@Path("/empservice")
public class EmployeeDaoService {

	public EmployeeDaoService() {
		// TODO Auto-generated constructor stub
	}
	
	
	private EmployeeDao dao=new EmployeeDao();
	
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteEmpDetails(EmployeeDetails employeeDetails) throws SQLException {
		return dao.deleteEmpDetails(employeeDetails.getId());
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int updateEmpDetails(EmployeeDetails employeeDetails) throws SQLException {
		return  dao.updateEmpDetails(employeeDetails);
	}

	@GET
	@Path("/emp")
	@Produces(MediaType.APPLICATION_XML)
	public List<EmployeeDetails> getEmpDetails() throws SQLException {
		return dao.getEmpDetails();
	}
	
	@GET
	@Path("/empjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeDetails> getEmpDetail() throws SQLException {
		return dao.getEmpDetails();
	}
	
	@GET
	@Path("/emphtml")
	@Produces(MediaType.TEXT_HTML)
	public List<EmployeeDetails> getEmpDetail1() throws SQLException {
		return dao.getEmpDetails();
	}
	

	public int validateUserDetails(String username, String password) throws SQLException {	
		return dao.validateUserDetails(username, password);
	}

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int saveEmpDetails(EmployeeDetails employeeDetails) throws SQLException {
		return dao.saveEmpDetails(employeeDetails);	
	}

}
