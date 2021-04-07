
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface updatebills {
    static void updatetxt(){
        try{
            PrintWriter p = new PrintWriter("Bills.txt");
            for(int i=0;i<CourierServiceSystem.allbills.size();i++){
                bills x = CourierServiceSystem.allbills.get(i);
                p.println(x.getStatus());
                p.println(x.getOrderid().getOrderId());
                p.println(x.getStaffname().getId());
                p.println(x.getCusname().getId());
                p.println();
                               
                
            }
            
            
            
            p.close();
        }catch(FileNotFoundException ex){
            
        }

        
    }
}
