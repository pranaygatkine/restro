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

@WebServlet("/ReadFourServiceModule")
public class ReadFourServiceModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        HttpSession session = request.getSession();
		
		ServiceModuleServiceImpl serviceModuleServiceImpl = new ServiceModuleServiceImpl();
		
		ArrayList<ServiceModulePojo> arrayList = serviceModuleServiceImpl.readFourService();
		session.setAttribute("check", "FROMSERVLET");
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("index.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("index.jsp");
		}
		else
		{
			String datetime = arrayList.get(0).getDatetime();
			if(datetime.equals("ne"))
			{
				session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
				response.sendRedirect("index.jsp");
			}
			else
			{
				session.setAttribute("servicedata", arrayList);
				response.sendRedirect("index.jsp");
			}
		}
		
	}
}
