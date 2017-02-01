// ex5.java
// catch Exceptions

import java.util.ArrayList;
import java.util.ListIterator;

import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class ex5 
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
        System.out.println(current);
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                             "Quit\n" +
                                             "Next\n" +
                                             "Previous");
        while (! choice.equalsIgnoreCase("Quit")) 
        {
            try
            {
                if (choice.equalsIgnoreCase("Next")) 
                {
                    current = (Student) li.next();
                    System.out.println(current);
                }
                else if (choice.equalsIgnoreCase("Previous")) 
                {
                    current = (Student) li.previous();
                    System.out.println(current);
                }
            }
            catch (NoSuchElementException e)
            {
                System.out.println("No more");
            }
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Next\n" +
                                                 "Previous");            
        }
    }
    
    
}
