/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.SQLException;

/**
 *
 * @author Etude
 */
public class AccountModel {
    
    public int submitAccount(Account insertObject) throws ClassNotFoundException, SQLException{
        AccountDAO dao = new AccountDAO();
        return dao.insertAccount(insertObject);
    }
    
    public Account getAccount(String id, String pass) throws ClassNotFoundException, SQLException{
        AccountDAO dao = new AccountDAO();
        return dao.selectAccount(id, pass);
    }
    
}
