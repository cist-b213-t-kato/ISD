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
            Calendar now = Calendar.getInstance();
            out.println("8月"+"16日"+"（水）");
        %>
    </p>
    
    <table id="testItemTable">
        <tr>
            <th>テスト番号</th>
            <th>種別</th>
            <th>実行ステップ</th>
            <th>期待される出力</th>
        </tr>
        <tr>
            <td>1</td>
            <td>正常系</td>
            <td></td>
            <td></td>
        </tr>
    </table>
    
    <!--<div style="text-align:center">-->
    <form>
    <table border="0">
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
            <td><input style="width:100px" type="text"/></td>
        </tr>
        <tr>
            <td align="right">期待される出力</td>
            <td><input style="width:100px" type="text"/></td>
        </tr>
    </table>
    <input style="width:80px" type="submit" value="追加する"/>
    </form>
    <!--</div>-->
    
    <a href="./testItemPage.jsp">ｺﾛｼｱｴｰ</a>
</body>
</html>
