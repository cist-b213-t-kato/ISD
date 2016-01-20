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

    private String accountId;
    private String passphrase;
    private String accountName;

    public Account(String userId, String passphrase, String userName) {
        this.accountId = userId;
        this.passphrase = passphrase;
        this.accountName = userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return passphrase;
    }

    public void setAccountId(String id) {
        accountId = id;
    }

    public void setPassword(String pw) {
        passphrase = pw;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String userName) {
        this.accountName = userName;
    }
}
