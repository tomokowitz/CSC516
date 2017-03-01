import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class ex8 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, 
                                                            IOException {
        String input1 = request.getParameter( "college" );
        String newURL = "http://www." + input1.replaceAll(" ", "") + ".edu";
        response.sendRedirect(newURL);
    }
}
