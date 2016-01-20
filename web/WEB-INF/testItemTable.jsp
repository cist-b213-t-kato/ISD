
<%@page import="lecfinal.TestTypeDefinition"%>
<%@page import="lecfinal.TestResultDefinition"%>
<%@page import="lecfinal.Account"%>
<%@page import="lecfinal.AccountModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="lecfinal.TestItemBean"%>
<%@page import="lecfinal.Product"%>
<%@page import="lecfinal.TestItemModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="blueTable" width="800px">
        <tr>
            <th width="50px">番号</th>
            <th width="70px">種別</th>
            <th width="200px">実行ステップ</th>
            <th width="200px">期待される出力</th>
            <th width="100px">実施日</th>
            <th width="150px">実施担当者</th>
            <th width="70px">結果</th>
            <th width="200px">備考</th>
        </tr>
        <%
            TestItemModel model = new TestItemModel();
            int id = ((Product)session.getAttribute("product")).getProductId();
            for(TestItemBean testItem : model.getTestItemListByProductId(id) ){
                String dateStr = "-";
                Date date = testItem.getTestDate();
                if(date!=null){
                    DateFormat df = new SimpleDateFormat("MM月dd日");
                    dateStr = df.format(date);
                }
                
                AccountModel accountModel = new AccountModel();
                String accountName = "-";
                Account account = accountModel.getAccount(testItem.getAccountId());
                if(account!=null){
                     accountName = account.getAccountName();
                }
                
                String testResult = TestResultDefinition.toLabel(testItem.getTestResult());
        %>
            <tr>
                <td><%=testItem.getTestNumber()%></td>
                <td><%=TestTypeDefinition.toLabel(testItem.getTestType())%></td>
                <td><%=testItem.getTestStep()%></td>
                <td><%=testItem.getExpectedResult()%></td>
                <td><%=dateStr%></td>
                <td><%=accountName%></td>
                <td><%=testResult%></td>
                <td><%=testItem.getRemarks()%></td>
            </tr>
        <%
            }
        %>
    </table>