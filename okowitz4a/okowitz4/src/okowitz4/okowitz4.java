package okowitz4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class okowitz4 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**Process the HTTP doGet request.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String VarOne = "";
        String VarTwo = "";
        try {
            VarOne = request.getParameter("paramOne");
            VarTwo = request.getParameter("paramTwo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>okowitz4</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }

    /**Process the HTTP doPost request.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String VarOne = "";
        String VarTwo = "";
        try {
            VarOne = request.getParameter("paramOne");
            VarTwo = request.getParameter("paramTwo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>okowitz4</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }
}
