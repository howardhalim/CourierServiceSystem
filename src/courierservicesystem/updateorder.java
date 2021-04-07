
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface updateorder {
    static void updatetxt(){
        try{
            PrintWriter p = new PrintWriter("Order.txt");
            for(int i=0;i<CourierServiceSystem.allorder.size();i++){
                order x = CourierServiceSystem.allorder.get(i);
                p.println(x.orderId);
                p.println(x.reciever);
                p.println(x.address);
                p.println(x.status);
                p.println(x.getAssignstaff().getId());
                p.println(x.getMycustomer().getId());
                p.println(x.rating);
                p.println(x.feedback);
                p.println();
                               
                
            }
            
            
            
            p.close();
        }catch(FileNotFoundException ex){
            
        }

        
    }
}
