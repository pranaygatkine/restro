package tech.codehunt.test;

import java.util.ArrayList;

//import tech.codehunt.dao.ConnectionFactory;
import tech.codehunt.dao.ContactDaoImpl;
import tech.codehunt.dao.ServiceDaoImpl;
import tech.codehunt.model.ContactPojo;
import tech.codehunt.model.ServiceModulePojo;

public class Launch {
	public static void main (String[] args) {
	  
ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
ArrayList<ServiceModulePojo> al = serviceDaoImpl.readFourServices(); 
//ArrayList <ServiceModulePojo> fourServices =  serviceDaoImpl.ServiceDaoImpl();
	for(ServiceModulePojo sp: al) {
		System.out.println(sp.toString());
	
	}
	}

}
