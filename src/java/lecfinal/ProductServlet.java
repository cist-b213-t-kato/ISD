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
@WebServlet(urlPatterns = {"/lecfinal/Product"})
public class ProductServlet extends AbstractSignedHttpServlet {
    @Override
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("utf-8");
        if("POST".equals(req.getMethod())){
            String idStr = req.getParameter("product_id");
            String name = req.getParameter("product_name");
            int id = Integer.parseInt(idStr);
            Product insertObject = new Product(id, name);
            ProductModel model = new ProductModel();
            model.submitProduct(insertObject);
        }

        HttpSession session = req.getSession();
        if(session.getAttribute("account")==null){
            resp.sendRedirect("./SignIn");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product.jsp");
        rd.forward(req, resp);
    }
    
}
