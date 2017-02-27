package okowitz2b;


import java.util.Iterator;
import java.util.TreeSet;


public class okowitz2b {
    public okowitz2b() {
       
    }

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        @SuppressWarnings("unused")
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
