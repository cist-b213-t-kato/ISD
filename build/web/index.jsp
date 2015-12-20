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
    
    <span>製品Ａ テスト項目</span>
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
            <td><textarea name="step" cols="20" rows="1"/></textarea></td>
        </tr>
        <tr>
            <td align="right">期待される出力</td>
            <td><textarea name="expectedResult" cols="20" rows="1"></textarea></td>
        </tr>
    </table>
    <input style="width:80px" type="submit" value="追加する"/>
    </form>
    
    <a href="./testItemPage.jsp">ｺﾛｼｱｴｰ</a>
</body>
</html>
