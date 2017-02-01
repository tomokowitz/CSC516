// ex4.java
// Use ListIterator

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

public class ex4 
{
    public static void main(String[] args) 
    {
        ArrayList students = new ArrayList();
        ListIterator li;
        Student current;
        students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
        students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
        students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High"));
        students.add( new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High")); 
        li = students.listIterator();
        current = (Student) li.next();
        // go to first Student
        System.out.println(current);
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                             "Quit\n" +
                                             "Next\n" +
                                             "Previous");
        while (! choice.equalsIgnoreCase("Quit")) 
        {
            if (choice.equalsIgnoreCase("Next")) 
            {
                if (li.hasNext())
                {
                    current = (Student) li.next();
                    System.out.println(current);
                }
                else
                    System.out.println("No more");
            }
            if (choice.equalsIgnoreCase("Previous")) 
            {
                if (li.hasPrevious())
                {
                    current = (Student) li.previous();
                    System.out.println(current);
                }
                else
                    System.out.println("No more");
            }
            // see what happens if you do Next, then Previous
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Next\n" +
                                                 "Previous");            
        }
    }
    
    
}
