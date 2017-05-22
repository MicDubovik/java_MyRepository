<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>auth</title>
</head>
<h3>Sign in!</h3>
<body>

<c:if test="${error !=''}">
    <div style="background-color: red" >
        <c:out value="${error}"/>
    </div>
</c:if>
<fieldset>
    <legend>Login</legend>
    <form action="Signin" method="post">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="send" value="Login"></td>
            </tr>
        </table>
    </form>
    <form action="Register" method="get">
        <tr>
            <td>New user</td>
            <td><input type="submit" value="Registration"></td>
        </tr>
    </form>
</fieldset>
</body>
</html>
