<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
  <h2>Login (JSP + Servlet + JDBC)</h2>
  <form action="login" method="post">
    <label>Username or Email: <input type="text" name="username" required></label><br>
    <label>Password: <input type="password" name="password" required></label><br>
    <button type="submit">Login</button>
  </form>
  <% String msg = (String) request.getAttribute("message");
     if(msg != null) { %>
    <p style="color:red;"><%= msg %></p>
  <% } %>
</body>
</html>
