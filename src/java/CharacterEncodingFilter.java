/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Etude
 */
public class CharacterEncodingFilter implements Filter {

  protected String encoding;

  public void init(FilterConfig config) throws ServletException {

    encoding = config.getInitParameter("encoding");
    if (encoding == null || encoding.length() == 0) {
      encoding = "8859_1";
    }

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    request.setCharacterEncoding(encoding);

  }

  public void destroy() {}

}
