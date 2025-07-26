package com.infosys.jdbc_prepared_statement_curd.controller;

import java.time.LocalDate;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class InsertUserController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     UserDao dao =new UserDao();
	     
	     User user2 = new User();
	     user2.setId(166);
	     user2.setName("ravirai");
	     user2.setEmail("shrai343@gmail.com");
	     user2.setPassword("675434we");
	     user2.setGender("male");
	     user2.setDob(LocalDate.parse("1999-05-23"));
	     
	     User user3 = dao.saveUserDao(user2);
	     String msg = user3!=null?"saved":"not saved";
	     System.out.println(msg);
	     
	     

	}

}
