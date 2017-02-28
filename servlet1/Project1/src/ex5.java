import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ex5 extends HttpServlet {

    PreparedStatement stmt;

   public void init( ServletConfig config )
      throws ServletException
   {
       super.init( config );
       String url = "jdbc:odbc:registrar";
       Connection con;
       String query = "select COUNT(*) as MATCHES from USERS where USERID like ? " +
                      " and PASSWORD like ?;";
       try
       {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
       catch(java.lang.ClassNotFoundException e)
       {
        System.err.print("ClassNotFoundException: ");
        System.err.println(e.getMessage());
       }
       try
       {
           con = DriverManager.getConnection(url, "", "");
           stmt = con.prepareStatement(query);
       }
       catch(SQLException ex)
       {
          System.err.println("SQLException: " + ex.getMessage());
       }
   }

   public void doPost( HttpServletRequest request,
                      HttpServletResponse response )
      throws ServletException, IOException
   {
      String input1 = request.getParameter( "username" );
      String input2 = request.getParameter( "password" );
      PrintWriter output;
      response.setContentType( "text/html" );  
      output = response.getWriter();           
      output.println( "<HTML><HEAD><TITLE>\n");
      output.println( "Add a Course\n" );
      output.println( "</TITLE></HEAD><BODY>\n" );

      try
      {
        stmt.setString(1, input1);
        stmt.setString(2, input2);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int match_count = rs.getInt("MATCHES");
        if (match_count == 1)
          output.println("This is an OK username and password");
        else if (match_count == 0)
          output.println("Not a legal username/password");
        else
          output.println("Too many matches!");        
        output.println( "</BODY></HTML>" );
        output.close();    
      }
      catch(SQLException ex)
      {
         System.err.println("SQLException: " + ex.getMessage());
      }
   }

} 