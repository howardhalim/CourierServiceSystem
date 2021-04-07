package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StaffPage extends JFrame implements ActionListener {
    
    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2,dummy3,dummy4;
    private JButton edit,back,update,status,ratingandfeedback;
    private JLabel header,name,id,email,phone,address;
    private JCheckBox available,not_available;
    private staff me;
    public StaffEditProfile staffeditprofile;
    public StaffUpdatePassword staffupdatepassword;
    public StaffPage staffpage;
    private ArrayList<order> selectedorder = new ArrayList<order>();
    
    public StaffRatingAndFeedbackPage SRAFP;

    
    public StaffPage(staff me){
        this.me = me;
        setSize(700,400);
        setLocation(700,300);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font bold = new Font(Font.SANS_SERIF,Font.BOLD,14);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setcenter
        center = new JPanel(new GridLayout(0,2));
        add(center,BorderLayout.CENTER);
        
        //set-up
        up = new JPanel();
        add(up,BorderLayout.NORTH);
       
 
        //set-down
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
       
        //setbr
        br = new JPanel();
        add(br,BorderLayout.EAST);
       
        
        
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        
        
        
        //setleftpanel
        left = new JPanel(new GridLayout(6,0));
        center.add(left);
        
            //setName
            String myname = CourierServiceSystem.loginpage.me.getName();
            name = new JLabel("NAME: "+myname);
            left.add(name);
            
            //setID
            String myid = CourierServiceSystem.loginpage.me.getId();
            id = new JLabel("ID: "+myid);
            left.add(id);
            
            
            //setEmail
            String myemail = CourierServiceSystem.loginpage.me.getEmail();
            email = new JLabel("EMAIL: "+myemail);
            left.add(email);
            
            //setPhone
            String myphone = CourierServiceSystem.loginpage.me.getPhone();            
            phone = new JLabel("PHONE: "+myphone);
            left.add(phone);
            
            //setAddress
            String myaddress = CourierServiceSystem.loginpage.me.getAddress();
            address = new JLabel("ADDRESS: "+myaddress);
            left.add(address);
            
            //setdummy3
            dummy3 = new JPanel();
            left.add(dummy3);
            
                //setEdit
                edit = new JButton("EDIT PROFILE");
                dummy3.add(edit);
                edit.addActionListener(this);
            
        
        
        //setrightpanel
        right = new JPanel(new GridLayout(4,0));
        center.add(right);
        
            //setRatingandFeedback
            ratingandfeedback = new JButton("RATING AND FEEDBACK");
            right.add(ratingandfeedback);
            ratingandfeedback.addActionListener(this);
            
            //set DelivStatus
            status = new JButton("DELIVERY STATUS UPDATE");
            right.add(status);
            status.addActionListener(this);
            
            //setUpdate
            update = new JButton("UPDATE PASSWORD");
            right.add(update);
            update.addActionListener(this);
            
            //setdummypanel
            dummypanel = new JPanel(new BorderLayout());
            right.add(dummypanel);
                           
            
                //setbackbutton
                dummy2 = new JPanel();
                dummypanel.add(dummy2,BorderLayout.SOUTH);
                
                back = new JButton("LOGOUT");
                dummy2.add(back);
                back.addActionListener(this);
                
                //setavailability
                dummy4 = new JPanel();
                dummypanel.add(dummy4,BorderLayout.CENTER);
                
                available = new JCheckBox("AVAILABLE",true);
                available.setEnabled(false);
                dummy4.add(available);
                
                
                not_available = new JCheckBox("NOT AVAILABLE",false);
                not_available.setEnabled(false);
                dummy4.add(not_available);
                
            if(!me.getStatus().equals("0")){
                available.setSelected(false);
                not_available.setSelected(true);
            }
        
       // setVisible(true);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==edit){
            dispose();
            
            staffeditprofile = new StaffEditProfile(me);
            staffeditprofile.setVisible(true);
            
        }
        else if(ae.getSource()==back){
            dispose();
            CourierServiceSystem.homepage.setVisible(true);
        }
        else if(ae.getSource()==update){
            setVisible(false);
            staffupdatepassword = new StaffUpdatePassword(me);
            staffupdatepassword.setVisible(true);
        }
        else if(ae.getSource()==status){
            dispose();
            if(me.getStatus().equals("0")){
                JOptionPane.showMessageDialog(this, "No Order Available!");
            }
            else if(me.getStatus().equals("2")){
                JOptionPane.showMessageDialog(this, "Waiting For Customer Payment");
            }
            else{
                order temp =  new order();
                for(int i=0;i<CourierServiceSystem.allorder.size();i++){
                    order te = CourierServiceSystem.allorder.get(i);
                    
                    if(te.getAssignstaff().equals(me) && te.getStatus().equals("0")){
                        
                        temp = te;
                        break;
                    }
                }
                
                String oid = temp.getOrderId();
                customer cus = temp.getMycustomer();
                String oname = cus.getName();
                int res = JOptionPane.showConfirmDialog(this,"Finished Following Order Details\nOrder ID: "+oid+"\nCustomer Name: "+oname);
                if(res == JOptionPane.YES_OPTION){
                    me.setStatus("0");
                    temp.setStatus("1");
                    updatestaff.updatetxt();
                    updateorder.updatetxt();
                    try {

                        TimeUnit.SECONDS.sleep(3);


                    } catch (InterruptedException ex) {

                    }
                    finally{
                        send(temp);
                        JOptionPane.showMessageDialog(this,"Email Sent Succesfully");
                    }
                    
                }
                
                
                                
                
                
                
            }
            staffpage = new StaffPage(me);
            staffpage.setVisible(true);
       }
        else if(ae.getSource()==ratingandfeedback){
            boolean found=false;
            for(int i=0;i<CourierServiceSystem.allorder.size();i++){
                order t = CourierServiceSystem.allorder.get(i);
                if(t.getAssignstaff().getId().equals(me.getId())){
                    selectedorder.add(t);
                    found =true;
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(this,"Order Does Not Exist");
            }
            else{
                SRAFP = new StaffRatingAndFeedbackPage(selectedorder,me);
                SRAFP.setVisible(true);
                dispose();
            }
        }
    }
    
    
    public void send(order myorder){
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
