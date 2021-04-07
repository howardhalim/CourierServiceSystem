package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class AdminCreateOrder extends JFrame implements ActionListener {

    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2;
    private JTextField cusname,cusid,orderid,reciever,address;
    private JLabel Cusname,Cusid,Orderid,Reciever,Address;
    private JButton confirm,cancel;
    public order x;
    private customer cusme;
    
    public AdminAssignStaff adminassignstaff;
    
    public AdminCreateOrder(customer me){
        cusme = me;
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
            Cusname = new JLabel("<html><pre>CUSTOMER NAME      :</pre><html>");
            left.add(Cusname);
            
            //setID
            Cusid = new JLabel("<html><pre>CUSTOMER ID        :</pre><html>");
            left.add(Cusid);
        
            //setEmail
            Orderid = new JLabel("<html><pre>ORDER ID           :</pre><html>");
            left.add(Orderid);
            
            
            //setPhone
            Reciever = new JLabel("<html><pre>TO                 :</pre><html>");
            left.add(Reciever);
            
            //setAddress
            Address = new JLabel("<html><pre>ADDRESS            :</pre><html>");
            left.add(Address);
        
        //setright
        right = new JPanel(new GridLayout(6,0));
        center.add(right,BorderLayout.CENTER);
        
            //setname
            cusname = new JTextField(me.getName());
            right.add(cusname);
            cusname.setEnabled(false);
            //setid
            cusid = new JTextField(me.getId());
            right.add(cusid);
            cusid.setEnabled(false);

            
            //setemail
            orderid = new JTextField();
            right.add(orderid);
            orderid.setEnabled(false);
            
            //setphone
            reciever = new JTextField();
            right.add(reciever);
            
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
           
           
           String Id = Integer.toString(CourierServiceSystem.allorder.size()+1);
           orderid.setText(Id);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       String oid, recv,addr;
       oid = orderid.getText();
       recv = reciever.getText();
       addr = address.getText();
       
       x = new order();
       x.setAddress(addr);
       x.setOrderId(oid);
       x.setReciever(recv);
       x.setMycustomer(cusme);
       
       
       if(ae.getSource()==cancel){
           dispose();
           CourierServiceSystem.adminpage.setVisible(true);
       }
       else if(ae.getSource()==confirm){
           if(oid.equals("")||recv.equals("")||addr.equals("")){
               JOptionPane.showMessageDialog(this,"Please Provide All Details!");
           }
           else{

                adminassignstaff = new AdminAssignStaff(cusme,x);
                adminassignstaff.setVisible(true);
                dispose();
           }
       }
    }
    
}

