<%-- 
    Document   : index
    Created on : Feb 10, 2017, 6:49:02 AM
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
    <h1>University Registration System</h1>
    <p>Please login or register a new account.
    </p>
    <p><i>${message}</i></p>
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">  
        
        <label class="pad_top">User ID:</label>
        <input type="text" name="id"><br>
        <label class="pad_top">Password:</label>
        <input type="password" name="password"><br>
        <label>&nbsp;</label>
        <input type="submit" name="act" value="Register" class="margin_left">
        <input type="submit" name="act" value="Login" class="margin_left">
    </form>
</body>
</html>