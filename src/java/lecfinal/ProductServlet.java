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

/**
 *
 * @author Etude
 */
@WebServlet(urlPatterns = {"/lecfinal/Product"})
public class ProductServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        //リダイレクト
//        resp.sendRedirect("./Index");
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product.jsp");
        rd.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //TODO DB追加
        try {
            String idStr = req.getParameter("product_id");
            String name = req.getParameter("product_name");
            int id = Integer.parseInt(idStr);
            Product insertObject = new Product(id, name);
            ProductModel model = new ProductModel();
            model.submitProduct(insertObject);
            processRequest(req, resp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
