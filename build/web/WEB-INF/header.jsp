<%-- 
    Document   : signIn
    Created on : 2015/12/20, 14:08:05
    Author     : Etude
--%>

<%@page import="lecfinal.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
</head>
<body>
    <span style="text-align:right; background-color:#808080">
        <form action="./SignOut" method="POST">
            <jsp:useBean id="account" class="Account" scope="session"/>
            <span>
                ユーザー名: <%=account.getAccountName()%>
            </span>
            <input type="submit" style="width:100px" value="サインアウト"/>
        </form>
    </span>
</body>
</html>
