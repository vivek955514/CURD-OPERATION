package com.infosys.jdbc_prepared_statement_curd.servlet_controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/logout")
public class LogoutUserController   extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	req.getSession().invalidate();
		
		req.getRequestDispatcher("user_login.jsp").forward(req, resp);
	}

}
