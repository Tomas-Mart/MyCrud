<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add User</title>
    <style>
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<h1>Add User</h1>

<!-- Отображение общих ошибок -->
<c:if test="${not empty errorMessage}">
    <div class="error">
            ${errorMessage}
    </div>
</c:if>

<!-- Форма для добавления пользователя -->
<form:form action="/users/add" method="post" modelAttribute="user">
    <div>
        <label for="name">Name:</label>
        <form:input path="name" id="name" />
        <form:errors path="name" cssClass="error" />
    </div>
    <div>
        <label for="email">Email:</label>
        <form:input path="email" id="email" />
        <form:errors path="email" cssClass="error" />
    </div>
    <div>
        <label for="age">Age:</label>
        <form:input path="age" id="age" />
        <form:errors path="age" cssClass="error" />
    </div>
    <div>
        <label for="password">Password:</label>
        <form:password path="password" id="password" />
        <form:errors path="password" cssClass="error" />
    </div>
    <button type="submit">Add</button>
</form:form>

<a href="/users">Back to Users</a>
</body>
</html>