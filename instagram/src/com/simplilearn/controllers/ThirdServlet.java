package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String gender = request.getParameter("gender");
		
		Cookie[] crr = request.getCookies();
		
		out.println("----------------Data from cookies ");
		for (Cookie cookie : crr) {
			out.println("Name: "+cookie.getName()+"<br>");
			out.println("Value: "+cookie.getValue()+"<br>");
			out.println("max age: "+cookie.getMaxAge()+"<br>");
			out.println("Domain: "+cookie.getDomain()+"<br>");
			out.println("Secure: "+cookie.getSecure()+"<br>");
		}
		
		out.println("------------------Data from cookies printed"+"<br>");
		
		out.println("------------------Data from session printed"+"<br>");
		HttpSession session = request.getSession(false);
	  
		
		out.print("Name:"+session.getAttribute("name")+"<br>");
		out.print("Salary:"+session.getAttribute("salary")+"<br>");
		out.print("Phone:"+session.getAttribute("phone")+"<br>");
		out.print("Company:"+session.getAttribute("company")+"<br>");
		out.print("Gender:"+gender+"<br>");
		
		out.println("------------------Data from application scope printed"+"<br>");
		ServletContext application = this.getServletContext();
		
		out.print("Name:"+application.getAttribute("name")+"<br>");
		out.print("Salary:"+application.getAttribute("salary")+"<br>");
		out.print("Phone:"+application.getAttribute("phone")+"<br>");
		out.print("Company:"+application.getAttribute("company")+"<br>");
		out.print("Gender:"+gender+"<br>");
		
		//	remove from application scope
		application.removeAttribute("name");
		application.removeAttribute("salary");
		application.removeAttribute("phone");
		application.removeAttribute("company");
		
		//remove from session scope
		session.removeAttribute("name");
		session.removeAttribute("salary");
		session.removeAttribute("phone");
		session.removeAttribute("company");
		
		out.println("------------------Data from hidden printed"+"<br>");
		out.print("Name:"+name+"<br>");
		out.print("Salary:"+salary+"<br>");
		out.print("Phone:"+phone+"<br>");
		out.print("Company:"+company+"<br>");
		out.print("Gender:"+gender+"<br>");
		
	}

}
