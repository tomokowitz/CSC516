package okowitz2b;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class okowitz2b {
    public okowitz2b() {
       
    }

    public static void main(String[] args) {
        
        okowitz2b okowitz2b = new okowitz2b();
        
        TreeSet customers = new TreeSet();
        customers.add(new BusinessCustomer("abc cab co","customer@abccab.com"));
                customers.add(new BusinessCustomer("xyz courier co","customer@xyzcouriers.com"));
                
        print(customers);
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
                cust.customerInfo();
            }
        }    
}
