
package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CustomerPage extends JFrame implements ActionListener{
   private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2,dummy3,dummy4;
    private JButton edit,back,update,status,ratingandfeedback,pay;
    private JLabel header,name,id,email,phone,address;
    private JLabel dum;
    private ArrayList<order> selectedorder = new ArrayList<order>();
    private ArrayList<bills> selectedbills = new ArrayList<bills>();
    private customer me;
    public CustomerEditProfile customereditprofile;
    public CustomerUpdatePassword customerupdatepassword;
    public CustomerPayment customerpayment;
    public CustomerRatingAndFeedbackChoose CRAFC;
    
    public CustomerPage(customer me){
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
           
            name = new JLabel("NAME: "+me.getName());
            left.add(name);
            
            //setID
            
            id = new JLabel("ID: "+me.getId());
            left.add(id);
            
            
            //setEmail
            
            email = new JLabel("EMAIL: "+me.getEmail());
            left.add(email);
            
            //setPhone
                       
            phone = new JLabel("PHONE: "+me.getPhone());
            left.add(phone);
            
            //setAddress
            
            address = new JLabel("ADDRESS: "+me.getAddress());
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
            
            
            //setUpdate
            update = new JButton("UPDATE PASSWORD");
            right.add(update);
            update.addActionListener(this);
            
            
            
            pay = new JButton("PAYMENT");
            right.add(pay);
            pay.addActionListener(this);
            
            //setdummypanel
            dummypanel = new JPanel(new BorderLayout());
            right.add(dummypanel);
                           
            
                //setbackbutton
                dummy2 = new JPanel();
                dummypanel.add(dummy2,BorderLayout.SOUTH);
                
                back = new JButton("LOGOUT");
                dummy2.add(back);
                back.addActionListener(this);
                
        
        
       // setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==edit){
            dispose();
            customereditprofile = new CustomerEditProfile(me);
            customereditprofile.setVisible(true);
            
        }
        else if(ae.getSource() == update){
            customerupdatepassword = new CustomerUpdatePassword(me);
            customerupdatepassword.setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==ratingandfeedback){
            
            
            boolean found=false;
            for(int i=0;i<CourierServiceSystem.allorder.size();i++){
                order t = CourierServiceSystem.allorder.get(i);
                if(t.getStatus().equals("1") && t.getMycustomer().getId().equals(me.getId())){
                    
                    selectedorder.add(t);
                    found =true;
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(this,"Order Does Not Exist");
            }
            else{
                CRAFC = new CustomerRatingAndFeedbackChoose(selectedorder,me);
                CRAFC.setVisible(true);
                dispose();
            }
            
            
        }
        else if(ae.getSource()==pay){
            for(int i=0;i<CourierServiceSystem.allbills.size();i++){
                bills t = CourierServiceSystem.allbills.get(i);

                if(t.getStatus().equals("0")&&t.getCusname().equals(me)){
                    selectedbills.add(t);
                }
            }
            if(selectedbills.size()==0){
                JOptionPane.showMessageDialog(this,"No Pending Bills");
            }
            else{
                customerpayment = new CustomerPayment(selectedbills,me);
                customerpayment.setVisible(true);
                dispose();
            }
        }
        else if(ae.getSource()==back){
            CourierServiceSystem.homepage.setVisible(true);
            dispose();
        }
        

    }
}
