package com.infosys.jdbc_prepared_statement_curd.servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentController extends HttpServlet{
         
	      @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       resp.setContentType("text/html");
	       
	    	    System.out.println("do ----- get");
	    	   int  userid =  Integer.parseInt(req.getParameter("userid"));
	            String name=  req.getParameter("username");
	    	   String email = req.getParameter("useremail");
	    	   String password = req.getParameter("userpassword");
	    	   String gender = req.getParameter("usergender");
	    	   LocalDate  dob= LocalDate.parse(req.getParameter("userdob"));
	    	   
	    	   User user = new User(userid,name,email,password,gender,dob);
	    	   UserDao dao =new UserDao();
	    	   User user2 = dao.saveUserDao(user);
	    	   
//	    	   System.out.println(user);
	    	  PrintWriter printWriter = resp.getWriter();
//	    	  printWriter.write(name);
//	    	  printWriter.write(user.toString());
	    	  
	    	 
	   if(user2!=null) {
		   
		   
		      req.setAttribute("message", "✓ Account Created Successfully!");
	    	  
	          RequestDispatcher dispatcher = req.getRequestDispatcher("user_login.jsp");
	          dispatcher.include(req, resp);
		   
	   }
	   
	   else {
	          req.setAttribute("message", " ✕ Something went wrong, please try again!");
	    	  
	          RequestDispatcher dispatcher = req.getRequestDispatcher("user-registration.jsp");
	          dispatcher.include(req, resp);
	   
	   }
	    	  
	    	  
	    	  
	    
	    }
}
