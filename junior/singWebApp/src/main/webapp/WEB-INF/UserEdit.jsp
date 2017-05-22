<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

       <form action="UpdateUser" method="post">
           Input new name:
           <input type="text" name="name"><br>
           <input type="submit" value="edit">

       </form>
       <form action="Signout" method="get">
           <input type="submit" value="Sign out">

       </form>



</body>
</html>
