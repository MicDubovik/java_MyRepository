<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>users</title>
</head>
    <body>
     <h1>Users information</h1>
     <style>
         table, th, td {
             border: 1px solid black;
         }
     </style>
<table >
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>date</th>
        <th>role</th>
    </tr>

    <c:forEach items="${users}" var="u" >
        <tr>
            <td><c:out value="${u.id}"></c:out></td>
            <td><c:out value="${u.name}"></c:out></td>
            <td><c:out value="${u.login}"></c:out></td>
            <td><c:out value="${u.password}"></c:out></td>
            <td><c:out value="${u.email}"></c:out></td>
            <td><c:out value="${u.date}"></c:out></td>
            <td><c:out value="${u.role}"></c:out></td>
        </tr>
    </c:forEach>

</table>

     <a href="${pageContext.servletContext.contextPath}/">back</a>
    </body>
</html>
