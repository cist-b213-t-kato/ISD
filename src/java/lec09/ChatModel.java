/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec09;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author b2130480
 */
public class ChatModel {
    public int submitMessage(String newMessage) throws ClassNotFoundException, SQLException{
        ChatDAO dao = new ChatDAO();
        return dao.insertMessage(newMessage);
    }
    
    public List<String> getMessages() throws ClassNotFoundException, SQLException{
        ChatDAO dao = new ChatDAO();
        return dao.selectMessage();
    }
    
}
