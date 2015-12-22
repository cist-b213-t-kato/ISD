/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Etude
 */
@WebServlet(urlPatterns = {"/lecfinal/TestItem"})
public class TestItemServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        //リダイレクト
//        resp.sendRedirect("./Index");

//        resp.setHeader("Pragma", "no-cache");
//        resp.setHeader("Cache-Control", "no-cache");
//        resp.setDateHeader("Expires", 0);

        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/testItem.jsp");
        rd.forward(req, resp);
    }
    
}