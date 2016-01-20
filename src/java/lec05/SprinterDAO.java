package lec05;

import lec04.DBSetting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lec01.Sprinter;

public class SprinterDAO {

    public SprinterDAO() throws ClassNotFoundException {
        // Webアプリケーション（Tomcat）でDBを動作させるアプリケーションでは、ドライバのロードが必要
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void main(String[] args) throws SQLException{
        
        try {
            SprinterDAO dao = new SprinterDAO();
            Sprinter sprinter = new Sprinter(1,"1","1",1);
//            dao.insertSprinter(sprinter);
//            dao.deleteSprinter(2);
            dao.updateSprinter(sprinter);
            List<Sprinter> sprinters = dao.selectSprinters();
            sprinters.stream().forEach(System.out::println);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SprinterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // データベースのsprinterテーブルにSprinterオブジェクトのレコードをinsertする
    public int insertSprinter(Sprinter insertObject) throws SQLException {
        String sql = "insert into sprinter"
                + " values ("
                + insertObject.getZeichen() + ","
                + "'" + insertObject.getFamilyName() + "'" + ","
                + "'" + insertObject.getGivenName() + "'" + ","
                + insertObject.getBestTime()
                + ")";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("追加行数:"+returning);

        return returning;
    }

    // データベースのsprinterテーブルから全レコードをSprinterオブジェクトのListで取得する
    public List<Sprinter> selectSprinters() throws SQLException {
        
        String sql = "select * from sprinter order by zeichen asc";
        List<Sprinter> sprinters = new ArrayList<>();
        
        try(Connection conn
                = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()){
                ResultSet results = stmt.executeQuery(sql);
                while(results.next()){
                    sprinters.add(new Sprinter(
                            results.getInt("zeichen"),
                            results.getString("familyname"),
                            results.getString("givenname"),
                            results.getInt("besttime"))
                    );
                    
                }
            }
        }

        return sprinters;
    }

    // データベースのsprinterテーブルから、ゼッケン番号のレコードを削除する
    public int deleteSprinter(int deleteZeichen) throws SQLException {
        String sql = "delete from sprinter where zeichen = "+ deleteZeichen +"";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("削除行数:"+returning);
        return 0;
    }

    // データベースのsprinterテーブルで、ゼッケン番号を元にレコードの属性を更新する
    public int updateSprinter(Sprinter updateObject) throws SQLException {
        String sql = String.format(
                "update sprinter set "
                        + "ZEICHEN = %d,"
                        + "FAMILYNAME = '%s',"
                        + "GIVENNAME = '%s',"
                        + "BESTTIME = %d "
                        + "where zeichen = %s",
                updateObject.getZeichen(),
                updateObject.getFamilyName(),
                updateObject.getGivenName(),
                updateObject.getBestTime(),
                updateObject.getZeichen()
        );
        
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(Statement stmt = conn.createStatement()) {
                returning = stmt.executeUpdate(sql);
            }
        }
        System.out.println("変更行数:"+returning);
        return 0;
    }

}
