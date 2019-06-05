<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>

<head>
    <title>Company Home Page</title>
</head>

<body>

<h2>Company Home Page</h2>
<p>Welcome to the Company Home page</p>

<hr>
<p>User: <security:authentication property="principal.username" /></p>
<p>Role(s): <security:authentication property="principal.authorities" /></p>

<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps) <%--"peeps" means people/folk--%>
    </p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
    (Only for Admin peeps) <%--"peeps" means people/folk--%>
</p>
</security:authorize>

<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>

</body>

</html>
