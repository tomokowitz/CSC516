package okowitz2a;

public class HomeCustomer extends Customer {
    public HomeCustomer(String name, String email) {
        super(name, email);
    }
    //should output the name, the email, and the kind of user
    public void customerInfo() {
    
        
        return "Customer's info: " +   +
                     "\nShape's area is " + getArea() +
                     "\nShape's circumference is " + getCircumference() +
                     "\n";
    }

    public int compareTo(Object o) {
        return 0;
    }
}
