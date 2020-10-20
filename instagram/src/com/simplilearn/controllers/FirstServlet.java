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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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
		
		
		//store in cookies 
		Cookie cookie1 = new Cookie("name", name);
		Cookie cookie2 = new Cookie("salary", salary);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		//store in session
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("name", name);
		httpsession.setAttribute("salary", salary);
		
		// Store in Application scope
		ServletContext application = this.getServletContext();
		application.setAttribute("name", name);
		application.setAttribute("salary", salary);
		
		out.print("<form action='/instagram/SecondServlet' method='POST'>"
		+"<input type='hidden' name='name' value="+name+">"
		+"<input type='hidden' name='salary' value="+salary+">"
		+"<input type='text' name='phone'>"
		+"<input type='text' name='company'>"
		+"<input type='submit' name='save' value='save'>"
		+"</form>");
		
		
	}

}
