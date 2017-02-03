public class Circle extends Shape 
{
    private int radius;
    
    Circle(String color, int radius)
    {
      super(color);
      this.radius = radius;
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
