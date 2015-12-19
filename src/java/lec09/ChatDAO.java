/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lec04.DBSetting;

/**
 *
 * @author b2130480
 */
class ChatDAO {
    
    public ChatDAO() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void main(String[] args) throws SQLException{
        try {
            new ChatDAO().insertMessage("こんにちワン！");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int insertMessage(String message) throws SQLException{
        String sql = "insert into"
                + " chat_messages(message)"
                + " values (?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, message);
                returning = stmt.executeUpdate();
            }
        }
        return returning;
    }
    
    public List<String> selectMessage() throws SQLException{
        String sql = "select * from chat_messages ";
        List<String> messages = new ArrayList<>();
        //スタブとするなら
//        messages.add("今日もイイ天気");
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    messages.add(results.getString("message"));
                }
            }
            return messages;
        }
    }
    
}
