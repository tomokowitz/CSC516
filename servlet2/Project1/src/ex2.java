// Request headers

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

public class ex2 extends HttpServlet 
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
    out.println("<html>");
    out.println("<head><title>ex2</title></head>");
    out.println("<body>");
    out.println("<P>Request Method: " + request.getMethod());
    out.println("<P>Request URI: " + request.getRequestURI());
    out.println("<P>Request Protocal: " + request.getProtocol());
    out.println("<P>");    
    out.println("<TABLE BORDER=2>");
    out.println("<TR><TH>Header name</TH>" +
                "<TH>Header value</TH></TR>");
    try
    {
      Enumeration e = request.getHeaderNames();
      while (e.hasMoreElements())
      {
        String headerName = (String)e.nextElement();
        out.println("<TR><TD>" + headerName + "</TD>");
        out.println("<TD>" + request.getHeader(headerName) 
                    + "</TD>");
        out.println("</TR>");
      }
      out.println("</TABLE>");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    out.println("</body></html>");
    out.close();
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
}