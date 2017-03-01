// Vote.java

public class Vote
{
  private String name;
  private String color;
  private int access;
  
  Vote(String name, String color)
  {
    access = 1;
    this.name = name;
    this.color = color;
  }
  
  public void addAccess()
  {
    access++;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getAccess()
  {
    return access;
  }  
  
  public String getColor()
  {
    return color;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setColor(String color)
  {
    this.color = color;
  }
}