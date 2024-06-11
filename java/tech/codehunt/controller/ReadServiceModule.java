package tech.codehunt.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.model.ServiceModulePojo;
import tech.codehunt.service.ServiceModuleServiceImpl;

@WebServlet("/ReadServiceModule")
public class ReadServiceModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();    
		
		
		ServiceModuleServiceImpl serviceModuleServiceImpl = new ServiceModuleServiceImpl();
		ArrayList<ServiceModulePojo> arrayList = serviceModuleServiceImpl.readService();
		session.setAttribute("check", "FROMSERVLET");
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG: SERVICE LAYER");
			response.sendRedirect("service.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG: DAO LAYER");
			response.sendRedirect("service.jsp");
		}
		else
		{
			String datetime = arrayList.get(0).getDatetime();
			if(datetime.equals("ne"))
			{
				session.setAttribute("msg", "DATA DOES NOT EXIST");
				response.sendRedirect("service.jsp");
			}
			else
			{
				session.setAttribute("servicedata", arrayList);
				response.sendRedirect("service.jsp");
			}
		}
		
		
	}
}
