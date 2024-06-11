package tech.codehunt.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.service.ContactServiceImpl;
import tech.codehunt.service.ServiceModuleServiceImpl;

@WebServlet("/DeleteServiceModuleServlet")
public class DeleteServiceModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String sn = request.getParameter("sn");
		
		ServiceModuleServiceImpl serviceModuleServiceImpl = new ServiceModuleServiceImpl();
		String result=serviceModuleServiceImpl.deleteService(sn);
		session.setAttribute("msg", result);
		
		response.sendRedirect("ReadServiceDeleteUpdateModule");
		
	}
}
