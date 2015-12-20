/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

/**
 *
 * @author Etude
 */
public class Account {

    private String userId;
    private String passphrase;
    private String userName;

    public Account(String userId, String passphrase, String userName) {
        this.userId = userId;
        this.passphrase = passphrase;
        this.userName = userName;
    }

    public String getUserid() {
        return userId;
    }

    public String getPassword() {
        return passphrase;
    }

    public void setUserid(String id) {
        userId = id;
    }

    public void setPassword(String pw) {
        passphrase = pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
