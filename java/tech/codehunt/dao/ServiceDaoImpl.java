package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tech.codehunt.model.ServiceModulePojo;

public class ServiceDaoImpl implements ServiceDao {

 private String result;
	@Override
	public String saveService(String iconname, String title, String description, String datetime) {
		
		Connection connection=null;
		try {
			
			connection = ConnectionFactory.getConnection();
			String sql="insert into service(iconname , title , description, datetime) values(?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, iconname);
			prepareStatement.setString(2, title);
			prepareStatement.setString(3, description);
			prepareStatement.setString(4, datetime);
			
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1) {
				result="SERVICE ADDED SUCCESSFULLY";
			}
			else {
				result="SOMETHING WENT WRONG";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public ArrayList<ServiceModulePojo> readAllServices() {
		Connection connection=null;
		ArrayList<ServiceModulePojo> arrayList = new ArrayList<ServiceModulePojo>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql="select * from service";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
				do
				{
					ServiceModulePojo serviceModulePojo = new ServiceModulePojo(rs.getInt("sn"), rs.getString("iconname"),
							rs.getString("title"), rs.getString("description"), rs.getString("datetime"));
					arrayList.add(serviceModulePojo);
				}
				while(rs.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			arrayList.clear();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}
	@Override
	public ArrayList<ServiceModulePojo> readFourServices() {
		Connection connection=null;
		ArrayList<ServiceModulePojo> arrayList = new ArrayList<ServiceModulePojo>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql="select * from service LIMIT 4";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
				do
				{
					ServiceModulePojo serviceModulePojo = new ServiceModulePojo(rs.getInt("sn"), rs.getString("iconname"),
							rs.getString("title"), rs.getString("description"), rs.getString("datetime"));
					arrayList.add(serviceModulePojo);
				}
				while(rs.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			arrayList.clear();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}
	@Override
	public String deleteService(int sn) {
		
		Connection connection=null;
		try {
			
			connection = ConnectionFactory.getConnection();
			String sql="delete from service where sn=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, sn);
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1) {
				result="SERVICE DELETED SUCCESSFULLY";
			}
			else {
				result="SOMETHING WENT WRONG";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
