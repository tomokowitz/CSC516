public abstract class Shape
{
  private String color;
  
  Shape(String color)
  {
    this.color = color;
  }
  
  public String getColor()
  {
    return color;
  }
  
  public String toString() 
  {
      return "Shape's color is " + color +
             "\nShape's area is " + getArea() +
             "\nShape's circumference is " + getCircumference() +
             "\n";
  }
  
  public abstract double getArea();
  public abstract double getCircumference();
  
}
