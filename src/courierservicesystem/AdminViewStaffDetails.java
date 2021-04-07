package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AdminViewStaffDetails extends JFrame implements ActionListener {
    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2,dummy3,dummy4;
    private JLabel id,cusname,rating,feedback;
    private JLabel Id,Cusname,Rating,Feedback;
    private JButton back;
    order myorder;
    staff me;

    public AdminViewStaffDetails(order x){
        myorder = x;

        
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
            //setback
            back = new JButton("BACK");
            back.addActionListener(this);
            down.add(back);
            
        //setbr
        br = new JPanel();
        add(br,BorderLayout.EAST);
       
                
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        
        //setleft
        left = new JPanel(new GridLayout(5,0));
        center.add(left);
            //setLabel
            Id = new JLabel("<html><pre>ORDER ID      :</pre><html>");
            left.add(Id);
            
            Cusname = new JLabel("<html><pre>CUSTOMER NAME :</pre><html>");
            left.add(Cusname);
            
            Rating = new JLabel("<html><pre>RATING        :</pre><html>");
            left.add(Rating);
            
            Feedback = new JLabel("<html><pre>FEEDBACK      :</pre><html>");
            left.add(Feedback);
            
            
        
        //setright
        right = new JPanel(new GridLayout(5,0));
        center.add(right);
            //setdata
            id = new JLabel(x.getOrderId());
            right.add(id);
            cusname = new JLabel(x.getMycustomer().getName());
            right.add(cusname);
            if(x.getRating().equals("")){
                rating = new JLabel("Rating Has Not Been Submitted");
                feedback = new JLabel("Feedback Has Not Been Submitted");
            }
            else{
                rating = new JLabel(x.getRating());
                feedback = new JLabel(x.getFeedback());
            }
            right.add(rating);
            right.add(feedback);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            dispose();
            CourierServiceSystem.adminpage.setVisible(true);
        }
    }
    
}
