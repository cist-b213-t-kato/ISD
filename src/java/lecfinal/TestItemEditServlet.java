/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
@WebServlet(urlPatterns = {"/lecfinal/TestItemEdit"})
public class TestItemEditServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/testItemEdit.jsp");
        rd.forward(req, resp);
    }
}