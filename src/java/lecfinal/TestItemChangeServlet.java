/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
import java.sql.Date;
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
@WebServlet(urlPatterns = {"/lecfinal/TestItemChange"})
public class TestItemChangeServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("utf-8");
        if("POST".equals(req.getMethod())){
            int testType = Integer.parseInt(req.getParameter("testType"));
            int testNumber = Integer.parseInt(req.getParameter("testNumber"));
            String testStep = req.getParameter("testStep");
            String expectedResult = req.getParameter("expectedResult");
            HttpSession session = req.getSession();
            Account account = (Account)session.getAttribute("account");
            Product product = (Product)session.getAttribute("product");
            TestItemBean updateObject = new TestItemBean(
                    -1, testNumber, product.getProductId(), account.getAccountId(),
                    testType, testStep, expectedResult,
                    new Date(0), 0, ""
            );
            TestItemModel model = new TestItemModel();
            model.changeTestItem(updateObject);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/testItemChange.jsp");
        rd.forward(req, resp);
    }
    
}
