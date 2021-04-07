package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AdminPage extends JFrame implements ActionListener{
    private JPanel up,down,right,left,center,br,bl,dummy,dummy2,dummypanel,dummy3;
    private JButton staff,customer,createorder,view,payment,logout,vieworder;
    
    public AdminCreateOrderSearchCustomer ACOSC;
    public AdminViewStaff adminviewstaff;
    public AdminPageViewOrder APVO;
    public AdminPage(){
         //setJFrame
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
        up.setBackground(Color.LIGHT_GRAY);
        
        
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
        
        //setleft
        left = new JPanel(new GridLayout(2,0));
        center.add(left);
        
        //setright
        right = new JPanel(new GridLayout(4,0));
        center.add(right);
        
        //setstaffbutton
        staff = new JButton("STAFF");
        left.add(staff);
        staff.setFont(f); 
        staff.addActionListener(this);
        
        
        //setcustomerbutton
        customer = new JButton("CUSTOMER");
        left.add(customer);
        customer.setFont(f);
        customer.addActionListener(this);
        
    //setRightButton
        //setCreateOrder
        createorder = new JButton("CREATE ORDER");
        right.add(createorder);
        createorder.setFont(bold);
        createorder.addActionListener(this);
              
        
        //setView
        view = new JButton("VIEW STAFFS RATING");
        right.add(view);
        view.setFont(bold);
        view.addActionListener(this);
        
        //setvieworder
        vieworder = new JButton("VIEW ALL ORDER");
        right.add(vieworder);
        vieworder.setFont(bold);
        vieworder.addActionListener(this);
        
        //setlogout
        dummypanel = new JPanel(new BorderLayout());
            right.add(dummypanel);
                           
            
                //setbackbutton
                dummy2 = new JPanel();
                dummypanel.add(dummy2,BorderLayout.SOUTH);
                
                logout = new JButton("LOGOUT");
                dummy2.add(logout);
                logout.addActionListener(this);
        
        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==staff){
            setVisible(false);
            CourierServiceSystem.adminstaff.setVisible(true);
        }
        else if(ae.getSource()==customer){
            setVisible(false);
            CourierServiceSystem.admincustomer.setVisible(true);
        }
        else if(ae.getSource()==createorder){
            ACOSC = new AdminCreateOrderSearchCustomer();
            ACOSC.setVisible(true);
            setVisible(false);
        }

        else if(ae.getSource()==view){
            adminviewstaff =new AdminViewStaff(CourierServiceSystem.allorder);
            adminviewstaff.setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==vieworder){
            APVO = new AdminPageViewOrder();
            APVO.setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            CourierServiceSystem.homepage.setVisible(true);
        }
    }
}
