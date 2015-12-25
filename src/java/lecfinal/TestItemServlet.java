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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

//        resp.setHeader("Pragma","no-cache");
//        resp.setHeader("Cache-Control","no-cache");
//        resp.setDateHeader("Expires",0);

        req.setCharacterEncoding("utf-8");
        if("POST".equals(req.getMethod())){
            int id = Integer.parseInt(req.getParameter("product_id"));
            ProductModel model = new ProductModel();
            Product product = model.getProduct(id);
            HttpSession session = req.getSession();
            session.setAttribute("product", product);
            resp.sendRedirect("./TestItemEdit");
            return;
        }

        HttpSession session = req.getSession();
        if(session.getAttribute("account")==null){
            resp.sendRedirect("./SignIn");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/testItem.jsp");
        rd.forward(req, resp);
    }
    
}
