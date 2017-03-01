// CGI variables

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

public class ex3 extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
  
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    String[][] variables =
      { { "AUTH_TYPE", request.getAuthType() },
        { "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
        { "CONTENT_TYPE", request.getContentType() },
        { "DOCUMENT_ROOT", getServletContext().getRealPath("/") },
        { "PATH_INFO", request.getPathInfo() },
        { "PATH_TRANSLATED", request.getPathTranslated() },
        { "QUERY_STRING", request.getQueryString() },
        { "REMOTE_ADDR", request.getRemoteAddr() },
        { "REMOTE_HOST", request.getRemoteHost() },
        { "REMOTE_USER", request.getRemoteUser() },
        { "REQUEST_METHOD", request.getMethod() },
        { "SCRIPT_NAME", request.getServletPath() },
        { "SERVER_NAME", request.getServerName() },
        { "SERVER_PORT", String.valueOf(request.getServerPort()) },
        { "SERVER_PROTOCOL", request.getProtocol() },
        { "SERVER_SOFTWARE", getServletContext().getServerInfo() }
      };
    out.println("<html>");
    out.println("<head><title>ex8</title></head>");
    out.println("<body>");
    out.println("<TABLE BORDER=2>");
    out.println("<TR><TH>CGI variable name</TH>" +
                "<TH>Value</TH></TR>");
    for (int i = 0; i < variables.length; i++)
    {
        out.println("<TR><TD>" + variables[i][0] + "</TD>");
        if (variables[i][1] == null)
          out.println("<TD>No Value</TD>");
        else
          out.println("<TD>"+ variables[i][1] + "</TD>");          
        out.println("</TR>");
    }
    out.println("</TABLE>");
    out.println("</body></html>");
    out.close();
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
}