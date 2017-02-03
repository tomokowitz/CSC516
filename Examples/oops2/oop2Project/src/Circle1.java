public class Circle1 implements Shape1 
{
    private String color;
    private int radius;
    
    Circle1(String color, int radius)
    {
      this.color = color;
      this.radius = radius;
    }
    
    public String toString() 
    {
        return "Circle's color is " + getColor() +
               "\nCircle's area is " + getArea() +
               "\nCircle's circumference is " + getCircumference() +
               "\n";
    }
    
    public String getColor()
    {
      return color;
    }
    
    public double getArea()
    {
      return Math.pow(radius, 2) * Math.PI;
    }
    
    public double getCircumference()
    {
        return Math.PI * (radius * 2);
    }
    
}
