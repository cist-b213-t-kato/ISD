/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Etude
 */
public class DAO {
    
    public DAO() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public int insertAccount(Account insertObject) throws SQLException{
        String sql = "insert into account(user_id, passphrase, account_name) values (?, ?, ?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, insertObject.getUserid());
                stmt.setString(2, insertObject.getPassword());
                stmt.setString(3, insertObject.getUserName());
                returning = stmt.executeUpdate();
            }
        }
        return returning;
    }
    
}
