// ************************************************************************************************************
// DatabaseConnection.java				Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseConnection {
	public static Connection databaseLink;
	
	public static Connection getConnection() 
	{
		String databaseName = "java_crud";
		String databaseUser = "root";
		String databasePassword = "";
		String url = "jdbc:mysql://localhost/" + databaseName;
		String backDoor = "";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch(Exception e) 
		{
			e.printStackTrace();
			e.getCause();
		}
		
		return databaseLink;
	}
	
	private String status() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		
		return null;
	}
	
	public static ObservableList<users> getDataUsers() 
	{
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		ObservableList<users> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = connectDB.prepareStatement("select * from fall");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new users(rs.getString("course_code"), 
								   rs.getString("section_code"), 
								    rs.getString("course_name"),
						                   rs.getString("time"),
					      			      rs.getString("place"),
				           			   rs.getString("weekdays"),
				           			   rs.getString("instructor"),
				           			rs.getInt("curr_enrolled"),
				           			rs.getInt("max_enrolled")));
			}
		}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return list;
	}
}
