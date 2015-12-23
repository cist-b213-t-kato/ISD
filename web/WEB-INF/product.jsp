<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

<%@page import="lecfinal.ProductModel"%>
<%@page import="lecfinal.Product"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
    <style>
        .scrollable{
            display: block;
            max-width: 100%;
            overflow-x: auto;
            table-layout: fixed;
            height: 300px;
        }
        th, td {
          white-space: nowrap;
        }
    </style>
</head>
<body>
    <jsp:include page="./header.jsp"/>
    <label>製品一覧</label>
    <table class="blueTable scrollable" style="width:300px;">
        <tr>
            <th width="50px">番号</th>
            <th width="200px">製品名</th>
        </tr>
        <%
            ProductModel model = new ProductModel();
            for(Product product : model.getProducts()){
        %>
            <tr>
                <td><%=product.getProductId()%></td>
                <td><%=product.getProductName()%></td>
            </tr>
        <%
            }
        %>
    </table>
    
    <form action="./Product" method="POST">
    <table border="0" width="300px">
        <tr>
            <td style="width:100px" align="right">製品番号</td>
            <td><input name="product_id" rows="1" style="width:100%"/></textarea></td>
        </tr>
        <tr>
            <td style="width:100px" align="right">製品名</td>
            <td><input name="product_name" rows="1" style="width:100%"/></textarea></td>
        </tr>
    </table>
    <input style="width:80px; text-align:center;" type="submit" value="追加する"/>
    </form>
</body>
</html>
