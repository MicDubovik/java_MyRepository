<%@ page import="ru.job4j.Servlet3.DbConnect.User" %>
<%@ page import="ru.job4j.Servlet3.DbConnect.InitDB" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
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
        <th>email</th>
        <th>date</th>
    </tr>

    <c:forEach items="${users}" var="u" >
        <tr>
            <td><c:out value="${u.id}"></c:out></td>
            <td><c:out value="${u.name}"></c:out></td>
            <td><c:out value="${u.login}"></c:out></td>
            <td><c:out value="${u.email}"></c:out></td>
            <td><c:out value="${u.date}"></c:out></td>
        </tr>
    </c:forEach>


</table>

     <a href="${pageContext.servletContext.contextPath}">back</a>
    </body>
</html>
