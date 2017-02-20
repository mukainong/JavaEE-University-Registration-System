<%-- 
    Document   : thanks
    Created on : Feb 10, 2017, 7:05:59 AM
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
    <h1>Thanks for joining our email list</h1>

    <p>Here is your new account username:</p>

    <label>User ID:</label>

    <p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

    <form action="emailList" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

</body>
</html>