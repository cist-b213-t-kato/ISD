/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Etude
 */
public class AccountDAO {
    
    public AccountDAO() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public Account selectAccount(String id, String pass) throws SQLException{
        
        String sql = "select * from account where account_id = ? and passphrase = ?";
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, id);
                stmt.setString(2, pass);
                ResultSet results = stmt.executeQuery();
                if(results.next()){
                    String name = results.getString("account_name");
                    return new Account(id,pass,name);
                }
            }
        }
        return null;
    }
    
    public Account selectAccount(String id) throws SQLException{
        String sql = "select * from account where account_id = ?";
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, id);
                ResultSet results = stmt.executeQuery();
                if(results.next()){
                    String name = results.getString("account_name");
                    String pass = results.getString("passphrase");
                    return new Account(id,pass,name);
                }
            }
        }
        return null;
    }
    
    public List<Account> selectAccountList() throws SQLException{
        String sql = "select * from account order by account_id asc";
        List<Account> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    String id = results.getString("account_id");
                    String pass = results.getString("passphrase");
                    String name = results.getString("account_name");
                    list.add(new Account(id,pass,name));
                }
                return list;
            }
        }
    }
    
    public int insertAccount(Account insertObject) throws SQLException{
        String sql = "insert into account(account_id, passphrase, account_name) values (?, ?, ?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, insertObject.getAccountId());
                stmt.setString(2, insertObject.getPassword());
                stmt.setString(3, insertObject.getAccountName());
                returning = stmt.executeUpdate();
            }
        }
        return returning;
    }
    
}
