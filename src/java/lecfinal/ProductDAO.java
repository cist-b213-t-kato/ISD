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
public class ProductDAO {
    
    public ProductDAO() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    
    public List<Product> selectAccount() throws SQLException{
        
        String sql = "select * from product";//"select * from account";
        List<Product> products = new ArrayList<>();
        //スタブとするなら
//        accounts.add(new Account("","","ももも"));
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
                while(results.next()){
                    int id = results.getInt("product_id");
                    String name = results.getString("product_name");
                    Product tmp = new Product(id, name);
                    products.add(tmp);
                }
                return products;
            }
        }
    }
    
    
    public int insertProduct(Account insertObject) throws SQLException{
        String sql = "insert into product(product_id, product_name) values (?, ?)";
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
