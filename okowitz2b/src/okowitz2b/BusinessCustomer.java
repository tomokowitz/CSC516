package okowitz2b;

public class BusinessCustomer implements Customer {
    /**
     * @param Name
     * @param Email
     */
    public BusinessCustomer(String Name, String Email) {
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
    public int compareTo(Object o)
    {
        Customer c2;
        c2 = (Customer) o;
        String c1Email = getEmail();
                String c2Email = c2.getEmail();
                return c1Email.compareToIgnoreCase(c2Email); 
     
    }
}
