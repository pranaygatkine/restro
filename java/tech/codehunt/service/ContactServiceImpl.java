package tech.codehunt.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import tech.codehunt.dao.ContactDaoImpl;
import tech.codehunt.model.ContactPojo;
import tech.codehunt.validation.ContactValidationImpl;
 
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import tech.codehunt.dao.ContactDaoImpl;
//import tech.codehunt.model.ContactPojo;
//import tech.codehunt.validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {

	private String result;
	@Override
	public String contactService1(String name, String email, String subject, String message) {
		
		
		try {
			
			ContactValidationImpl contactValidationImpl = new ContactValidationImpl();
			result=contactValidationImpl.contactValidation(name, email, subject, message);
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String contactService2(String name, String email, String subject, String message) {

		try {
			
			String datetime = LocalDateTime.now().toString();
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result = contactDaoImpl.saveContact(name, email, subject, message, datetime);
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	
	}
	@Override
	public ArrayList<ContactPojo> readContactService() {
	
		ArrayList<ContactPojo> arrayList=null; 
		try {
			
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			arrayList= contactDaoImpl.readContact();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}



	@Override
	public String deleteService(String sn) {

		try {
			
			int intsn=Integer.parseInt(sn);
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result=contactDaoImpl.deleteContact(intsn);
			
			
			
		} catch (Exception e) {
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}

}