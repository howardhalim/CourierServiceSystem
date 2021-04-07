
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface sendemail {
    static void send(order myorder){
        try{
            
            String url = "EmailOrder_0"+myorder.getOrderId()+"_Status.txt";
            PrintWriter p = new PrintWriter(url);
            p.println("FROM: "+myorder.getAssignstaff().getEmail());
            p.println("TO: "+myorder.getMycustomer().getEmail());
            p.println("SUBJECT: DELIVERY STATUS");
            p.println("Order 0"+myorder.getOrderId() +" has successfully been delivered to "+myorder.getReciever());
            p.println("We Would Highly Appreciate by Filling The Rating and Feedback Form for Further Improvement!");
            p.println("Thank You for Trusting Our Services");
            
            
            
            p.close();
        }catch(FileNotFoundException ex){
            
        }

        
    }
}
