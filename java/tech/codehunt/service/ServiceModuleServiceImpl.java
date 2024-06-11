package tech.codehunt.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import tech.codehunt.dao.ServiceDaoImpl;
import tech.codehunt.model.ServiceModulePojo;

//import java.time.LocalDateTime;
//import java.util.ArrayList;

//import tech.codehunt.dao.ContactDaoImpl;
//import tech.codehunt.dao.ServiceDaoImpl;
//import tech.codehunt.model.ContactPojo;
//import tech.codehunt.model.ServiceModulePojo;
import tech.codehunt.validation.ServiceModuleValidationImpl;

public class ServiceModuleServiceImpl implements ServiceModuleService {

	private String result;
	@Override
	public String validateService(String iconname, String title, String description) {
      
		try {
			
			ServiceModuleValidationImpl serviceModuleValidationImpl = new ServiceModuleValidationImpl();
			result=serviceModuleValidationImpl.serviceModuleValidation(iconname, title, description);
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String addService(String iconname, String title, String description) {

		
		try {
			
			//DAO
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			String datetime = LocalDateTime.now().toString();
			
			result=serviceDaoImpl.saveService(iconname, title, description, datetime);
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}



	@Override
	public ArrayList<ServiceModulePojo> readService() {
		ArrayList<ServiceModulePojo> arrayList=null; 
		try {
			
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			arrayList = serviceDaoImpl.readAllServices();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public ArrayList<ServiceModulePojo> readFourService() {
		ArrayList<ServiceModulePojo> arrayList=null; 
		try {
			
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			arrayList = serviceDaoImpl.readFourServices();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}


	@Override
	public String deleteService(String sn) {

		try {
			
			int intsn=Integer.parseInt(sn);
			
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			result=serviceDaoImpl.deleteService(intsn);
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}
}

