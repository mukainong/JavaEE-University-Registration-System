<%-- 
    Document   : studentInformation
    Created on : Feb 14, 2017, 12:25:22 PM
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
    <h1>Welcome, Student ID ${professor.ID}</h1>
    <h1>Welcome, Student password ${professor.password}</h1>

    <p>This is the table for the courses in which you enrolled.</p>
    <p>You can delete the ones which do not have a grade.</p>
    <p>And you can search new courses by click the "Search" button below.</p>
    <p>You may engage in at most 10 courses.</p>
    
    <table border="8" style="width:800px">
        <tr>
          <td style="width: 20%">
              <span style="font-size: 10pt">Course Code</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Course Name</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Department</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Professor</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Grade</span></td>
          <td style="width: 20%">
              <span style="font-size: 10pt">Oper</span></td>
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
                <span style="font-size: 10pt">${object[4]}</span></td>
            <td>
<!--                <input type=button value="View and Set Transcript"
                       onclick="javascript:window.open('professorCourseDetails.jsp?crscode=${course.crsCode}','_self');return;">-->
                <form action="emailList" method="post">
                    <input type="hidden" name="crscode" value=${course.crsCode}>  
                    <input type="submit" name="act" value="Delete">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

    <br><br>
    
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" name="act" value="Search Course">
        <input type="submit" name="act" value="Logout">
    </form>

</body>
</html>