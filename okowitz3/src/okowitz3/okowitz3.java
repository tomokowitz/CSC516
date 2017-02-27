package okowitz3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class okowitz3 {
    public static void main(String args[])
    {
    

              
     String url = "jdbc:odbc:bakery";
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
    
     String query = "select * from CUSTOMERS";
    
    
    

     try
     {
      // Attempt to establish a connection to the given database
      // URL. The Driver Manager attempts to select an appropriate
      // driver from the set of registered
      // JDBC drivers.
      // Genral form is:
      // DriverManager.getConnection(url, "myLogin", "myPassword");
      //con = DriverManager.getConnection(url, "", "");
      con =   DriverManager.getConnection(
                 "jdbc:ucanaccess://C:/Users/Tom Okowitz/Documents/IT and Software/jdbc/bakery.accdb");
      // Returns a new Statement object for this Connection
      stmt = con.createStatement();
    
      // Returns a ResultSet that contains the data produced by the
      // query; never null
      ResultSet rs = stmt.executeQuery(query);
     
      // Prints to standard output
      System.out.println("Customer Data:");
      System.out.println("CustomerID\tCustomerName\tCustomerEmail");
    
      // the current row in the ResultSet is before the first row
      while (rs.next()) // advances the current row until no more
      {
       // get the data from the current row
       int customerID = rs.getInt("CustomerID");
       String customerName = rs.getString("CustomerName");
       String customerEmail = rs.getString("CustomerEmail");
       System.out.println(customerID + "\t" + customerName + "\t" +
                          customerEmail);
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


