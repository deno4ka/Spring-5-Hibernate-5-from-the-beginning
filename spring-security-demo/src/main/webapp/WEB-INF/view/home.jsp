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
<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>

</body>
</html>
