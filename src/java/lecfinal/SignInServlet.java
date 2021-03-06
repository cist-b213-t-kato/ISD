/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/lecfinal/SignIn"})
public class SignInServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if(null==account){
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signIn.jsp");
            rd.forward(req, resp);
        }else{
            //既にログインしている場合
            resp.sendRedirect("./Index");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
