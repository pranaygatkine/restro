package tech.codehunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.service.ContactServiceImpl;


@WebServlet("/ContactServlet2")
public class ContactServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

		result = contactServiceImpl.contactService2(name, email, subject, message);
		session.setAttribute("msg", result);
		response.sendRedirect("contact.jsp");
	}
	

}
