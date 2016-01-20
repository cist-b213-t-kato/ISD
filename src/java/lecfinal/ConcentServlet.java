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
<<<<<<< HEAD
 *
=======
 * 直リンしたときにSignInにdispatchしてるみたい？
>>>>>>> master
 * @author Etude
 */
@WebServlet(urlPatterns = {"/lecfinal/Concent"})
public class ConcentServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        if(session.getAttribute("account")!=null){
            session.setAttribute("account", null);
        }
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("/WEB-INF/concent.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
    
}
