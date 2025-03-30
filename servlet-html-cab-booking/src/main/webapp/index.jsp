<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.companyname.dept.functionality.model.Users" %>
<%@ page import="com.companyname.dept.functionality.service.UserService" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>Registered Users</h2>

    <%
        UserService userService = new UserService();
        List<Users> users = userService.getAllUsers();
        if (users.isEmpty()) {
    %>
        <p>No users found.</p>
    <%
        } else {
    %>
        <ul>
            <%
                for (Users user : users) {
            %>
                <li><%= user.getName() %> - <%= user.getEmail() %> - <%= user.getPhone() %></li>
            <%
                }
            %>
        </ul>
    <%
        }
    %>

    <br>
    <a href="user-registration.jsp">Register New User</a>
</body>
</html>
