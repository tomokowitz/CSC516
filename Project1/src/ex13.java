
// ex13.java
// Use TreeSet and Iterator

import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class ex13
{
    public static void main(String[] args) 
    {
        TreeSet students = new TreeSet();
        students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
        students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
        students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High"));
        students.add( new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High")); 
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                             "Quit\n" +
                                             "Print\n" +
                                             "Add Grad Student\n" +
                                             "Add Undergrad Student");
        while (! choice.equalsIgnoreCase("Quit")) 
        {
            if (choice.equalsIgnoreCase("Print")) 
            {
                print(students);
            }
            else if (choice.equalsIgnoreCase("Add Grad Student")) 
            {
                GradStudent input = new GradStudent();
                students.add(input);
                System.out.println(input + " added");
            }
            else if (choice.equalsIgnoreCase("Add Undergrad Student")) 
            {
                UndergradStudent input = new UndergradStudent();
                students.add(input);
                System.out.println(input + " added");
            }
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Print\n" +
                                                 "Add Grad Student\n" +
                                                 "Add Undergrad Student");  
        }
    }
    
    static private void print(TreeSet data)
    {
        Iterator li = data.iterator();
        System.out.println();
        System.out.println();       
        while (li.hasNext()) 
        {
            System.out.println(li.next());
        }
    }     
}
