<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/edit.css"/>
</head>
<body>
    <h3>やったぜ。</h3>
    <p>投稿者: 変態JSP親父  
        <%
            out.println("8月"+"16日"+"（水）");
        %>
    </p>
    <table class="boxA" id="testItemTable">
        <tr>
            <th>メーデー</th>
            <th>メーデー</th>
        </tr>
        <tr>
            <td>時は</td>
            <td>来たり</td>
        </tr>
    </table>
    <a href="./index.jsp">見える見える</a>
</body>
</html>
