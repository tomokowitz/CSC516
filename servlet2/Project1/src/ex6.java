import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ex6 extends HttpServlet {

    PreparedStatement stmt;

   public void init( ServletConfig config )
      throws ServletException
   {
       super.init( config );
       String url = "jdbc:odbc:registrar";
       Connection con;
       String query = "select CRN, SECTION, DATES, TIMES, INSTRUCTOR, ROOM " +
                       "from OFFERINGS where COURSE like ?;";
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
      output.println( "Add a Course\n" );
      output.println( "</TITLE></HEAD><BODY>\n" );

      try
      {
        output.println("<FORM ACTION=\"ex7\" METHOD=\"POST\">");
        output.println("<TABLE BORDER='1'>");
        output.println("<TR>");
        output.println("<TH>Choice</TH>");
        output.println("<TH>CRN</TH>");
        output.println("<TH>Section</TH>");
        output.println("<TH>Date</TH>");
        output.println("<TH>Time</TH>");
        output.println("<TH>Instructor</TH>");
        output.println("<TH>Room</TH>");
        output.println("</TR>");
        stmt.setString(1, input1);
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {
           String crn = rs.getString("CRN");
           String section = rs.getString("SECTION");
           String date = rs.getString("DATES");
           String time = rs.getString("TIMES");
           String instructor = rs.getString("INSTRUCTOR");
           String room = rs.getString("ROOM");
           output.println("<TR>");
           output.println("<TD><input type='radio' name='crn' value='" +
                          crn + "'></TD>");
           output.println("<TD>" + crn + "</TD>");
           output.println("<TD>" + section + "</TD>");     
           output.println("<TD>" + date + "</TD>");
           output.println("<TD>" + time + "</TD>");   
           output.println("<TD>" + instructor + "</TD>");
           output.println("<TD>" + room + "</TD>");   
           output.println("</TR>");
        }
        output.println("</TABLE>");
        output.println("<input type = submit value=\"Submit\">");
        output.println("</FORM>");
        output.println( "</BODY></HTML>" );
        output.close();    
      }
      catch(SQLException ex)
      {
         System.err.println("SQLException: " + ex.getMessage());
      }
   }

} 