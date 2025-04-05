<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Registered Users</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th></tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
<a href="index.jsp">Home</a>
</body>
</html>
