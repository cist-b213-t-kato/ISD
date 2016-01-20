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
public class UpdateDAO {
    
    public UpdateDAO() throws ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void main(String[] args) throws SQLException{
        String sql = "update student set GIVEN_NAME = '次郎' where GIVEN_NAME = '太郎'";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("変更行数:"+returning);
    }
    
}
