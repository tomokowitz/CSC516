// Handling form data

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

public class ex1 extends HttpServlet 
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
    out.println("<head><title>ex1</title></head>");
    out.println("<body>");
    out.println("<TABLE BORDER=2>");
    out.println("<TR><TH>Parameter name</TH>" +
                "<TH>Parameter values</TH></TR>");
    try
    {
      Enumeration e = request.getParameterNames();
      while (e.hasMoreElements())
      {
        String paramName = (String)e.nextElement();
        out.println("<TR><TD>" + paramName + "</TD>");
        String[] paramValues = request.getParameterValues(paramName);
        if (paramValues.length == 1)
        {
          if (paramValues[0].length() == 0)
            out.println("<TD>No value</TD>");
          else
            out.println("<TD>" + paramValues[0] + "</TD>");
        }
        else
        {
          out.println("<TD><UL>");
          for (int i = 0; i < paramValues.length; i++)
          {
            out.println("<LI>" + paramValues[i] + "</LI>");
          }
          out.println("</UL></TD>");
        }
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