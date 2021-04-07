
package courierservicesystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface printuserdetail {
    static void print(User x){
        try{
            String url = "";
            String id="",name="";
            int found=0;
            if(x instanceof staff){
                staff y = (staff)x;
                id = y.getId();
                name = x.getName();
                found = 1;
            }
            else if(x instanceof customer){
                customer y = (customer)x;
                id = y.getId();
                name = x.getName();
                found = 2;
            }
            if(found==1){
                url = "Staff_"+id+"_"+name+".txt";
            }
            else if(found==2){
                url = "Customer_"+id+"_"+name+".txt";
            }
            
            PrintWriter p = new PrintWriter(url);
            p.println(x.name);
            p.println(id);
            p.println(x.email);
            p.println(x.phone);
            p.println(x.address);
            
            
            
            p.close();
        }catch(FileNotFoundException ex){
            
        }

        
    }
}
