package okowitz1;

import javax.swing.JOptionPane;

public class Student implements Comparable 
{
    private String firstName;
    private String lastName;
    private String SID;
    
    public Student(String firstName, String lastName, String SID) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SID = SID;
    }
    
    public Student() 
    {
        firstName = JOptionPane.showInputDialog("Enter first name");
        lastName = JOptionPane.showInputDialog("Enter last name"); 
        SID = JOptionPane.showInputDialog("Enter SID");
    }
    
    public String toString() 
    {
        return "Name: " + firstName + " " + lastName +
               " SID: " + SID;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    public String getSID() 
    {
        return SID;
    }
    
    public int compareTo(Object o) 
    {
        Student s2 = (Student) o;  
        String s1Name = getLastName() + " " + getFirstName();
        String s2Name = s2.getLastName() + " " + s2.getFirstName(); 
        return s1Name.compareToIgnoreCase(s2Name);        
    }
}
