
package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class AdminCustomerSearchView extends JFrame implements ActionListener{
    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2;
    private JLabel name,email,phone,address;
    private JLabel Name,Email,Phone,Address,ID,id;
    private JButton confirm,cancel;
    private customer cusme;
    public AdminCustomerSearchView(customer me){
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
                cancel = new JButton("CANCEL");
                down.add(cancel);
                cancel.addActionListener(this);       
                confirm = new JButton("PRINT OUT DETAILS");
                down.add(confirm);
                confirm.addActionListener(this);
       
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
            name = new JLabel(me.getName());
            right.add(name);
            
            //setid
            id = new JLabel(me.getId());
            right.add(id);
            
            //setemail
            email = new JLabel(me.getEmail());
            right.add(email);
            
            //setphone
            phone = new JLabel(me.getPhone());
            right.add(phone);
            
            //setaddress
            address = new JLabel(me.getAddress());
            right.add(address);
            
            


            
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        
        if(ae.getSource()==cancel){
            dispose();
            CourierServiceSystem.admincustomer.setVisible(true);
        }
        else if(ae.getSource()==confirm){
            int res = JOptionPane.showConfirmDialog(this,"Printing Customer 0"+cusme.getId()+"_"+cusme.getName());
            if(res == JOptionPane.YES_OPTION){
                printuserdetail.print(cusme);
            }
            dispose();
            CourierServiceSystem.admincustomer.setVisible(true);
        }
    }




    
}
