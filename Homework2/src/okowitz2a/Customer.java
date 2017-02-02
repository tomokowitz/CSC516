package okowitz2a;

public abstract class Customer implements Comparable

{
    public Customer(String Name, String E_mail) 
    {
        this.name = Name;
        this.email = E_mail;
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
        
    }
}
