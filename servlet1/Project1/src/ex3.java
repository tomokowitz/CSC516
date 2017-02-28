import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ex3 extends HttpServlet {

   double JacketPrice = 100;
   double HatPrice = 10;
   double TShirtPrice = 20;

   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
   }

   public void doPost( HttpServletRequest request,
                      HttpServletResponse response )
      throws ServletException, IOException
   {
     int quantity1 = Integer.parseInt(request.getParameter( "quantity1" ));
     int quantity2 = Integer.parseInt(request.getParameter( "quantity2" ));
     int quantity3 = Integer.parseInt(request.getParameter( "quantity3" ));

      String delivery = request.getParameter( "delivery" );
      String name = request.getParameter( "name" );
      String email = request.getParameter( "email" );
      double total = 0;
      PrintWriter output;
      response.setContentType( "text/html" );  // content type
      output = response.getWriter();           // get writer
      output.println( "<HTML><HEAD><TITLE>\n");
      output.println( "Welcome to Example #2!\n" );
      output.println( "</TITLE></HEAD><BODY>\n" );
      output.println( "Name: " + name + "\n" );
      output.println( "<P>Email: " + email + "\n" );
      output.println( "<P>Your Order!\n");
      output.println("<TABLE WIDTH=75% BORDER=2><TR>\n");
      output.println(
      "<TH>Product</TH><TH>Quantity</TH><TH>Price</TH><TH>Total</TH>\n");
      output.println("</TR>\n");
      if (request.getParameter( "product1" ) != null) 
      // check if checkbox checked
      {
        double subtotal = quantity1 * JacketPrice;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>Jacket</TD><TD>" + quantity1 + "</TD><TD>" +
                       JacketPrice + "</TD><TD>" + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      if (request.getParameter( "product2" ) != null) 
      // check if checkbox checked
      {
        double subtotal = quantity2 * HatPrice;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>Hat</TD><TD>" + quantity2 + "</TD><TD>" +
                       HatPrice + "</TD><TD>" + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      if (request.getParameter( "product3" ) != null) 
      // check if checkbox checked
      {
        double subtotal = quantity3 * TShirtPrice;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>T Shirt</TD><TD>" + quantity3 + "</TD><TD>" +
                       TShirtPrice + "</TD><TD>" + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      if (request.getParameter( "delivery" ).equals("ups")) // check if ups
      {
        double subtotal = 5;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>UPS</TD><TD>&nbsp;</TD><TD>&nbsp;</TD><TD>"
                       + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      if (request.getParameter( "delivery" ).equals("fedex")) // check if ups
      {
        double subtotal = 10;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>Federal Express</TD><TD>&nbsp;</TD><TD>&nbsp;</TD><TD>"
                       + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      if (request.getParameter( "delivery" ).equals("firstclass")) // check if ups
      {
        double subtotal = 3;
        total += subtotal;
        output.println("<TR>\n");
        output.println("<TD>First Class Mail</TD><TD>&nbsp;</TD><TD>&nbsp;</TD><TD>"
                       + subtotal + "</TD>\n");
        output.println("</TR>\n");
      }
      output.println("<TR>\n");
      output.println("<TD>&nbsp;</TD><TD>&nbsp;</TD><TD>&nbsp;</TD><TD>"
                     + total + "</TD>\n");
      output.println("</TR></TABLE>\n");
      output.println( "</BODY></HTML>" );
      output.close();    // close PrintWriter stream
   }

} 