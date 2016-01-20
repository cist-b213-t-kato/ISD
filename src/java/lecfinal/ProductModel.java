/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Etude
 */
public class ProductModel {
    
    public int submitProduct(Product insertObject){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.insertProduct(insertObject);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public List<Product> getProducts(){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.selectProducts();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Product getProduct(int id){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.selectProduct(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
