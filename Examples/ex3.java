// ex3.java
// Simple Iteration with ListIterator

import java.util.ArrayList;
import java.util.ListIterator;

public class ex3 
{
    public static void main(String[] args) 
    {
        ArrayList students = new ArrayList();
        ListIterator li;
        students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
        students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
        students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High"));
        students.add( new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High")); 
        li = students.listIterator();
        while (li.hasNext())
        {
            Student current = (Student)li.next();
            System.out.println(current); 
        }
    }
}
