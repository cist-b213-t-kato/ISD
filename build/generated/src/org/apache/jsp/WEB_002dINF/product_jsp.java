package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/isd2015/default.css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header.jsp", out, false);
      out.write("\n");
      out.write("    <label>製品Ａ テスト項目</label>\n");
      out.write("    <table id=\"testItemTable\" width=\"300px\">\n");
      out.write("        <tr>\n");
      out.write("            <th width=\"50px\">番号</th>\n");
      out.write("            <th width=\"200px\">製品名</th>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>101</td>\n");
      out.write("            <td>ZEUS</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>102</td>\n");
      out.write("            <td>OFF_PARTY_ZERO</td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    <form method=\"POST\">\n");
      out.write("    <table border=\"0\" width=\"300px\">\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"right\">製品名</td>\n");
      out.write("            <td><input name=\"product_name\" rows=\"1\" style=\"width:100%\"/></textarea></td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    <input style=\"width:80px; text-align:center;\" type=\"submit\" value=\"追加する\"/>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
