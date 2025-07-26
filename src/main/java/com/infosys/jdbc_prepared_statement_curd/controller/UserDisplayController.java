package com.infosys.jdbc_prepared_statement_curd.controller;

import java.util.List;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

public class UserDisplayController {

	public static void main(String[] args) {
		
		
		List<User> users = new UserDao().getAllUserDao();
		for(User user :users) {
			System.out.println(user);
		}

	}

}
