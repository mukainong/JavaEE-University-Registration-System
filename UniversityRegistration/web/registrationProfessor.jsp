<%-- 
    Document   : registrationProfessor
    Created on : Feb 10, 2017, 11:55:18 AM
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
        <h1>Enter your info to register</h1>
        <br>
        <form action="emailList" method="post">
            <label class="pad_top">Professor ID:</label>
            <input type="text" name="id" required><br>
            <label class="pad_top">Password:</label>
            <input type="text" name="password" required><br>
            <label class="pad_top">Name:</label>
            <input type="text" name="name" required><br>
            <label class="pad_top">Status:</label>
            <select name="status">
                <option value = "CSE" selected> CSE </option>
                <option value = "INF"> INF </option>
                <option value = "ECE"> ECE </option>
                <option value = "ESE"> ESE </option>
            </select>
            <br>
            <input type="submit" name="act" value="Prev" onclick="javascript:history.back();">
            <input type="submit" name="act" value="FinishProfessor">
            <input type="submit" name="act" value="Cancel" formnovalidate>
        <form>
    </body>
</html>
