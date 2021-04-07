
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public interface updatecustomer {
    static void updatetxt(){
        try {
                   
            PrintWriter p = new PrintWriter("customer.txt");
                for(int i=0;i<CourierServiceSystem.allcustomer.size();i++){
                    customer x = CourierServiceSystem.allcustomer.get(i);
                    p.println(x.getName());
                    p.println(x.getId());
                    p.println(x.getUsername());
                    p.println(x.getPassword());
                    p.println(x.getEmail());
                    p.println(x.getPhone());
                    p.println(x.getAddress());
                    p.println();
                }                 

                                            
                p.close();
                  
            } catch (FileNotFoundException ex) {
                  
        }        
    }
}
