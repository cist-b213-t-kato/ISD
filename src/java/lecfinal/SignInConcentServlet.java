/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/lecfinal/SignInConcent"})
public class SignInConcentServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ClassNotFoundException, SQLException{
        
        String id = req.getParameter("userId");
        String pass = req.getParameter("passphrase");
        
        AccountModel model = new AccountModel();
        
        Account account = model.getAccount(id, pass);
        
        if(null!=account){
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            session.setAttribute("account_name", account.getAccountName());
            resp.sendRedirect("./Index");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("systemMessage", "<p>サインインできませんでした</p>");
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/systemMessage.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignInConcentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignInConcentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
