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
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
</head>
<body>
    <jsp:include page="./header.jsp"/>
    <label>製品Ａ テスト項目</label>
    <table id="testItemTable" width="300px">
        <tr>
            <th width="50px">番号</th>
            <th width="200px">製品名</th>
        </tr>
        <tr>
            <td>101</td>
            <td>ZEUS</td>
        </tr>
        <tr>
            <td>102</td>
            <td>OFF_PARTY_ZERO</td>
        </tr>
    </table>
    
    <form method="POST">
    <table border="0" width="300px">
        <tr>
            <td style="width:100px" align="right">製品名</td>
            <td><input name="product_name" rows="1" style="width:100%"/></textarea></td>
        </tr>
    </table>
    <input style="width:80px; text-align:center;" type="submit" value="追加する"/>
    </form>
</body>
</html>
