package okowitz2a;

import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class okowitz2a {
    public okowitz2a() {
    }

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        okowitz2a okowitz2a = new okowitz2a();


        TreeSet customers;
        customers = new TreeSet();
        customers.add(new BusinessCustomer("abc cab co","customer@abccab.com"));
                customers.add(new BusinessCustomer("xyz courier co","customer@xyzcouriers.com"));
                customers.add(new HomeCustomer("Fred Flinstone","customer@bedrock.com"));
                customers.add(new HomeCustomer("Barney Rubble","customer@MarbleMouth.com"));
                
                
                String choice;
                        choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                             "Quit\n" +
                                                             "Print\n" +
                                                             "Add Business Customer\n" +
                                                             "Add Home Customer");
                
                while (!choice.equalsIgnoreCase("Quit"))
                        {
                            if (choice.equalsIgnoreCase("Print"))
                            {
                                print(customers);
                            }
                            else if (choice.equalsIgnoreCase("Add Business Customer"))
                            {
                                BusinessCustomer input = new BusinessCustomer();
                                customers.add(input);
                                input.customerInfo();
                            }
                            else if (choice.equalsIgnoreCase("Add Home Customer"))
                            {
                                HomeCustomer input = new HomeCustomer();
                                customers.add(input);
                                input.customerInfo();
                            }
                            choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                                 "Quit\n" +
                                                                 "Print\n" +
                                                                 "Add Business Customer\n" +
                                                                 "Add Home Customer"); 
                        }
                
            }
            
    static private void print(TreeSet data)
        {
            Iterator li = data.iterator();
            System.out.println();
            System.out.println();      
            while (li.hasNext())
            {
                Customer cust ;
                cust = (Customer)li.next();
                System.out.println(cust.customerInfo());
            }
        }    
            
 }
        
        
    

