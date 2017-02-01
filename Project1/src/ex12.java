
// ex12.java
// Use other Collections methods
// Now Student uses its Comparable interface
// for a natural ordering

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

public class ex12
{
    public static void main(String[] args) 
    {
        LinkedList students = new LinkedList();
        students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
        students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
        students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High"));
        students.add( new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High")); 
        Collections.sort(students, new StudentComparator());
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                             "Quit\n" +
                                             "Sort\n" +
                                             "Reverse\n" +
                                             "Shuffle");
        while (! choice.equalsIgnoreCase("Quit")) 
        {
            if (choice.equalsIgnoreCase("Sort")) 
            {
                Collections.sort(students);
                print(students);
            }
            else if (choice.equalsIgnoreCase("Reverse")) 
            {
                Collections.sort(students, Collections.reverseOrder());
                print(students);
            }
            else if (choice.equalsIgnoreCase("Shuffle")) 
            {
                Collections.shuffle(students);
                print(students);
            }
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Sort\n" +
                                                 "Reverse\n" +
                                                 "Shuffle");     
        }
    }
    
    static private void print(LinkedList data)
    {
        ListIterator li = data.listIterator();
        System.out.println();
        System.out.println();       
        while (li.hasNext()) 
        {
            System.out.println(li.next());
        }
    }     
}
