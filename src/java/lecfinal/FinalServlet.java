/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

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
@WebServlet(urlPatterns = {"/lecfinal/Final"})
public class FinalServlet extends HttpServlet{
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
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/isd2015/edit.css\"/>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>ン”ー！！</h1>");
        
        out.println("<table class=\"boxA\" id=\"testItemTable\">");
        out.println("<tr>");
        out.println("<th>きこえますか</th>");
        out.println("<th>愛する人よ</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>胸に響く</td>");
        out.println("<td>希望の歌声が</td>");
        out.println("</tr>");
        out.println("</table>");
        
        out.println("<form class=\"boxA\">");
        
        out.println("<div class=\"testItemInput\">");
        out.println("<div class=\"text\">");
        out.println("うは");
        out.println("</div>");
        out.println("<div class=\"textField\">");
        out.println("<input type=\"text\"/>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class=\"testItemInput\">");
        out.println("<div class=\"text\">");
        out.println("めたせこいあ");
        out.println("</div>");
        out.println("<div class=\"textField\">");
        out.println("<input type=\"text\"/>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div style=\"text-align:center\">");
        out.println("<input style=\"width:100px\"type=\"submit\" value=\"追加する\"/>");
        out.println("</div>");
        
        
        out.println("</form>");
        out.println("<a href=\"./SubmitSprinter\">戻る</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
    }
    
}
