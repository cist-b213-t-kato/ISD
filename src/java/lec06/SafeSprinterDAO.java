package lec06;

import lec04.DBSetting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lec01.Sprinter;

public class SafeSprinterDAO {

    public SafeSprinterDAO() throws ClassNotFoundException {
        // Webアプリケーション（Tomcat）でDBを動作させるアプリケーションでは、ドライバのロードが必要
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        SafeSprinterDAO dao = new SafeSprinterDAO();
        Sprinter sprinter = new Sprinter(1,"ガワタスガル","ビゥ",1);
        dao.insertSprinter(sprinter);
        List<Sprinter> sprinters = dao.selectSprinters();
        sprinters.stream()
                .map(o->o.getGivenName())
                .forEach(System.out::println);
        
    }

    // データベースのsprinterテーブルにSprinterオブジェクトのレコードをinsertする
    public int insertSprinter(Sprinter insertObject) throws SQLException {
        String sql = "insert into sprinter values (?, ?, ?, ?)";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, insertObject.getZeichen());
                stmt.setString(2, insertObject.getFamilyName());
                stmt.setString(3, insertObject.getGivenName());
                stmt.setInt(4, insertObject.getBestTime());
                returning = stmt.executeUpdate();
            }
        }
        System.out.println("追加行数:"+returning);

        return returning;
    }

    // データベースのsprinterテーブルから全レコードをSprinterオブジェクトのListで取得する
    public List<Sprinter> selectSprinters() throws SQLException {
        
        //String sql = "select * from sprinter order by zeichen asc";
        String sql = "select * from sprinter";
        List<Sprinter> sprinters = new ArrayList<>();
        
        try(Connection conn
                = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet results = stmt.executeQuery();
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
        String sql = "delete from sprinter where zeichen = ?";
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, deleteZeichen);
                returning = pstmt.executeUpdate();
            }
        }
        System.out.println("削除行数:"+returning);
        return returning;
    }

    // データベースのsprinterテーブルで、ゼッケン番号を元にレコードの属性を更新する
    public int updateSprinter(Sprinter updateObject) throws SQLException {
        
        String sql = "update sprinter set"
                        + " ZEICHEN = ?"
                        + ",FAMILYNAME = ?"
                        + ",GIVENNAME = ?"
                        + ",BESTTIME = ?"
                        + " where zeichen = ?";
        
        int returning = 0;
        try(Connection conn = DriverManager.getConnection(DBSetting.URL, DBSetting.USER, DBSetting.PASS)){
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, updateObject.getZeichen());
                pstmt.setString(2, updateObject.getFamilyName());
                pstmt.setString(3, updateObject.getGivenName());
                pstmt.setInt(4, updateObject.getBestTime());
                pstmt.setInt(5, updateObject.getZeichen());
                
                returning = pstmt.executeUpdate();
            }
        }
        System.out.println("変更行数:"+returning);
        return returning;
    }

}
