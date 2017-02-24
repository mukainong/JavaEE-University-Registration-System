<%-- 
    Document   : searchCourses
    Created on : Feb 14, 2017, 1:59:15 PM
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
    <h1>Welcome, Student ID ${id}</h1>
    <h1>Search a course</h1>
    <p>Fill in none or some of the blanks below to search a course:</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">
        <input type="hidden" name="id" value=${id}> 
        
        <label class="pad_top">Course Code:</label>
        <input type="text" name="crsCode"><br>
        <label class="pad_top">Course Name:</label>
        <input type="text" name="crsName"><br>
        <label class="pad_top">Department of the Course:</label>
        <input type="text" name="deptId"><br>
        <label class="pad_top">Professor's Name:</label>
        <input type="text" name="name"><br>
        <label>&nbsp;</label>
        <input type="submit" name="act" value="Prev" onclick="javascript:history.back();">
        <input type="submit" name="act" value="submit" class="margin_left">
        <input type="submit" name="act" value="logout" class="margin_left">
    </form>
</body>
</html>
