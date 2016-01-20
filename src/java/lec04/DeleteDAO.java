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
public class DeleteDAO {

    
    public static void main(String[] args) throws SQLException{
        String sql = "delete from student where STUDENT_CODE = 'b1970040'";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("削除行数:"+returning);
    }
    
}
