<%@ page import="java.sql.Connection" %>
<%@ page import="ru.job4j.Servlet3.DbConnect.StartConnect" %>
<%@ page import="ru.job4j.Servlet3.DbConnect.User" %><%--
  Created by IntelliJ IDEA.
  User: Katy
  Date: 17.05.2017
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
        StartConnect connect = new StartConnect();
        connect.startToDB();
        connect.getInitDB().getAllUsers();
        for (User user : connect.getInitDB().getUserList()) {%>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getDate()%></td>
        </tr>

       <% }
        connect.close();
    %>
</table>

     <a href="index.jsp">back</a>
    </body>
</html>
