package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
	//	session.setAttribute("user", name);
		String name = session.getAttribute("user").toString();
		System.out.println("user logged in ");
		
		if(session.getAttribute("user")!=null) {
		out.println("<h1>Welcome user</h1> "+ name);
		out.println("<a href=''>Home</a>"
				+ "<a href=''>About</a>"
				+ "<a href=''>ContactUs</a>"
				+ "<a href=''>Share</a>"
				+ "<a href='/linkedin/AllDetailsServlet'>List</a>"
				+ "<a href='/linkedin/LogoutServlet'>Logout</a>");
		}
		else {
			response.sendRedirect("/linkedin/index.html");
		}
	}


}
