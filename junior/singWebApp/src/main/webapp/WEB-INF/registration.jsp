<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>auth</title>
</head>
<h3>Registration!</h3>
<body>
<c:if test="${error !=''}">
    <div style="background-color: red" >
        <c:out value="${error}"/>
    </div>
</c:if>
<fieldset>
    <legend>Registration</legend>
    <form action="Register" method="post">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="send" value="register"></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
