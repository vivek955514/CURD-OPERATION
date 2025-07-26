<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
  body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(to right, #ffecd2, #fcb69f);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  
  .message-box {
  background-color: #f2f2f2;
  color: #d8000c;
  padding: 10px;
  margin-bottom: 15px;
  border-left: 6px solid #f44336;
  border-radius: 6px;
  font-weight: bold;
  text-align: left;
}

  .container {
    background-color: #fff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    width: 400px;
  }

  .container h4 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
  }

  label {
    font-weight: bold;
    display: block;
    margin-top: 15px;
  }

  input[type="text"],
  input[type="email"],
  input[type="password"],
  input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-sizing: border-box;
  }

  input[type="radio"] {
    margin-top: 10px;
    margin-right: 5px;
  }

  input[type="submit"] {
    margin-top: 20px;
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    border: none;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #388e3c;
  }
</style>
</head>
<body>
  <div class="container">
  
     <% String msg = (String) request.getAttribute("message");
     if (msg != null) { %>
    <div class="message-box"><%= msg %></div>
  <% } %>
    <h4>USER Registration Form</h4>
    <form action="userRegister" method="get">
      <label>USER ID</label>
      <input type="text" placeholder="Enter user ID" name="userid">

      <label>User Name</label>
      <input type="text" placeholder="Enter user name" name="username">

      <label>User Email</label>
      <input type="email" placeholder="Enter user email" name="useremail">

      <label>User Password</label>
      <input type="password" placeholder="Enter user password" name="userpassword">

      <label>User Gender</label>
      <input type="radio" name="usergender" value="MALE"> MALE
      <input type="radio" name="usergender" value="FEMALE"> FEMALE

      <label>User DOB</label>
      <input type="date" name="userdob">

      <input type="submit" value="Register">
    </form>
  </div>
</body>
</html>
