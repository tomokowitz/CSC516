// ex2.java
// ArrayList

import java.util.ArrayList;

public class ex2 
{
    public static void main(String[] args) 
    {
        ArrayList students = new ArrayList();
        students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
        students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
        students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High"));
        students.add( new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High")); 
        for (int i = 0; i < students.size(); i++) 
        {
            System.out.println(students.get(i)); 
            // automatic call to Object's toString()
        }
    }
}
