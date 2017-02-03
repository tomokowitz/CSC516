import java.awt.Dimension;

public class Rectangle1 implements Shape1
{
    private String color;
    private Dimension sides;
    
    Rectangle1(String color, int side1, int side2)
    {
      this.color = color;
      sides = new Dimension(side1, side2);
    }

    public String toString() 
    {
        return "Rectangle's color is " + getColor() +
               "\nRectangle's area is " + getArea() +
               "\nRectangle's circumference is " + getCircumference() +
               "\n";
    }
    
    public String getColor()
    {
      return color;
    }
    
    public double getArea()
    {
      return sides.getHeight() * sides.getWidth();
    }
    
    public double getCircumference()
    {
        return sides.getHeight() * 2 +
               sides.getWidth() * 2;
    }
    
}
