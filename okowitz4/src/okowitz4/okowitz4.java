package okowitz4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class okowitz4 extends HttpServlet {
    @SuppressWarnings("compatibility:4957086901941085242")
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {
        Double type = 0.00;
        
        Double age = 0.00;
        
        try
            {
                   type = Double.parseDouble(request.getParameter("animalType"));
            age = Double.parseDouble(request.getParameter("age"));
        }
            catch(Exception e)
            {
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

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, 
                                                            IOException {
        
        Double type = 0.00;
                   type = Double.parseDouble(request.getParameter("animalType"));
        Double age = Double.parseDouble(request.getParameter("age"));
        Double manAge;
        String name = "";
        Integer intType = 0;
        intType = Integer.parseInt( request.getParameter("animalType"));
        switch(intType) {
            case 1 :
            name="human";
            break;
            case 7:
            name = "dog";
            break;
            case 100:
            name="fruit fly";
            break;
            default:
            name="unknown cryptozoological species(!)";
            break;
            
        }
        manAge = age * type;
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>okowitz4</title></head>");
        out.println("<body>");
        out.println("<p>The age of your animal is " + manAge.toString() + " " + name + " years.</p>");
        out.println("</body></html>");
        out.close();
    }
}
