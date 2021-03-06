/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author b2130480
 */
@WebServlet(urlPatterns = {"/lecfinal/SignUp"})
public class SignUpServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("/WEB-INF/signUp.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String newUserId = req.getParameter("newUserId");
        String newPassphrase = req.getParameter("newPassphrase");
        String newAccountName = req.getParameter("newAccountName");
        
        //TODO サインアップ機能を完成させる
        try {
            AccountModel model = new AccountModel();
            Account account = new Account(newUserId, newPassphrase, newAccountName);
            model.submitAccount(account);
            
            HttpSession session = req.getSession();
            session.setAttribute("systemMessage", "<h1>アカウントが追加できました</h1>"
                    + "<a href=\"./SignIn\">サインインする</a>");

            RequestDispatcher rd;
            rd = req.getRequestDispatcher("/WEB-INF/systemMessage.jsp");
            rd.forward(req, resp);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            HttpSession session = req.getSession();
            session.setAttribute("systemMessage", "<p>アカウントが追加できませんでした</p>"
                    + "<a href=\"./SignIn\">サインインする</a>");

            RequestDispatcher rd;
            rd = req.getRequestDispatcher("/WEB-INF/systemMessage.jsp");
            rd.forward(req, resp);
        }
        
        
    }
    
}
