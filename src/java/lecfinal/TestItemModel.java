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
public class TestItemModel {
    
    public List<TestItemBean> getTestItemListByProductId(int productId){
        try {
            TestItemDAO dao = new TestItemDAO();
            return dao.selectTestItemListByProductId(productId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int submitTestItem(TestItemBean insertObject){
        try {
            TestItemDAO dao = new TestItemDAO();
            return dao.insertTestItem(insertObject);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestItemModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
