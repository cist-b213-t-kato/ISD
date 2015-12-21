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
@WebServlet(urlPatterns = {"/lecfinal/SignOut"})
public class SignOutServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ClassNotFoundException, SQLException{
        HttpSession session = req.getSession();
        session.setAttribute("account", null);
        resp.sendRedirect("./SignIn");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
