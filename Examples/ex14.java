
// ex14.java
// Use TreeSet and Iterator
// contains, remove, add methods for TreeSet

import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class ex14
{
    public static void main(String[] args) 
    {
        TreeSet letters = new TreeSet();
        letters.add("A");
        letters.add("D");
        letters.add("B");
        letters.add("A");
        letters.add("D");
        letters.add("C");
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                             "Quit\n" +
                                             "Print\n" +
                                             "Remove\n" +
                                             "Add");
        while (! choice.equalsIgnoreCase("Quit")) 
        {
            if (choice.equalsIgnoreCase("Print")) 
            {
                print(letters);
            }
            else if (choice.equalsIgnoreCase("Add")) 
            {
                String input = JOptionPane.showInputDialog("Enter letter");
                letters.add(input);
                System.out.println(input + " added");
            }
            else if (choice.equalsIgnoreCase("Remove")) 
            {
                String input = JOptionPane.showInputDialog(
                                         "Enter letter to remove");
                if (letters.contains(input))
                {
                    letters.remove(input);
                    System.out.println(input + " removed");
                }
                else
                    System.out.println(input + " not found"); 
            }
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Print\n" +
                                                 "Remove\n" +
                                                 "Add");
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
