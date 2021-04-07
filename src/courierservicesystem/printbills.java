
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface printbills {
    static void print(order myorder,int i){
        try{
            String status="";
            String url = "Bills0"+myorder.getOrderId()+".txt";
            if(i==0){
                status = "DONE";
            }
            else{
                status = "UNPAID";
            }
            PrintWriter p = new PrintWriter(url);
            p.println("Order ID : "+ myorder.getOrderId());
            p.println("Customer Name : "+myorder.getMycustomer().getName());
            p.println("Reciever Name : "+myorder.getReciever());
            p.println("Delivery Address : "+myorder.getAddress());
            p.println("Delivery Staff Name: "+myorder.getAssignstaff().getName());
            p.println("Payment : "+status);
            
            
            
            p.close();
        }catch(FileNotFoundException ex){
            
        }

        
    }
}
