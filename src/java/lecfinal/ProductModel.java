/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Etude
 */
public class ProductModel {
    
    public int submitProduct(Product insertObject) throws ClassNotFoundException, SQLException{
        ProductDAO dao = new ProductDAO();
        return dao.insertProduct(insertObject);
    }
    
    public List<Product> getProducts() throws ClassNotFoundException, SQLException{
        ProductDAO dao = new ProductDAO();
        return dao.selectProducts();
    }
    
}
