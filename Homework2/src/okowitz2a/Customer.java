package okowitz2a;

public abstract class Customer {
    public Cutomer(String Name, String E_mail) {
        this.name = Name;
        this.email = E_mail;
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
}
