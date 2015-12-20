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
public class AccountBean {
    private String userId = "";
    private String password = "";
    public AccountBean(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public String getUserid() { return userId; }
    public String getPassword() { return password; }
    public void setUserid(String id) { userId = id; }
    public void setPassword(String pw) { password = pw; }
}
