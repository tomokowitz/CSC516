/* Written by John Avitabile
   OOP2 Example 2
   Exceptions - use IllegalChoiceException, private classes
   Also note how main creates a new instance of an ex2
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ex2 
{
    Colors crayola = new Colors();
    Prompt prompter = new Prompt();
    
    public static void main(String[] args) 
    {
        ex2 program = new ex2();
    }
    
    ex2() 
    {
        ArrayList<Shape1> data = new ArrayList<Shape1>();
        Scanner sc = new Scanner(System.in);
        assign(data);
        String input = prompter.getInput(sc, 
                           "Enter C for new Circle\n" +
                           "      R for new Rectangle\n" +
                           "      P for print\n" +
                           "      Q for Quit");
        while (! input.equalsIgnoreCase("Q")) 
        {
            try
            {
                if (input.equals("P")) 
                {
                  printAll(data);
                }
                else if (input.equals("C")) 
                {
                    String color = prompter.getInput(sc, "Enter a color");
                    if (crayola.legalColor(color))
                        data.add(new Circle1(color, 
                                            (int)Math.random()*100+1));
                    else 
                        throw new IllegalChoiceException(color, 
                                                         "illegal color"); 
                }
                else if (input.equals("R")) 
                {
                    String color = prompter.getInput(sc, "Enter a color");
                    if (crayola.legalColor(color))
                        data.add(new Rectangle1(color, 
                                            (int)(Math.random()*100)+1,
                                            (int)(Math.random()*100)+1));
                    else 
                        throw new IllegalChoiceException(color, 
                                                         "illegal color");                
                }
                else 
                {
                    throw new IllegalChoiceException(input, 
                                                     "illegal menu choice");
                }
            }
            catch (IllegalChoiceException e) 
            {
                System.out.println(e.toString());
            }
            input = prompter.getInput(sc, 
                                       "Enter C for new Circle\n" +
                                       "      R for new Rectangle\n" +
                                       "      P for print\n" +
                                       "      Q for Quit");
        }        
        
    }
    
    public static void printAll(ArrayList<Shape1> list) 
    {
        for (Shape1 s : list) 
        {
            System.out.println(s.toString());
        }        
    }
    
    public static void assign(ArrayList<Shape1> list)
    {
        list.add(new Circle1("Green", 5));
        list.add(new Circle1("Blue", 10));  
        list.add(new Rectangle1("Red", 5, 10));        
    }
    
    private class Prompt 
    {
        public String getInput(Scanner sc, String prompt) 
        {
            System.out.println(prompt);
            return sc.nextLine();            
        }
    }
    
    private class Colors 
    {
        String[] legalColors = {"Red", "Green", "Blue", "Yellow",
                                "Orange", "Brown", "Black", "Purple"}; 
                            
        Colors() 
        {   
        }
        
        public boolean legalColor(String str) 
        {
            for (String s : legalColors) 
            {
                if (s.equals(str)) 
                    return true;
            }
            return false;
        }
    }

}
