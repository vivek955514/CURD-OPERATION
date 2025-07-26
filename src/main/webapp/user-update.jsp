<%@page import="com.infosys.jdbc_prepared_statement_curd.dto.User"%>
<%@page import="com.infosys.jdbc_prepared_statement_curd.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>USER UPDATE FORM</h4>

    <%
	
	 HttpSession hhtpSession = request.getSession();
	 String email = (String) hhtpSession.getAttribute("userSession");

	int id = Integer.parseInt(request.getParameter("id"));
	User user = new UserDao().getUserById(id);
	
	if (email != null) {
	%>
	
	 <form action="userUpdate" method="get">
		<label>USERID</label><br> <input type="text" value="<%=id%>"
			name="userid"> <br> <label>User name</label><br> <input
			type="text" name="username" value="<%=user.getName()%>"> <br>

		<label>User Email</label><br> <input type="email"
			name="useremail" value="<%=user.getEmail()%>"> <br> <label>User
			Password</label><br> <input type="password" name="userpassword"
			value="<%=user.getPassword()%>"> <br> <label>User
			Dob</label><br> <input type="date" name="userdob"
			value="<%=user.getDob()%>"> <br> <label>User
			Gender</label><br> <input type="radio" name="usergender" value="MALE"
			<%if (user.getGender().equalsIgnoreCase("male")) {%> Checked="checked"
			<%}%>>MAILE <input type="radio" name="usergender"
			value="FEMALE" <%if (user.getGender().equalsIgnoreCase("female")) {%>
			Checked="checked" <%}%>>FEMALE <br> <input
			type="submit" value="update">

	</form>
	
	
	<% } else { %>
	
	
	
	<%
	 request.setAttribute("message", "please login then try");
	
     request.getRequestDispatcher("user_login.jsp").forward(request, response);
	%>
	<%
	}
	%>
	 
	
</body>
</html>