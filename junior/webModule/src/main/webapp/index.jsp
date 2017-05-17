<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyServletJSP</title>
</head>
<body>
<h3>Table users</h3>
Input data for add user: <br>
<form action="AddUsers" method="post">
    Name :<input type="text" name="name"/>
    Login :<input type="text" name="login"/>
    Email :<input type="text" name="email"/><br>
    <input type="submit" value="send">
</form>
<form action="DeleteUsers" method="get">
    Delete user: <br>
    Input login for delete user
    <input type="text" name="login" >
    <input type="submit" value="delete">
</form>
<form action="UpdateUsers" method="post">
    Edit user: <br>
    Input user login:
    <input type="text" name="login"><br>
    Input new name:
    <input type="text" name="name"><br>
    <input type="submit" value="edit">

</form>
<a href="showUsers.jsp">Show all users.</a>
</body>
</html>
