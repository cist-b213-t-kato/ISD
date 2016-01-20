<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

<%@page import="lecfinal.TestTypeDefinition"%>
<%@page import="lecfinal.Product"%>
<%@page import="lecfinal.TestItemBean"%>
<%@page import="lecfinal.TestItemModel"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="ja" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="Expires" content="Thu, 01 Jan 1970 00:00:00 GMT" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=480px, initial-scale=1.0">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
</head>
<body>
    <jsp:include page="./header.jsp"/>
    <%
        Product product = (Product)session.getAttribute("product");
    %>
    <label>製品 <%=product.getProductName()%> のテスト項目</label>
    <jsp:include page="./testItemTable.jsp"/>
    
    <a href="./TestItemAddition">テスト項目の追加</a><br/>
    <a href="./TestItemChange">テスト項目の変更</a><br/>
    <a href="./TestItemDelete">テスト項目の削除</a><br/>
    
</body>
</html>
