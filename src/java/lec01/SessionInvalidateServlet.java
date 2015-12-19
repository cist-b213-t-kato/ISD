/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author b2130480
 */
@WebServlet(urlPatterns = {"/lec01/SessionInvalidate"})
public class SessionInvalidateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        req.getSession().invalidate();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset = \"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>セッションを削除しました</p>");
        out.println("<a href=\"./SubmitSprinter\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
    }
    
}
