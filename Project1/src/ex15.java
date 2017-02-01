
// ex15.java
// Use TreeMap, Set, and Iterator

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class ex15
{
    public static void main(String[] args) 
    {
        TreeMap teams = new TreeMap();
        teams.put("New York", "Yankees");
        teams.put("Boston", "Red Sox");
        teams.put("Toronto", "Blue Jays");
        teams.put("Baltimore", "Orioles");
        teams.put("Detroit", "Tigers");
        // put(key, value)
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
                print(teams);
            }
            else if (choice.equalsIgnoreCase("Add")) 
            {
                String city = JOptionPane.showInputDialog("Enter city");
                String team = JOptionPane.showInputDialog("Enter team");
                teams.put(city, team);
                System.out.println(team + " added");
            }
            else if (choice.equalsIgnoreCase("Remove")) 
            {
                String city = JOptionPane.showInputDialog("Enter city");
                if (teams.containsKey(city))
                {
                    teams.remove(city);
                    System.out.println(city + " removed");
                }
                else
                    System.out.println(city + " not found"); 
            }
            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                 "Quit\n" +
                                                 "Print\n" +
                                                 "Remove\n" +
                                                 "Add");
        }
    }
    
    static private void print(TreeMap data)
    {
        Set s = data.keySet();
        Iterator i = s.iterator();
        System.out.println();
        System.out.println();       
        while (i.hasNext()) 
        {
            String city = (String) i.next();
            System.out.println(city + " " + data.get(city));
        }
    }     
}
