/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author b2130480
 */
@WebServlet(urlPatterns = {"/lec01/RecordSessionSprinter"})
public class RecordSessionSprinter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset = \"UTF-8\">");
        out.println("</head>");
        out.println("<body>");

        HttpSession session = req.getSession();
        if (session.isNew()) {
            session.setAttribute("sprinters", new ArrayList<>());
        }
        List<Sprinter> sprinters = (List<Sprinter>) session.getAttribute("sprinters");

        sprinters.add(new Sprinter(
                Integer.parseInt(req.getParameter("zeichen")),
                req.getParameter("familyName"),
                req.getParameter("givenName"),
                Integer.parseInt(req.getParameter("bestTime"))
        ));

        Collections.sort(sprinters, (o1, o2) -> o1.getZeichen() - o2.getZeichen());

        out.println("<p>これまでSessionに記憶されたデータです</p>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>ゼッケン番号</th><th>氏</th><th>名</th><th>ベストタイム</th></tr>");

        String tableBody = sprinters.stream()
                .map(item -> "<tr>"
                        + "<td>" + item.getZeichen() + "</td>"
                        + "<td>" + item.getFamilyName() + "</td>"
                        + "<td>" + item.getGivenName() + "</td>"
                        + "<td>" + item.getBestTime() + "</td>"
                        + "</tr>")
                .collect(Collectors.joining());
        out.println(tableBody);
        out.println("</table>");
        out.println("<p><a href=\"./SubmitSprinter\">戻る</a></p>");
        out.println("<p><a href=\"./SessionInvalidate\">リストを削除する</a></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
