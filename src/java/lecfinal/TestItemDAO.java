/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.Connection;
import java.sql.Date;
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
public class TestItemDAO {
    
    public TestItemDAO() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    
    public List<TestItemBean> selectTestItemList() throws SQLException{
        
        String sql = "select * from test_item order by test_id asc";//"select * from account";
        List<TestItemBean> testItemList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    int id = results.getInt("test_id");
                    int pid = results.getInt("product_id");
                    String aid = results.getString("account_id");
                    String step = results.getString("test_step");
                    String eResult = results.getString("expected_result");
                    Date date = results.getDate("test_date");
                    TestItemBean tmp = new TestItemBean(id, pid, aid, 0, step, eResult, date, 0, "");
                    testItemList.add(tmp);
                }
                return testItemList;
            }
        }
    }
    
    
//    public int insertProduct(Product insertObject) throws SQLException{
//        String sql = "insert into product(product_id, product_name) values (?, ?)";
//        int returning = 0;
//        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
//            try(PreparedStatement stmt = conn.prepareStatement(sql)){
//                stmt.setInt(1, insertObject.getProductId());
//                stmt.setString(2, insertObject.getProductName());
//                returning = stmt.executeUpdate();
//            }
//        }
//        return returning;
//    }
    
    
}
