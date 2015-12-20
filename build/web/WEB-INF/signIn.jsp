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
    <h1>Sign in</h1>
    <form action="./SignIn" method="POST">
    <div>
        <label>ユーザID</label>
        <div><input type="text" style="width:200px" required/></div>
    </div>
    <div>
        <label>パスワード</label>
        <div><input type="password" style="width:200px" required/></div>
    </div>
    <div style="margin: 20px auto;">
        <input type="submit" style="width:200px" value="ログイン"/>
    </div>
    </form>
</body>
</html>
