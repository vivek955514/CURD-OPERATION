<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
  body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(to right, #74ebd5, #acb6e5);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .login-box {
    background-color: #fff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    width: 350px;
  }

  .login-box h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
  }

  .login-box label {
    font-weight: bold;
    display: block;
    margin: 10px 0 5px;
  }

  .login-box input[type="email"],
  .login-box input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-sizing: border-box;
    margin-bottom: 15px;
  }

  .login-box input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    border: none;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    cursor: pointer;
  }

  .login-box input[type="submit"]:hover {
    background-color: #388e3c;
  }

  .error-msg {
    color: red;
    text-align: center;
    margin-bottom: 10px;
  }
</style>
</head>
<body>
  <div class="login-box">
    <% 
      String msg = (String)request.getAttribute("message");
      if(msg != null){
    %>
    <div class="error-msg"><%= msg %></div>
    <% } %>

    <h2>Welcome to Login Page</h2>

    <form action="userLogin" method="get">
      <label for="useremail">User Email:</label>
      <input type="email" placeholder="Enter your email" name="useremail" required>

      <label for="userpassword">Password:</label>
      <input type="password" placeholder="Enter your password" name="userpassword" required>

      <input type="submit" value="LOGIN">
    </form>
  </div>
</body>
</html>
