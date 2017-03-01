import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.GregorianCalendar;

public class ex7 extends HttpServlet {

    Statement stmt;

   public void init( ServletConfig config )
      throws ServletException
   {
       super.init( config );
       String url = "jdbc:odbc:registrar";
       Connection con;
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
           stmt = con.createStatement();
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
      String input1 = request.getParameter( "crn" );
      HttpSession session = request.getSession(true);
      String input2 = (String)session.getAttribute("username");
      PrintWriter output;
      response.setContentType( "text/html" );  
      output = response.getWriter();           
      output.println( "<HTML><HEAD><TITLE>\n");
      output.println( "Add a Course\n" );
      output.println( "</TITLE></HEAD><BODY>\n" );
      if (input1 == null)
      {
        output.println("No section selected");
        output.println( "</BODY></HTML>" );
        output.close();  
        return;
      }
      GregorianCalendar today = new GregorianCalendar();
      String today_date = (today.get(GregorianCalendar.MONTH) + 1) + "/" +
                            today.get(GregorianCalendar.DATE) + "/" +
                            today.get(GregorianCalendar.YEAR);
      try
      {
        ResultSet result1 = stmt.executeQuery("select COUNT(*) from ENROLLMENTS" 
                                            + " where CRN = " + input1  +
                                            " and USERID ='" + input2 + "';");
        result1.next();
        boolean ok1 = (result1.getInt(1) == 0);
        ResultSet result2 = stmt.executeQuery("select COUNT(*) from OFFERINGS "
                                               + "where CRN = " + input1 + ";");
        result2.next();      
        boolean ok2 = (result2.getInt(1) == 1);
        ResultSet result3 = stmt.executeQuery("select ENROLLMAX - ENROLLCURRENT " 
                                              + "from OFFERINGS where CRN = " 
                                              + input1 + ";");
        result3.next();      
        boolean ok3 = (result3.getInt(1) >= 1);
        if (ok1 && ok2 && ok3)
        {
          stmt.executeUpdate("insert into ENROLLMENTS values(" +
                               input1 + ",'" + input2 + "','" + today_date +
                               "','');");
          stmt.executeUpdate("update OFFERINGS set ENROLLCURRENT = " +
                                 "ENROLLCURRENT + 1 WHERE CRN = " 
                                 + input1 + ";");
          output.println("Insert made");
        }
        else if (! ok1)
          output.println("Duplicate entry");
        else if (! ok2)
          output.println("No such CRN");
        else if (! ok3)
          output.println("Class is full");
        output.println( "</BODY></HTML>" );
        output.close();    
      }
      catch(SQLException ex)
      {
         System.err.println("SQLException: " + ex.getMessage());
      }
   }

} 