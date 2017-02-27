package okowitz2a;
import javax.swing.JOptionPane;

public class BusinessCustomer extends Customer {

    public BusinessCustomer()
    {
        super();
        CustType= JOptionPane.showInputDialog("Enter customer type");
    };
    public BusinessCustomer(String name, String email) {
    
        super(name, email);
        this.CustType = "Business";
        
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