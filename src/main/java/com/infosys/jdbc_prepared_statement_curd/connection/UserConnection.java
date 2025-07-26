package com.infosys.jdbc_prepared_statement_curd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {
      
	public static Connection getUserConnection() {
		
		  try {
		    	   Driver driver = new Driver();
		    	   
			    	DriverManager.registerDriver(driver);
			    	
			    	String url = "jdbc:mysql://localhost:3306/jdbc-e5";
			    	String user= "root";
			    	String pass = "root";
			    	return DriverManager.getConnection(url, user, pass);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
	}
	
}
