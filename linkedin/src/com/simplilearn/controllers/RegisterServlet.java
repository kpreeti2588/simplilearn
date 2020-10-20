package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("submit").equals("save")) {
		String name= request.getParameter("name");
		String salary= request.getParameter("salary");
		String phone= request.getParameter("phone");
		String gender= request.getParameter("gender");
		String company= request.getParameter("company");
		
		EmployeeDaoService daoService =new EmployeeDaoService();
		EmployeeDetails details = new EmployeeDetails();
		
		details.setName(name);
		details.setPhone(phone);
		details.setCompany(company);
		float sal = Float.parseFloat(salary);
		char gen = gender.charAt(0);
		
		details.setGender(gen);
		details.setSalary(sal);
		
		RequestDispatcher rd = null;
		try {
			int id = daoService.saveEmpDetails(details);
			
			if(id!=0) {
				rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
		}
	}

}
