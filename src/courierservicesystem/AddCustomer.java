package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {

    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2;
    private JTextField name,email,phone,address,id;
    private JLabel Name,Email,Phone,Address,ID;
    private JButton confirm,cancel;
    
    public AddCustomerUsernamePassword addcustomerusernamepassword;
    private String idnum;
    public AddCustomer(){
        setSize(700,400);
        setLocation(700,300);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font bold = new Font(Font.SANS_SERIF,Font.BOLD,14);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setcenter
        center = new JPanel(new BorderLayout());
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
      
        //setleft
        left = new JPanel(new GridLayout(6,0));
        center.add(left,BorderLayout.WEST);
        
            //setName
            Name = new JLabel("<html><pre>NAME      :</pre><html>");
            left.add(Name);
            
            //setID
            ID = new JLabel("<html><pre>ID        :</pre><html>");
            left.add(ID);
        
            //setEmail
            Email = new JLabel("<html><pre>EMAIL     :</pre><html>");
            left.add(Email);
            
            //setPhone
            Phone = new JLabel("<html><pre>PHONE     :</pre><html>");
            left.add(Phone);
            
            //setAddress
            Address = new JLabel("<html><pre>ADDRESS   :</pre><html>");
            left.add(Address);
        
        //setright
        right = new JPanel(new GridLayout(6,0));
        center.add(right,BorderLayout.CENTER);
        
            //setname
            name = new JTextField();
            right.add(name);
            
            //setid
            id = new JTextField();
            right.add(id);
            id.setEnabled(false);

            
            //setemail
            email = new JTextField();
            right.add(email);
            
            //setphone
            phone = new JTextField();
            right.add(phone);
            
            //setaddress
            address = new JTextField();
            right.add(address);
            
            
            //setdummy
            dummypanel = new JPanel(new BorderLayout());
            right.add(dummypanel);
                dummy2 = new JPanel();
                dummypanel.add(dummy2,BorderLayout.SOUTH);
                //setconfirm
                confirm = new JButton("CONFIRM");
                dummy2.add(confirm);
                confirm.addActionListener(this);
                //setcancel
                cancel = new JButton("CANCEL");
                dummy2.add(cancel);
                cancel.addActionListener(this);
           
           
           customer x = CourierServiceSystem.allcustomer.get(CourierServiceSystem.allcustomer.size()-1);
           int Id = parseInt(x.getId())+1;
           idnum = Integer.toString(Id);
           id.setText(idnum);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String Name,Phone,Email,Address,Id;
        
        Name = name.getText();
        Id = idnum;
        
        Phone = phone.getText();
        Email = email.getText();
        Address = address.getText();
        
        CourierServiceSystem.admincustomer.x = new customer(Name,Id,Email,Phone,Address);
        if(ae.getSource()==confirm){
            if(Name.equals("") || Phone.equals("") || Email.equals("")||Address.equals("")){
                JOptionPane.showMessageDialog(this, "All Data Must Be Provided!");
            }
            else{
                setVisible(false);
                addcustomerusernamepassword = new AddCustomerUsernamePassword();

                addcustomerusernamepassword.setVisible(true);
                name.setText("");
                id.setText(idnum);
                phone.setText("");
                email.setText("");
                address.setText("");
               
                dispose();
            }
           
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            CourierServiceSystem.admincustomer.setVisible(true);
        }
    }
    
}
