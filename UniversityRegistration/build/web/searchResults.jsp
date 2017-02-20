<%-- 
    Document   : searchResults
    Created on : Feb 14, 2017, 1:59:27 PM
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
    <h1>Searched results:</h1>
    
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
              <span style="font-size: 10pt">Oper</span></td>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach items="${courseList}" var="course">
        <tr>
            <td>
                <span style="font-size: 10pt">${course.crsCode}</span></td>
            <td>
                <span style="font-size: 10pt">${course.crsName}</span></td>
            <td>
                <span style="font-size: 10pt">${course.deptID}</span></td>
            <td>
                <span style="font-size: 10pt">${course.insNo}</span></td>
            <td>
<!--                <input type=button value="View and Set Transcript"
                       onclick="javascript:window.open('professorCourseDetails.jsp?crscode=${course.crsCode}','_self');return;">-->
                <form action="emailList" method="post">
                    <input type="hidden" name="crscode" value=${course.crsCode}>  
                    <input type="submit" name="act" value="Select">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

    <br><br>
    
    <form action="emailList" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" name="act" value="Prev" onclick="javascript:history.back();">
        <input type="submit" name="act" value="Logout">
    </form>

</body>
</html>
