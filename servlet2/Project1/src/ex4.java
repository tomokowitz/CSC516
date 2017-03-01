// Session Tracking

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

public class ex4 extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
  private int total_votes;
  
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
    total_votes = 0;
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String this_name = request.getParameter("name");
    String this_color = request.getParameter("color");
    if (this_name == null || this_name.equals(""))
    {
      response.sendError(response.SC_BAD_REQUEST,
                      "Missing name");
      return;
    }
    if (this_color == null || this_color.equals(""))
    {
      response.sendError(response.SC_BAD_REQUEST,
                      "Missing color");
      return;
    }
    response.setContentType(CONTENT_TYPE);
    HttpSession session = request.getSession(true);
    ArrayList votes;
    int votes_made = 1;
    if (session.getAttribute("votes") == null)
      votes = new ArrayList();
    else
      votes = (ArrayList)session.getAttribute("votes");
    if (session.getAttribute("votes_made") != null)
    {
      Integer votes_so_far = 
             (Integer)session.getAttribute("votes_made");
      votes_made = votes_so_far.intValue() + 1;
    }
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>ex9</title></head>");
    out.println("<body>");
    Vote this_vote = getVote(votes, this_name);
    if (this_vote == null)
    {
      this_vote = new Vote(this_name, this_color);
      out.println(this_name + " your very first vote for " +
                  this_color + " has been recorded!");
      votes.add(this_vote);
      session.setAttribute("votes", votes);
    }
    else
    {
      out.println(this_name + " your vote for " +
                  this_color + " has been changed from " +
                  this_vote.getColor() + ".");
      this_vote.setColor(this_color);
      this_vote.addAccess();
      out.println("<P>Votes from you so far: " +
                  this_vote.getAccess());
    }
    out.println("<P>Total Votes in session: " +
                  votes_made);
    session.setAttribute("votes_made", new Integer(votes_made));
    out.println("<P>Total Votes since server started: " +
                  ++total_votes);
    out.println("</body></html>");
    out.close();
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
  
  public Vote getVote(ArrayList a, String name)
  {
    for (int i = 0; i < a.size(); i++)
    {
      Vote v = (Vote) a.get(i);
      if (name.equalsIgnoreCase(v.getName()))
        return v;
    }
    return null;
  }
}