package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class GetDataContoller
 */
@WebServlet("/GetDataContoller")
public class GetDataContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    EmployeeDaoService eService= new EmployeeDaoService();
		
		HttpSession session=request.getSession(false);
	//	PrintWriter out = response.getWriter();
		
		RequestDispatcher rd=null;
		try {
			if(session!=null) {
			List<EmployeeDetails> list = eService.getEmpDetails();
			
			request.setAttribute("employees", list);
			rd=request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
			}else {
				response.sendRedirect("/linkedin/index.jsp");
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rd= request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
