
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public interface updatestaff {
    static void updatetxt(){
        try {
                   
            PrintWriter p = new PrintWriter("staff.txt");
                for(int i=0;i<CourierServiceSystem.allstaff.size();i++){
                    staff x = CourierServiceSystem.allstaff.get(i);
                    p.println(x.getName());
                    p.println(x.getId());
                    p.println(x.getUsername());
                    p.println(x.getPassword());
                    p.println(x.getPhone());
                    p.println(x.getAddress());
                    p.println(x.getEmail());
                    p.println(x.getStatus());
                    p.println();
                }                 

                                            
                p.close();
                  
            } catch (FileNotFoundException ex) {
                  
        }
    }
}
