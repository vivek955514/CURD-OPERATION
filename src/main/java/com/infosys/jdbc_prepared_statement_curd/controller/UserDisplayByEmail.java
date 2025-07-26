package com.infosys.jdbc_prepared_statement_curd.controller;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class UserDisplayByEmail {

	public static void main(String[] args) {
		
		UserDao d = new UserDao();
		String email = "vivek343@gmail.com";
		String password = "43434we";
		
	User s = 	d.getUserByEmail(email);
	if(s!=null) {
		
		if(s.getPassword().equals(password)) {
			System.out.println("Login successfully"+" "+s.getName());
		}else {
			System.out.println("login failed check your password");
		}
		
	}
	else {
		System.out.println("email incorrect or somthing went wrong");
	}
	    
	
	}
	

}
