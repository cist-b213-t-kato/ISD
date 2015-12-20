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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Etude
 */
@WebServlet(name = "HttpServletEx", urlPatterns = {"/HttpServletEx"})
public abstract class AbstractSignedHttpServlet extends HttpServlet {

    /**
     * doPostまたはdoGetが呼ばれるときの処理を記述する
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected abstract void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * HttpServletExを継承するものは、自動的にサインインのページへ移動させる
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        AccountBean account = (AccountBean) session.getAttribute("account");
//        RequestDispatcher rd;
//        if(null==account){
//            rd = request.getRequestDispatcher("/WEB-INF/signIn.jsp");
//            rd.forward(request, response);            
//        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        AccountBean account = (AccountBean) session.getAttribute("account");
//        RequestDispatcher rd;
//        if(null==account){
//            rd = req.getRequestDispatcher("/WEB-INF/signIn.jsp");
//            rd.forward(req, resp);
//        }
//        
//        req.getParameter("");
        
        processRequest(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}