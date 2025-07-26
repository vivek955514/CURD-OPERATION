# CURD Operation Web App (JSP + Servlet + JDBC + Session)

This is a Java EE-based web application that performs basic **CRUD operations** (Create, Read, Update, Delete) using:

- **JSP** (JavaServer Pages) for the front end
- **Servlets** for controller logic
- **JDBC** for database connectivity
- **HTTP Sessions** for maintaining user login state
- **MySQL** as the database

---

## 📌 Features

- ✅ **User Registration** form with validation
- ✅ **Login Authentication** with session management
- ✅ **HTTP Session Tracking** for maintaining login state across multiple requests
- ✅ Display logged-in user's email or name
- ✅ **CRUD operations**: Add, View, Update, Delete users
- ✅ **Logout** feature with session invalidation
- ✅ Styled JSP pages using **Internal CSS**

---

## 💻 Technologies Used

| Layer       | Technology      |
|-------------|-----------------|
| Frontend    | JSP, HTML, CSS  |
| Backend     | Java Servlets   |
| DB Access   | JDBC (PreparedStatement) |
| Database    | MySQL           |
| App Server  | Apache Tomcat (v9/10) |
| IDE         | Eclipse         |
| Versioning  | Git + GitHub    |

---

## ⚙️ Session Management

This application uses `HttpSession` to:

- Store the logged-in user's email:  
  ```java
  session.setAttribute("userSession", email);
