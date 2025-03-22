<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>
                <a href="/users/edit?id=${user.id}">Edit</a>
                <form action="/users/delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/users/add">Add User</a>
</body>
</html>