/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Etude
 */
@WebServlet(urlPatterns = {"/lecfinal/TestItemAddition"})
public class TestItemAdditionServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("utf-8");
        if("POST".equals(req.getMethod())){
            try {
                int testType = Integer.parseInt(req.getParameter("testType"));
                int testNumber = Integer.parseInt(req.getParameter("testNumber"));
                String testStep = req.getParameter("testStep");
                String expectedResult = req.getParameter("expectedResult");
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date date = null;
                try{
                    date = new java.sql.Date(sdf.parse(req.getParameter("date")).getTime());
                }catch(ParseException ex2){
                    Logger.getLogger(TestItemAdditionServlet.class.getName()).log(Level.SEVERE, null, ex2);
                }
                HttpSession session = req.getSession();
                String accountId = null;
                AccountModel accountModel = new AccountModel();
                Account account = accountModel.getAccount(req.getParameter("accountId"));
                //TODO この設計はいかんでしょ
                if(account!=null){
                    accountId = account.getAccountId();
                }
                int resultNum = Integer.parseInt(req.getParameter("testResult"));
                String remarks = req.getParameter("remarks");
                Product product = (Product)session.getAttribute("product");
                TestItemBean insertObject = new TestItemBean(
                        -1, testNumber, product.getProductId(), accountId,
                        testType, testStep, expectedResult,
                        date, resultNum, remarks
                );
                TestItemModel model = new TestItemModel();
                model.submitTestItem(insertObject);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(TestItemAdditionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/testItemAddition.jsp");
        rd.forward(req, resp);
    }
    
}
