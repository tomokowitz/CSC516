import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex9 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, 
                                                            IOException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/ex8");
        dispatcher.forward(request, response);
    }
}
