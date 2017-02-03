package okowitz2a;

import javax.swing.JOptionPane;

public abstract class Customer implements Comparable

{
    public Customer(String Name, String E_mail) 
    {
        this.name = Name;
        this.email = E_mail;
    }
    public Customer()
        {
            name = JOptionPane.showInputDialog("Enter name");
            email = JOptionPane.showInputDialog("Enter email");
           
        }
    public abstract void customerInfo()
    {
            
    }
    private String name;
    private String email;
    
    public String GetName()
    {
        return name;
    }
    public String GetEmail()
    {
        return email;
    }
    public int compareTo(Object o)
    {
        
        compareToIgnoreCase();
    }
}
