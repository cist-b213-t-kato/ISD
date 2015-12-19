/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b2130480
 */
public class SelectDriverDAO {
    
    public static void main(String[] args) throws SQLException{
        String sql = "select * from student";
        List<Student> students = new ArrayList<>();
        
        try(Connection conn
                = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()){
                ResultSet results = stmt.executeQuery(sql);
                while(results.next()){
                    students.add(new Student(
                            results.getString("student_code"),
                            results.getString("family_name"),
                            results.getString("given_name"),
                            results.getString("school_name")));
                    
                }
            }
            students.forEach(System.out::println);
            
        }
        
    }
    
}
