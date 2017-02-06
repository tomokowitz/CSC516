package okowitz2b;

public class HomeCustomer implements Customer {
    public HomeCustomer(String Name, String Email) {
        this.name = Name;
        this.email = Email;
        
        
    }
    private String name;
    private String email;
    
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String customerInfo()
    {
        return "text:" + name + " more text: " + email;
    }
}
