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
    
    public List<TestItemBean> getTestItemList(){
        try {
            TestItemDAO dao = new TestItemDAO();
            return dao.selectTestItemList();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
