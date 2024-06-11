package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tech.codehunt.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {

	private String result;
	@Override
	public String saveContact(String name, String email, String subject, String message, String datetime) {
		
		Connection connection=null;
		try {
			
			connection = ConnectionFactory.getConnection();
			String sql="insert into contact(name,email,subject,message,datetime) values(?,?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, email);
			prepareStatement.setString(3, subject);
			prepareStatement.setString(4, message);
			prepareStatement.setString(5, datetime);
			
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1) {
				result="MESSAGE SENT SUCCESSFULLY";
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
	public ArrayList<ContactPojo> readContact() {
		Connection connection=null;
		ArrayList<ContactPojo> arrayList = new ArrayList<ContactPojo>();

		try {
			connection = ConnectionFactory.getConnection();
			String sql="select * from contact";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ContactPojo(0, "ne", "ne", "ne", "ne", "ne"));
			}
			else
			{
				do
				{
					arrayList.add( new ContactPojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"),
							rs.getString("subject"), rs.getString("message"), rs.getString("datetime")));
				}
				while(rs.next());
			}
			
			System.out.println(arrayList.size());
			
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
	public String deleteContact(int sn) {
		Connection connection=null;
		try {
			
			connection = ConnectionFactory.getConnection();
			String sql="delete from contact where sn=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, sn);
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1) {
				result="MESSAGE DELETED SUCCESSFULLY";
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
