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
    
    
    public List<Product> selectProducts() throws SQLException{
        
        String sql = "select * from product order by product_id asc";//"select * from account";
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
    
    
    public int insertProduct(Product insertObject) throws SQLException{
        String sql = "insert into product(product_id, product_name) values (?, ?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, insertObject.getProductId());
                stmt.setString(2, insertObject.getProductName());
                returning = stmt.executeUpdate();
            }
        }
        return returning;
    }
    
}
