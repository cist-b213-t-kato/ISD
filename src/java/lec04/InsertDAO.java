/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author b2130480
 */
public class InsertDAO {
    
    public InsertDAO() throws ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void main(String[] args) throws SQLException{
        String sql = "insert into student"
                + " values ('b1970080', 'ボルボックス', '太郎', '札幌モエレ沼高校')";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("追加行数:"+returning);
    }
    
}
