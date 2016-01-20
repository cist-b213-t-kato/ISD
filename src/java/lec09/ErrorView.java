/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec09;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author b2130480
 */
@WebServlet("/ErrorView")
public class ErrorView extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
        buildHTML(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
        buildHTML(req, resp);
    }

    private void buildHTML(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>error!</h1>");
        
        HttpSession session = req.getSession();
        String errorLog = (String)session.getAttribute("errorLog");
        
        if(errorLog != null){
            out.println("<p>" + errorLog + "</p>");
        }
        out.println("<p>ChatViewに移動してください</p>");
        
        out.println("<div><a href=\"./ChatView>ChatView</a></div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
}