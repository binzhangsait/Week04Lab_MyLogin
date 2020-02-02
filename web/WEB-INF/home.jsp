<%-- 
    Document   : home
    Created on : Jan 31, 2020, 10:55:15 AM
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
        <h1>Home Page</h1>

        <br>
        <h2>Hello ${username}.</h2>
        
        <a href="/Week04Lab_MyLogin/login?${username}">Log out</a>
        <hr>
        ${guestcount}
    </body>
</html>
