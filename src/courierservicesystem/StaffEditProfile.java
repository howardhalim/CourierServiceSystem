package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StaffEditProfile extends JFrame implements ActionListener {
    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2;
    private JTextField name,email,phone,address;
    private JLabel Name,Email,Phone,Address,ID,id;
    private JButton confirm,cancel;
    private staff staffme;
    public StaffPage staffpage;
    public StaffEditProfile(staff me){
        staffme = me;
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
            Name = new JLabel("<html><pre>Name      :</pre><html>");
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
            name = new JTextField(me.getName());
            right.add(name);
            
            //setid
            id = new JLabel(me.getId());
            right.add(id);
            
            //setemail
            email = new JTextField(me.getEmail());
            right.add(email);
            
            //setphone
            phone = new JTextField(me.getPhone());
            right.add(phone);
            
            //setaddress
            address = new JTextField(me.getAddress());
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
            
    }

    @Override
    public void actionPerformed(ActionEvent ae) {        
        String Name = name.getText();
        String Email = email.getText();
        String Phone = phone.getText();
        String Address = address.getText();
        
        
        if(ae.getSource()==confirm){
            if(Name.equals("")||Email.equals("")||Phone.equals("")||Address.equals("")){
                JOptionPane.showMessageDialog(this, "All Data Must Be Provided!");
            }
            else{
                staffme.setName(Name);
                staffme.setEmail(Email);
                staffme.setPhone(Phone);
                staffme.setAddress(Address);
                updatestaff.updatetxt();
                dispose();
                staffpage = new StaffPage(staffme);
                staffpage.setVisible(true);
            }
            
        }
        else if(ae.getSource()==cancel){
            dispose();
            staffpage = new StaffPage(staffme);
            staffpage.setVisible(true);
        }
    }
}
