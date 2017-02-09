package okowitz3a;


import java.sql.*;
 
public class ex1 {
 
 public static void main(String args[])
 {
 
  String url = "jdbc:odbc:registrar";
  // more generally, url = "jdbc:mySubprotocol:myDataSource";
    
  Connection con;
  // A Connection represents a session with a specific database.
  // Within the
  // context of a Connection, SQL statements are executed and
  // results are returned.
 
  Statement stmt;
  // A Statement object is used for executing a static SQL
  // statement and obtaining
  // the results produced by it.
 
  String query = "select * from COURSES";
 
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // the general form would be:
      // Class.forName("myDriver.ClassName")
      // loads the JDBC-ODBC Bridge driver
      // The function returns the Class object associated with
      // the class with the given string name. Given the
      // fully-qualified name for a class or interface,
      // this method attempts to locate, load and link the
      // class. If it succeeds, returns the Class object
      // representing the class. If it fails, the method
      // throws a ClassNotFoundException.
  }
  catch(java.lang.ClassNotFoundException e)
  {
   System.err.print("ClassNotFoundException: ");
   System.err.println(e.getMessage());
  }
 
 

  try
  {
   // Attempt to establish a connection to the given database
   // URL. The Driver Manager attempts to select an appropriate
   // driver from the set of registered
   // JDBC drivers.
   // Genral form is:
   // DriverManager.getConnection(url, "myLogin", "myPassword");
   con = DriverManager.getConnection(url, "", "");
  
   // Returns a new Statement object for this Connection
   stmt = con.createStatement();
 
   // Returns a ResultSet that contains the data produced by the
   // query; never null
   ResultSet rs = stmt.executeQuery(query);
  
   // Prints to standard output
   System.out.println("Course Data:");
   System.out.println("Course\tTitle\tCredits");
 
   // the current row in the ResultSet is before the first row
   while (rs.next()) // advances the current row until no more
   {
    // get the data from the current row
    String course = rs.getString("COURSE");
    String description = rs.getString("DESCRIPTION");
    int credits = rs.getInt("CREDITS");
    System.out.println(course + "\t" + description + "\t" +
                       credits);
   }
   // In many cases, it is desirable to immediately release a
   // Statements's database and JDBC resources instead of
   // waiting for this to happen when it is
   // automatically closed; the close method provides this
   // immediate release.
   stmt.close();
  
   // Releases Connection's resources
   con.close();
  }
  catch(SQLException ex)
  {
   System.err.println("SQLException: " + ex.getMessage());
  }
 }
}
