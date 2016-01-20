/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec09;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author b2130480
 */
@WebServlet("/ChatController")
public class ChatController extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException, ServletException{  
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        String token = req.getParameter("token");
        
        if(!session.getId().equals(token)){
            session.setAttribute("messages", null);
            session.setAttribute("errorLog", "正式なフォームから送信されていません.");
            RequestDispatcher errorView = req.getRequestDispatcher("./ErrorView");
            errorView.forward(req, resp);
            return;
        }
        
        String newMessage = req.getParameter("newMessage");
        
        if(newMessage == null || newMessage.equals("") || newMessage.length()>140){
            session.setAttribute("messages", null);
            session.setAttribute("errorLog", "登録できないメッセージです.");
            RequestDispatcher errorView = req.getRequestDispatcher("./ErrorView");
            errorView.forward(req, resp);
            return;
        }
        
        ChatModel chatModel = new ChatModel();
        List<String> messages = null;
        try{
            chatModel.submitMessage(newMessage);
            messages = chatModel.getMessages();
        } catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        if(messages == null){
            session.setAttribute("messages", null);
            session.setAttribute("errorLog", "データベースにアクセスできません.");
            RequestDispatcher errorView = req.getRequestDispatcher("./ErrorView");
            errorView.forward(req, resp);
            return;
        }else{
            session.setAttribute("messages", messages);
            session.setAttribute("errorLog", null);
            RequestDispatcher dispatcher = req.getRequestDispatcher("./ChatView");
            dispatcher.forward(req, resp);
            return;
        }
        
    }
    
}