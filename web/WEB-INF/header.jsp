<%-- 
    Document   : signIn
    Created on : 2015/12/20, 14:08:05
    Author     : Etude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
</head>
<body>
    <form action="./SignOut" method="POST">
    <jsp:useBean id="account_name" class="String" scope="session"/>
    <label>
        <%=account_name%>
    </label>
    <span style="margin: 20px auto;">
        <input type="submit" style="width:200px" value="サインアウト"/>
    </span>
    </form>
</body>
</html>
