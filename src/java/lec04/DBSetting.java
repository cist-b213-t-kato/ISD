package lec04;

/**
 *
 * @author b2130480
 */
public class DBSetting {
    public static final String URL = "jdbc:derby://localhost:1527/b2130480";
    public static final String USER = "b2130480";
    public static final String PASS = "b2130480";
    
    private DBSetting(){
        throw new AssertionError("インスタンス化してはいけない");
    }
    
}
