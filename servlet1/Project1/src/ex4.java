import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ex4 extends HttpServlet {

    PreparedStatement stmt;

   public void init( ServletConfig config )
      throws ServletException
   {
       super.init( config );
       String url = "jdbc:odbc:registrar";
       Connection con;
       String query = "select * from OFFERINGS where COURSE like ?;";
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
      String input1 = request.getParameter( "course" );
      PrintWriter output;
      response.setContentType( "text/html" );  
      output = response.getWriter();           
      output.println( "<HTML><HEAD><TITLE>\n");
      output.println( "Course Information\n" );
      output.println( "</TITLE></HEAD><BODY>\n" );

      try
      {
        stmt.setString(1, input1);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        int count = 0;
        boolean printed = false;
        while (rs.next())
        {
          if (! printed) 
          {
              output.println( "<TABLE BORDER=2><TR>\n" );
              for (int i = 1; i <= columns; i++) 
              {
               output.print("<TH>" + rsmd.getColumnLabel(i) + "</TH>");
              }
              output.println("</TR>");              
              printed = true;
          }
          output.println( "<TR>\n" );
          for (int i = 1; i <= columns; i++)
          {
            output.print("<TD>" + rs.getString(i) + "</TD>");
          }
          output.println("</TR>");
          count++; 
        }
       output.println( "</TABLE>\n" );
       if (count == 0)
         output.println("No such course");
       output.println( "</BODY></HTML>" );
       output.close();    // close PrintWriter stream
      }
      catch(SQLException ex)
      {
         System.err.println("SQLException: " + ex.getMessage());
      }
   }

} 