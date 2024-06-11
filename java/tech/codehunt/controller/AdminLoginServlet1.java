package tech.codehunt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.service.AdminLoginServiceImpl;

@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		  

		AdminLoginServiceImpl adminLoginServiceImpl = new AdminLoginServiceImpl();
		String result = adminLoginServiceImpl.adminLoginService1(username, password);
		
		if(result.equals("VALID"))
		{
			//FORWARD  
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminLoginServlet2");
		     requestDispatcher.forward(request, response);
		}
		else
		{
			session.setAttribute("msg", result);
			response.sendRedirect("adminlogin.jsp");		
	}

}
	}
