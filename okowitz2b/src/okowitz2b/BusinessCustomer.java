package okowitz2b;

public class BusinessCustomer implements Customer {
    public BusinessCustomer() {
    
    
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
