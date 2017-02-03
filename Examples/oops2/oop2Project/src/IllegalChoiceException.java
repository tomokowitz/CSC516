public class IllegalChoiceException extends Exception
{
  private String choice;
  private String reason;
  
  IllegalChoiceException(String choice, String reason)
  {
    super();
    this.choice = choice;
    this.reason = reason;
  }
  
  public String toString()
  {
    return choice + " is no good because of " + reason;
  }
  
}
