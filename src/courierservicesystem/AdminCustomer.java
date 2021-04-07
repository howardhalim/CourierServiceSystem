package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminCustomer extends JFrame implements ActionListener {

    private JPanel center,up,down,br,bl,firstpanel,secondpanel,thirdpanel,fourthpanel,dummypanel;
    private JButton add,delete,update,search,staffcustomer,back;
    private JLabel header,dummy;
    public customer x;
    public AddCustomer addcustomer;
    public AdminCustomerSearch admincustomersearch;
    public AdminCustomerList admincustomerlist;
    public AdminCustomer(){
        setSize(700,400);
        setLocation(700,300);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font bold = new Font(Font.SANS_SERIF,Font.BOLD,14);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setcenter
        center = new JPanel(new GridLayout(3,0));
        add(center,BorderLayout.CENTER);
        
        //set-up
        up = new JPanel();
        add(up,BorderLayout.NORTH);
        up.setBackground(Color.LIGHT_GRAY);
            //setheader
            header = new JLabel("CUSTOMER");
            up.add(header);
            header.setFont(f);
        
        //set-down
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
        down.setBackground(Color.LIGHT_GRAY);
        
        //setbr
        br = new JPanel();
        add(br,BorderLayout.EAST);
        br.setBackground(Color.LIGHT_GRAY);
        
        
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        bl.setBackground(Color.LIGHT_GRAY);
        
        
        //setfirstpanel
        firstpanel = new JPanel(new GridLayout(0,2));
        center.add(firstpanel);
        
            //setadd
            add = new JButton("ADD");
            firstpanel.add(add);
            add.addActionListener(this);
            
                 
           
            
            //setsearch
            search = new JButton("SEARCH");
            firstpanel.add(search);
            search.addActionListener(this);
        
        //setstafflist
        staffcustomer = new JButton("LIST");
        center.add(staffcustomer);
        staffcustomer.addActionListener(this);
        
        //fourthpanel
        fourthpanel = new JPanel(new BorderLayout());
        center.add(fourthpanel);
            //setSouthpanel
            dummypanel = new JPanel();
            fourthpanel.add(dummypanel,BorderLayout.SOUTH);
            
            //setBack
            back = new JButton("BACK");
            dummypanel.add(back);
            back.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            CourierServiceSystem.adminpage.setVisible(true);
        }
        else if(ae.getSource()==add){
            setVisible(false);
            addcustomer = new AddCustomer();
            addcustomer.setVisible(true);
        }
        else if(ae.getSource()==staffcustomer){
            admincustomerlist = new AdminCustomerList();
            admincustomerlist.setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == search){
            admincustomersearch = new AdminCustomerSearch();
            admincustomersearch.setVisible(true);
            setVisible(false);
        }
        
    }
    
}
