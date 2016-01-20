/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec09;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author b2130480
 */
@WebServlet("/ChatView")
public class ChatView extends HttpServlet {
    
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
        out.println("<h1>chat</h1>");
        
        HttpSession session = req.getSession();
        List<String> messages = (List<String>)session.getAttribute("messages");
        
        if(messages == null || messages.isEmpty()){
            out.println("<p>コメントを送信してください。</p>");
        }else{
            messages.stream()
                    .map(message -> "<p>" + message + "</p>")
                    .forEach(out::println);
        }
        
        out.println("<form action=\"./ChatController\" method=\"POST\">");
        out.println("<div>コメント：<input type=\"text\" name=\"newMessage\"></div>");
        out.println("<input type=\"hidden\" name=\"token\" value=\""+ session.getId() + "\">");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
}