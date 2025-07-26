package com.infosys.jdbc_prepared_statement_curd.servlet_controller;

import java.io.IOException;
import java.time.LocalDate;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/userUpdate")
public class UserUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userid = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		String password = req.getParameter("userpassword");
		String gender = req.getParameter("usergender");
		LocalDate dob = LocalDate.parse(req.getParameter("userdob"));
		User user = new User(userid, name, email, password, gender, dob);
		User user2 = new UserDao().updateUserById(user);

		if (user2 != null) {
			resp.sendRedirect("user_display.jsp");
		} else {
			System.out.println("null");
		}

	}

}
			