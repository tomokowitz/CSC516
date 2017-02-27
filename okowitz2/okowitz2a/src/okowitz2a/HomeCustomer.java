package okowitz2a;

import javax.swing.JOptionPane;

public class HomeCustomer extends Customer {
    public HomeCustomer(String name, String email) {
        super(name, email);
        this.CustType = "Home";
    }
    public HomeCustomer(){
        super();
        CustType= JOptionPane.showInputDialog("Enter customer type");
        
    }
    //should output the name, the email, and the kind of user
    public void customerInfo() {
    
        String custInfo = "Customer name: "  + this.GetName() +
                     "\nCustomer email: " + this.GetEmail() +
                     "\nCustomer type: " + this.CustType +
                     "\n";
        System.out.println(custInfo);
    }
    private String CustType;
    
}