<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Student's favourite programming language is: ${student.favouriteLanguage}
<br><br>
Operating Systems:
<ul>
    <c:forEach var="os" items="${student.operatingSystems}">
        <li> ${os} </li>
    </c:forEach>
</ul>
</body>
</html>
