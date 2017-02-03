/* Written by John Avitabile
   OOP2 Example 0
   Abstract classes
*/
import java.util.ArrayList;

public class ex
{
    
    public static void main(String[] args) 
    {
        ArrayList<Shape> data = new ArrayList<Shape>(); 
        data.add(new Circle("Red", 5));
        data.add(new Circle("Blue", 10));  
        data.add(new Rectangle("Red", 5, 10));
        for (Shape s : data) 
        {
            System.out.println(s.toString());
        } 
    }
}
