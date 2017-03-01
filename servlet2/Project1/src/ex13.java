import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ex13 extends HttpServlet {


   public void init( ServletConfig config )
      throws ServletException
   {
       super.init( config );
   }

   public void doPost( HttpServletRequest request,
                      HttpServletResponse response )
      throws ServletException, IOException
   {
      Integer roleCount = (Integer)request.getAttribute("studentRole");
      if (roleCount.equals(new Integer(1))) 
      {
          ServletContext context = getServletContext();
          RequestDispatcher dispatcher = context.getRequestDispatcher(
                                               "/ex11");
          dispatcher.forward(request, response);
      }
      else
      { 
        String input1 = request.getParameter( "username" ); 
        response.setContentType( "text/html" );  
        PrintWriter output = response.getWriter();           
        output.println( "<HTML><HEAD><TITLE>\n");
        output.println( "Add a Course\n" );
        output.println( "</TITLE></HEAD><BODY>\n" );
        output.println( input1 + " is not a student!");  
        output.println( "</BODY></HTML>" );
        output.close();    
      }
   }

} 