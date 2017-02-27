package okowitz2a;

import javax.swing.JOptionPane;

public abstract class Customer implements Comparable

{
    public Customer(String Name, String E_mail) 
    {
        this.name = Name;
        this.email = E_mail;
    }
    
    public Customer(){
        
        name = JOptionPane.showInputDialog("Enter customer name");
                email = JOptionPane.showInputDialog("Enter customer email");
               
    }
    public abstract void customerInfo();
   
    
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
        Customer c2 = (Customer) o; 
                String c1Email = GetEmail();
                String c2Email = c2.GetEmail();
                return c1Email.compareToIgnoreCase(c2Email); 
     
    }
}
