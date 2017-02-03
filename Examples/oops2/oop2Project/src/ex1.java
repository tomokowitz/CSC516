/* Written by John Avitabile
   OOP2 Example 1
   Interfaces
*/

import java.util.ArrayList;

public class ex1 
{
    
    public static void main(String[] args) 
    {
        ArrayList<Shape1> data = new ArrayList<Shape1>(); 
        data.add(new Circle1("Green", 5));
        data.add(new Circle1("Blue", 10));  
        data.add(new Rectangle1("Red", 5, 10));
        for (Shape1 s : data) 
        {
            System.out.println(s.toString());
        }
    }
}
