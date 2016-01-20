<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

<<<<<<< HEAD
<%@page import="lecfinal.ProductModel"%>
<%@page import="lecfinal.Product"%>
=======
>>>>>>> origin/master
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
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
    <label>テスト項目を編集する製品を選択してください</label>
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
    
    <form action="./TestItem" method="POST">
    <table border="0" width="300px">
        <tr>
            <td style="width:100px" align="right">製品名</td>
            <td>
                <select name="product_id" required>
                <%
                    for(Product product : model.getProducts()){
                %>
                <option value="<%=product.getProductId()%>"><%=product.getProductName()%></option>
                <%
                    }
                %>
                </select>
            </td>
        </tr>
    </table>
    <input style="width:150px; text-align:center;" type="submit" value="編集ページへ"/>
=======
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/isd2015/default.css"/>
</head>
<body>
    <jsp:include page="./header.jsp"/>
    <label>製品Ａ テスト項目</label>
    <table id="testItemTable" width="500px">
        <tr>
            <th width="50px">番号</th>
            <th width="70px">種別</th>
            <th width="200px">実行ステップ</th>
            <th width="150px">期待される出力</th>
        </tr>
        <tr>
            <td>1</td>
            <td>正常系</td>
            <td>1.「出席を提出する」ボタンをクリックする</td>
            <td>入力フォームが表示される</td>
        </tr>
        <tr>
            <td>2</td>
            <td>正常系</td>
            <td>2.表示されたフォームにパスワード（1234）を入力し、「送信」ボタンを押す</td>
            <td></td>
        </tr>
        <tr>
            <td>5</td>
            <td>異常系</td>
            <td>1.「出席を提出する」 ボタンをクリックする</td>
            <td>入力フォームが表示される</td>
        </tr>
    </table>
    
    <form method="POST">
    <table border="0" width="500px">
        <tr>
            <td align="right">種別</td>
            <td>
                <select name="種別">
                    <option value="1">正常系</option>
                    <option value="2">異常系</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">実行ステップ</td>
            <td><textarea name="step" rows="1" style="width:100%"/></textarea></td>
        </tr>
        <tr>
            <td align="right">期待される出力</td>
            <td><textarea name="expectedResult" rows="1" style="width:100%"></textarea></td>
        </tr>
    </table>
    <input style="width:80px; text-align:center;" type="submit" value="追加する"/>
>>>>>>> origin/master
    </form>
</body>
</html>
