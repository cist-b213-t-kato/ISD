/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/lec01/SubmitSprinter"})
public class SubmitSprinterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset = \"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"./RecordSessionSprinter\" method=\"POST\">");
        out.println("<div>ゼッケン番号：</div><div><input type=\"number\" name=\"zeichen\" min=\"0\"></div>");
        out.println("<div>氏：</div><div><input type=\"text\" name=\"familyName\"></div>");
        out.println("<div>名：</div><div><input type=\"text\" name=\"givenName\"></div>");
        out.println("<div>ベストタイム：</div><div><input type=\"number\" name=\"bestTime\" min=\"0\"></div>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
