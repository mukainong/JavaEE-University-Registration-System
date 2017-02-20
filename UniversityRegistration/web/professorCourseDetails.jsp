<%-- 
    Document   : professorDetailsInfo
    Created on : Feb 13, 2017, 1:47:50 PM
    Author     : mukainong
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Mukai's user login DB</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
</head>

<body>
    <h1>View and Update the Selected Course</h1>
    
    <br>
    
    <p>This is the selected course. You can check the student list and update student's GRADE here.</p>
    
    <br>
    
    <table border="8" style="width:800px">
        <tr>
          <td style="width: 20%">
              <span style="font-size: 10pt">Course Code</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Course Name</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Student ID</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Student Name</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Grade</span></td>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach items="${objectList}" var="object">
        <tr>
            <td>
                <span style="font-size: 10pt">${object[0]}</span></td>
            <td>
                <span style="font-size: 10pt">${object[1]}</span></td>
            <td>
                <span style="font-size: 10pt">${object[2]}</span></td>
            <td>
                <span style="font-size: 10pt">${object[3]}</span></td>
            <td>
                <input type="text" name=${object[4]}></span></td>
        </tr>
        </c:forEach>
    </table>

    <br><br>
    
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" name="act" value="Prev" onclick="javascript:history.back();">
        <input type="submit" name="act" value="Submit">
        <input type="submit" name="act" value="Logout">
    </form>

</body>
</html>
