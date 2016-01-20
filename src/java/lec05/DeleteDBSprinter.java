package lec05;

import lec01.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteDBSprinter")
public class DeleteDBSprinter extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<style type=\"text/css\">");
    out.println("table{border-collapse: collapse;} td, th { border: solid gray thin; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<H1>" + getClass().getSimpleName() + "</h1>");
    
    List<Sprinter> sprinters = new ArrayList<>();
    try {
        SprinterDAO sprinterdao = new SprinterDAO();
        sprinters = sprinterdao.selectSprinters();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(InputDBSprinter.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>ゼッケン番号</th>");
    out.println("<th>氏</th>");
    out.println("<th>名</th>");
    out.println("<th>ベストタイム</th>");
    out.println("</tr>");
    String tableBody = sprinters.stream()
            .map(item -> formatHtml(item))
            .collect(Collectors.joining());
    out.println(tableBody);
    out.println("<tr>");
    out.println("</table>");
    
    
    out.println("<form action=\"./DeleteDBSprinter\" method=\"POST\">");
    out.println("<div>ゼッケン番号：</div><div><input type=\"number\" name=\"zeichen\" min=\"0\"></div>");
    out.println("<input type=\"submit\">");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

    // パラメータからゼッケン番号、名字、名前、ベストタイムを取りだして、Sprinterオブジェクトを作成
    req.setCharacterEncoding("UTF-8");
    String zeichenParam = req.getParameter("zeichen");

    List<Sprinter> sprinters = new ArrayList<>();
    try {
        SprinterDAO sprinterdao = new SprinterDAO();
        sprinterdao.deleteSprinter(Integer.parseInt(zeichenParam));
        sprinters = sprinterdao.selectSprinters();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(InputDBSprinter.class.getName()).log(Level.SEVERE, null, ex);
    }


    // HTMLをレスポンスデータに書き込む
    // ただし、HTMLの表の中身は、Sprinterオブジェクトのリストから作成する
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset = \"UTF-8\">");
    out.println("<style type=\"text/css\">");
    out.println("table{border-collapse: collapse;} td, th { border: solid gray thin; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>データベースに記録しました</h1>");
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>ゼッケン番号</th>");
    out.println("<th>氏</th>");
    out.println("<th>名</th>");
    out.println("<th>ベストタイム</th>");
    out.println("</tr>");

    String tableBody = sprinters.stream()
            .map(item -> formatHtml(item))
            .collect(Collectors.joining());

    out.println(tableBody);

    out.println("<tr>");
    out.println("</table>");
    out.println("<a href=\"./DeleteDBSprinter\">戻る</a>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  public String formatHtml(Sprinter sprinter) {
    return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>\n",
            sprinter.getZeichen(),
            sprinter.getFamilyName(),
            sprinter.getGivenName(),
            sprinter.getBestTime());
  }

}