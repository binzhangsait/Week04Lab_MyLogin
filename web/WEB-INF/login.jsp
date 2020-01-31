<%-- 
    Document   : login
    Created on : Jan 31, 2020, 10:55:37 AM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form>
            Username:<input type="text" name="user"><br>
            Password:<input type="text" name="password"><br>
            <input type="submit" name="submit" value="Login">
        </form>
        <br>
        <hr>
        ${guestcount}
    </body>
</html>
