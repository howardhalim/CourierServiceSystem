package courierservicesystem;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class CourierServiceSystem  {
    
    
    public static ArrayList<staff> allstaff = new ArrayList<staff>();
    public static ArrayList<customer> allcustomer = new ArrayList<customer>();
    public static TreeSet <String> staffusername = new TreeSet<String>();
    public static TreeSet <String> customerusername = new TreeSet<String>();
    public static ArrayList<order> allorder = new ArrayList<order>();
    public static ArrayList<bills> allbills = new ArrayList<bills>();
    //public static TestPage test = new TestPage();
    public static HomePage homepage = new HomePage();
    public static loginpage loginpage = new loginpage();
    public static AdminPage adminpage = new AdminPage();
    public static AdminStaff adminstaff = new AdminStaff();
    public static AdminCustomer admincustomer = new AdminCustomer();
    public static CustomerLoginPage customerloginpage = new CustomerLoginPage();
   // public static StaffPage staffpage = new StaffPage();
   // public static StaffEditProfile staffeditprofile = new StaffEditProfile();

    
    
   
    
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("Staff.txt"));
            while(s.hasNext()){
                String name,username,password,id,email,phone,address,status;
                name = s.nextLine();
                id = s.nextLine();
                username = s.nextLine();
                password = s.nextLine();
                phone = s.nextLine();
                address = s.nextLine();
                email = s.nextLine();
                status = s.nextLine();
                staffusername.add(username);
                staff dummy = new staff(name,id,username,password,phone,email,address,status);
                
                allstaff.add(dummy);
                
                s.nextLine();
                
            }
            s = new Scanner(new File("Customer.txt"));
            while(s.hasNext()){
                String name,id,email,phone,address,username,password;
                name = s.nextLine();
                id = s.nextLine();
                username=s.nextLine();
                password = s.nextLine();
                phone = s.nextLine();
                email = s.nextLine();
                address = s.nextLine();
                
                customerusername.add(username);
                customer dummy = new customer(name,id,username,password,phone,email,address);
                
                allcustomer.add(dummy);
                
                s.nextLine();
                
            }
            s = new Scanner(new File("Order.txt"));
            while(s.hasNext()){
                String orderid,reciever,address,assignstaffid,rating,customerid,feedback,status;
                staff x;
                customer y;
                orderid = s.nextLine();
                reciever = s.nextLine();
                address = s.nextLine();
                status = s.nextLine();
                assignstaffid = s.nextLine();

                x = IDtoObject.staffidtostaff(assignstaffid);
                
                customerid = s.nextLine();
                y = IDtoObject.customeridtocustomer(customerid);
                
                rating =s.nextLine();
                feedback = s.nextLine();
                s.nextLine();
                order z = new order(orderid,reciever,address,rating,feedback,status,x,y);
                
                allorder.add(z);
               
                
                
            }
            s = new Scanner(new File("Bills.txt"));
            while(s.hasNext()){
                String status,customerid,staffid,orderid;
                order z;
                staff x;
                customer y;
                
                status = s.nextLine();

                orderid = s.nextLine();
                z = IDtoObject.orderidtoorder(orderid);

                staffid = s.nextLine();               
                x = IDtoObject.staffidtostaff(staffid);
                
                customerid = s.nextLine();
                y = IDtoObject.customeridtocustomer(customerid);
                
                s.nextLine();
                bills t = new bills(status,z,x,y);
                allbills.add(t);
                
                
                
                
               
                
                
            }
            
            
           
        }catch(Exception ex){
            
        }
    }

    
}
