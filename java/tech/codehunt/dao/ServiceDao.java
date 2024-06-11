package tech.codehunt.dao;

import java.util.ArrayList;

import tech.codehunt.model.ServiceModulePojo;

public interface ServiceDao {


	public String saveService(String iconname, String title, String description, String datetime);
	public ArrayList<ServiceModulePojo> readAllServices();
	public ArrayList<ServiceModulePojo> readFourServices();
	public String deleteService(int sn);



}
