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
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {
        String AnimalType = "";
        int AnimalAge;
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
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, 
                                                            IOException {
        Double type = 0.00;
                           type = Double.parseDouble(request.getParameter("animalType"));
                Double age = Double.parseDouble(request.getParameter("age"));
                Double manAge;
                manAge = age * type;
                response.setContentType(CONTENT_TYPE);
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>okowitz4</title></head>");
                out.println("<body>");
                out.println("<p>The age of your animal is " + manAge.toString() + ".</p>");
                out.println("</body></html>");
                out.close();
    }
}
