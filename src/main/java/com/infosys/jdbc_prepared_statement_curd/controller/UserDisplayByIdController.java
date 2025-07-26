package com.infosys.jdbc_prepared_statement_curd.controller;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class UserDisplayByIdController {

	public static void main(String[] args) {
		
		UserDao d1 = new UserDao();
		  User s = d1.getUserById(123);
		  String msg =s!=null?"user found":"user not found by id ";
		  System.out.println(msg);
		  System.out.println(s.getName());
		  
		  
		
		

	}

}
