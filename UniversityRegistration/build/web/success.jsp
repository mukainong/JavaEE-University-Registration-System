<%-- 
    Document   : success
    Created on : Feb 23, 2017, 12:02:39 AM
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
    <h1>Success!</h1>
    <br>
    <form action="emailList" method="post">
        <input type="submit" name="act" value="Prev" onclick="javascript:history.back();">
        <input type="submit" name="act" value="Logout">
    </form>
</body>
</html>