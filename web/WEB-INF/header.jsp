<%-- 
    Document   : signIn
    Created on : 2015/12/20, 14:08:05
    Author     : Etude
--%>

<%@page import="lecfinal.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<span style="text-align:right">
    <form action="./SignOut" method="POST">
        <jsp:useBean id="account" class="Account" scope="session"/>
        <span style="margin-right:15px"><%=account.getAccountName()%>&nbsp;<span style="font-size:75%">さん</span></span>
        <span style="margin-right:15px"><a href="./TestItem">テスト項目編集ページ</a></span>
        <span style="margin-right:15px"><a href="./Index">Index</a></span>
        <!--<span style="margin-right:15px"><a href="./Product">製品編集ページ</a></span>-->
        <input type="submit" style="width:100px" value="サインアウト"/>
        <!--<button onclick="location.replace('./SignOut');return false;">サインアウト</button>-->
    </form>
    <hr size="3" color="#CCCCCC"/>
</span>
