import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;

public class ex1 extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String my_user = "";
    double my_money = 0;
    try
    {
      my_user = request.getParameter("user");
      my_money = Double.valueOf(request.getParameter("money")).doubleValue();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>ex1</title></head>");
    out.println("<body>");
    out.println("<p>The servlet has received a GET. This is the reply.</p>");
    out.println("</body></html>");
    out.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String my_user = "";
    double my_money = 0;
    try
    {
      my_user = request.getParameter("user");
      my_money = Double.valueOf(request.getParameter("money")).doubleValue();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>ex1</title></head>");
    out.println("<body>");
    out.println("<p>The servlet has received a POST. This is the reply.</p>");
    out.println("</body></html>");
    out.close();
  }
}