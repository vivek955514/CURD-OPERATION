package com.infosys.jdbc_prepared_statement_curd.servlet_controller;

import java.io.IOException;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/delete")
public class DeleteUserByIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 HttpSession hhtpSession = req.getSession();
		 String email = (String) hhtpSession.getAttribute("userSession");

		if (email != null) {
		
		  int id = Integer.parseInt(req.getParameter("id"));

		   System.out.println("delete class doget method" + id);
	    	boolean b = new UserDao().deleteUserByIdDao(id);
	    	if (b) {
			req.getRequestDispatcher("user_display.jsp").forward(req, resp);
		}
	}
		else {
			 req.setAttribute("message", "please login then try");
				
		     req.getRequestDispatcher("user_login.jsp").forward(req, resp);
		}

	}}
