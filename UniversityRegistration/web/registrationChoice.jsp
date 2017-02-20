<%-- 
    Document   : registrationChoice
    Created on : Feb 10, 2017, 7:05:31 AM
    Author     : mukainong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Mukai's user login DB</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
    </head>
    <body>
        <h1>Choose an identity to register</h1>
        <br>
        <form action="emailList" method="post">
            <input type=radio name="type" value="student" checked>Student
            <input type=radio name="type" value="professor">Professor
            <br>
            <br>
            <input type="submit" name="act" value="Next" class="margin_left">
            <input type="submit" name="act" value="Return" class="margin_left">
        <form>
    </body>
</html>
