<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

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
    <label>製品 <%=product.getProductName()%> のテスト項目を追加する</label>
    <table class="blueTable" width="500px">
        <tr>
            <th width="50px">番号</th>
            <th width="70px">種別</th>
            <th width="200px">実行ステップ</th>
            <th width="150px">期待される出力</th>
        </tr>
        <%
            TestItemModel model = new TestItemModel();
            int id = ((Product)session.getAttribute("product")).getProductId();
            for(TestItemBean testItem : model.getTestItemListByProductId(id) ){
        %>
        <tr>
            <td><%=testItem.getTestNumber()%></td>
            <td><%=testItem.getTestType()%></td>
            <td><%=testItem.getTestStep()%></td>
            <td><%=testItem.getExpectedResult()%></td>
        </tr>
        <%
            }
        %>
    </table>
    
    <form action="./TestItemEdit" method="POST">
    <table border="0" width="500px">
        <tr>
            <td align="right">テスト番号</td>
            <td><input name="testNumber" rows="1" style="width:50%" required/></td>
        </tr>
        <tr>
            <td align="right">種別</td>
            <td>
                <select name="testType">
                    <option value="1">正常系</option>
                    <option value="2">異常系</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">実行ステップ</td>
            <td><textarea name="testStep" rows="1" style="width:100%"/></textarea></td>
        </tr>
        <tr>
            <td align="right">期待される出力</td>
            <td><textarea name="expectedResult" rows="1" style="width:100%"></textarea></td>
        </tr>
    </table>
    <input style="width:80px; text-align:center;" type="submit" value="追加する"/>
    </form>
</body>
</html>
