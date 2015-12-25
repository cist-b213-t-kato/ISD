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
    
    @Deprecated
    public List<TestItemBean> selectTestItemList() throws SQLException{
        
        String sql = "select * from test_item order by test_id asc";//"select * from account";
        List<TestItemBean> testItemList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    int id = results.getInt("test_id");
                    int number = results.getInt("test_number");
                    int pid = results.getInt("product_id");
                    int type = results.getInt("test_type");
                    String aid = results.getString("account_id");
                    String step = results.getString("test_step");
                    String eResult = results.getString("expected_result");
                    int tResult = results.getInt("test_result");
                    Date date = results.getDate("test_date");
                    String remarks = results.getString("remarks");
                    TestItemBean tmp = new TestItemBean(id, number, pid, aid, type, step, eResult, date, tResult, remarks);
                    testItemList.add(tmp);
                }
                return testItemList;
            }
        }
    }
    
    public List<TestItemBean> selectTestItemListByProductId(int productId) throws SQLException{
        
        String sql = "select * from test_item where product_id = ? order by test_number asc";
        List<TestItemBean> testItemList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, productId);
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    int id = results.getInt("test_id");
                    int number = results.getInt("test_number");
                    int pid = results.getInt("product_id");
                    int type = results.getInt("test_type");
                    String aid = results.getString("account_id");
                    String step = results.getString("test_step");
                    String eResult = results.getString("expected_result");
                    int tResult = results.getInt("test_result");
                    Date date = results.getDate("test_date");
                    String remarks = results.getString("remarks");
                    TestItemBean tmp = new TestItemBean(id, number, pid, aid, type, step, eResult, date, tResult, remarks);
                    testItemList.add(tmp);
                }
                return testItemList;
            }
        }
    }
    
    public int updateTestItem(TestItemBean updateObject) throws SQLException{
        //TODO
        String sql = "UPDATE TEST_ITEM SET "
                + "TEST_NUMBER = ?, PRODUCT_ID = ?, ACCOUNT_ID = ?, "
                + "TEST_TYPE = ?, TEST_STEP = ?, EXPECTED_RESULT = ?, TEST_DATE = ?, TEST_RESULT = ?, REMARKS = ? "
                + "where test_number = ? and product_id = ?"; //11~

        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, updateObject.getTestNumber());
                stmt.setInt(2, updateObject.getProductId());
                stmt.setString(3, updateObject.getAccountId());
                stmt.setInt(4, updateObject.getTestType());
                stmt.setString(5, updateObject.getTestStep());
                stmt.setString(6, updateObject.getExpectedResult());
                stmt.setDate(7, updateObject.getTestDate());
                stmt.setInt(8, updateObject.getTestResult());
                stmt.setString(9, updateObject.getRemarks());
                stmt.setInt(10, updateObject.getTestNumber());
                stmt.setInt(11, updateObject.getProductId());
                return stmt.executeUpdate();
            }
        }
    }
    
    
    public int insertTestItem(TestItemBean insertObject) throws SQLException{
        String sql = "INSERT INTO TEST_ITEM (TEST_ID, TEST_NUMBER, PRODUCT_ID, ACCOUNT_ID,"
                + " TEST_TYPE, TEST_STEP, EXPECTED_RESULT, TEST_DATE, TEST_RESULT, REMARKS)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, getNextTestId());
                stmt.setInt(2, insertObject.getTestNumber());
                stmt.setInt(3, insertObject.getProductId());
                stmt.setString(4, insertObject.getAccountId());
                stmt.setInt(5, insertObject.getTestType());
                stmt.setString(6, insertObject.getTestStep());
                stmt.setString(7, insertObject.getExpectedResult());
                stmt.setDate(8, insertObject.getTestDate());
                stmt.setInt(9, insertObject.getTestResult());
                stmt.setString(10, insertObject.getRemarks());
                return stmt.executeUpdate();
            }
        }
    }
    
    private int getNextTestId() throws SQLException{
        String sql = "SELECT MAX(TEST_ID) FROM TEST_ITEM";
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                results.next();
                return results.getInt(1)+1;
            }
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        TestItemDAO dao = new TestItemDAO();
        System.out.println(dao.getNextTestId());
    }

    public int deleteTestItem(int testNumber, int productId) throws SQLException {
        String sql = "delete from test_item where test_number = ? and product_id = ?";
        
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, testNumber);
                stmt.setInt(2, productId);
                return stmt.executeUpdate();
            }
        }
    }
    
}
