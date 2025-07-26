package com.infosys.jdbc_prepared_statement_curd.controller;


import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class UserDeleteController {

	public static void main(String[] args) {
		
		
		
		boolean t = new UserDao().deleteUserByIdDao(122);
		
		String  msg = t!=false?"delete successfully":"not delete successfully";
		System.out.println(msg);
		


	}

}
