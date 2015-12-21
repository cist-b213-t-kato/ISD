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
        
        String sql = "select * from account where account_id='"+id+"' and passphrase='"+pass+"'";//"select * from account";
        List<Account> accounts = new ArrayList<>();
        //スタブとするなら
//        accounts.add(new Account("","","ももも"));
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    String name = results.getString("account_name");
                    Account tmp = new Account(id,pass,name);
                    accounts.add(tmp);
                    return accounts.get(0);
                }
            }
        }
        return null;
    }
    
    public int insertAccount(Account insertObject) throws SQLException{
        String sql = "insert into account(account_id, passphrase, account_name) values (?, ?, ?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, insertObject.getUserid());
                stmt.setString(2, insertObject.getPassword());
                stmt.setString(3, insertObject.getAccountName());
                returning = stmt.executeUpdate();
            }
        }
        return returning;
    }
    
}
