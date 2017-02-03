import java.awt.Dimension;

public class Rectangle extends Shape 
{
    private Dimension sides;
    
    Rectangle(String color, int side1, int side2)
    {
      super(color);
      sides = new Dimension(side1, side2);
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
