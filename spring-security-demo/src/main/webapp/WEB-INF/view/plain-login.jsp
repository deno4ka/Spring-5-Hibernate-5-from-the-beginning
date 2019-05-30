<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Custom Login Page</title>

    <style>
        .failed {
            color: red;
        }
    </style>

</head>

<body>

<h3>My Custom Login Page</h3>

<form:form action="/authenticateTheUser"
           method="post">

<%--    error = ${param.error}--%>

    <!-- Check for login error -->

    <c:if test="${param.error != null}">
<%--    <c:if test="${not empty param.error}">--%>

        <i class="failed">Sorry! You entered invalid username/password.</i>

    </c:if>

    <p>
        User name: <input type="text" name="username" />
    </p>

    <p>
        Password: <input type="password" name="password" />
    </p>

    <input type="submit" value="Login" />

</form:form>

</body>

</html>
