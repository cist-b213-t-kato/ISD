<%-- 
    Document   : newjsp
    Created on : 2015/12/19, 21:25:47
    Author     : Etude
--%>

<%@page import="lecfinal.TestItemAdditionServlet"%>
<%@page import="lecfinal.TestResultDefinition"%>
<%@page import="lecfinal.Account"%>
<%@page import="lecfinal.AccountModel"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
    <meta http-equiv="Expires" content="0" />
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
    <jsp:include page="./testItemTable.jsp"/>
    
    <form action="./TestItemAddition" method="POST">
    <table border="0" width="500px">
        <tr>
            <%
                TestItemModel testItemModel = new TestItemModel();
                int defValue = testItemModel.getNextTestItemNumberByProductId(product.getProductId());
            %>
            <td align="right">テスト番号</td>
            <td><input name="testNumber" type="number" rows="1" style="width:50%" value="<%=defValue%>" min="1" required/></td>
        </tr>
        <tr>
            <td align="right">種別</td>
            <td>
                <select name="testType">
                <%
                    for(TestTypeDefinition t : TestTypeDefinition.values()){
                %>
                    <option value="<%=t.getNum()%>"><%=t.getLabel()%></option>
                <%
                    }
                %>
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
        <tr>
            <td align="right">実施日</td>
            <td><input type="datetime" value="<%=new Date(System.currentTimeMillis())%>" name="date"></td>
        </tr>
        <tr>
            <td align="right">実施担当者</td>
            <td>
                <select name="accountId">
                    <option value="">なし</option>
                    <%
                        AccountModel accountModel = new AccountModel();
                        for(Account a : accountModel.getAccountList()){
                    %>
                        <option value="<%=a.getAccountId()%>"><%=a.getAccountName()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">
                結果
            </td>
            <td>
                <select name="testResult">
                    <%
                        for(TestResultDefinition t :TestResultDefinition.values()){
                    %>
                        <option value="<%=t.getNum()%>"><%=t.getLabel()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">備考</td>
            <td><textarea name="remarks" rows="1" style="width:100%"></textarea></td>
        </tr>
    </table>
    <input style="width:80px; text-align:center;" type="submit" value="追加する"/>
    </form>
    <div style="margin-top: 20px">
        <a href="./TestItemAddition">テスト項目の追加</a><br/>
        <a href="./TestItemChange">テスト項目の変更</a><br/>
        <a href="./TestItemDelete">テスト項目の削除</a><br/>
    </div>
</body>
</html>
