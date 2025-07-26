
<%@page import="com.infosys.jdbc_prepared_statement_curd.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.infosys.jdbc_prepared_statement_curd.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="UTF-8">
<title>User List</title>

<style>
  table {
    border-collapse: collapse;
    width: 80%;
    margin: 20px auto;
    font-family: Arial, sans-serif;
  }

  th {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
  }

  td {
    padding: 8px;
    text-align: center;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  tr:hover {
    background-color: #ddd;
  }

  h1 {
    text-align: center;
    color: #333;
  }

  .rt {
    text-align: center;
    margin-top: 20px;
  }

  .rt a {
    background-color: #f44336;
    color: white;
    padding: 10px 15px;
    text-decoration: none;
    border-radius: 5px;
  }

  .rt a:hover {
    background-color: #d32f2f;
  }

  a {
    color: blue;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }
</style>

</head>


<body>
	<h1>Welcome to Display world</h1>
	<%
	 List<User> users = new UserDao().getAllUserDao();
     HttpSession hhtpSession = request.getSession();
	 String email = (String) hhtpSession.getAttribute("userSession");

	if (email != null) {
	%>

	<table border="1">
      <tr>

			<th>UserId:</th>
			<th>UserName:</th>
			<th>UserEmail:</th>
			<th>UserGender:</th>
			<th>UserDob:</th>
			<th colspan="2">Action :</th>

		</tr>
		<%
		for (User user : users) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getGender()%></td>
			<td><%=user.getDob()%></td>
			<td><a href="delete?id=<%=user.getId()%>">DELETE</a></td>
			<td><a href="user-update.jsp?id=<%=user.getId()%>">EDIT</a></td>
		</tr>
		<%
		}
		%>

	</table>

	<%
	} else {
	%>
	<%
	 request.setAttribute("message", "please login then try");
	
     request.getRequestDispatcher("user_login.jsp").forward(request, response);
	%>
	<%
	}
	%>
	<div class="rt"><a href="logout">LOGOUT</a></div>
  

</body>
</html>