package courierservicesystem;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
public class CustomerRatingAndFeedback extends JFrame implements ActionListener{
    
    private JRadioButton rate1,rate2,rate3,rate4,rate5;
    private JTextField feedback;
    private JLabel rate,feed,r1,r2,r3,r4,r5;
    private JPanel center,up,down,br,bl,dummypanel,left,right,dummy2,dummy3,dummy4,radbut;
    private ButtonGroup G = new ButtonGroup();
    private JButton confirm,cancel;
    customer me ;
    public CustomerPage customerpage;
    order myorder;
    public CustomerRatingAndFeedback(customer me,order x){
        this.me = me;
        myorder = x;
        setSize(500,300);
        setLocation(800,350);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font bold = new Font(Font.SANS_SERIF,Font.BOLD,14);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        center = new JPanel(new GridLayout(0,2));
        add(center,BorderLayout.CENTER);
        
        //set-up
        up = new JPanel();
        add(up,BorderLayout.NORTH);
       
 
        //set-down
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
        
            //setconfirm
            confirm = new JButton("CONFIRM");
            confirm.addActionListener(this);
            down.add(confirm);
            
            //setcancel
            cancel = new JButton("CANCEL");
            cancel.addActionListener(this);
            down.add(cancel);
        
        //setbr
        br = new JPanel();
        add(br,BorderLayout.EAST);
       
        
        
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        
        left = new JPanel(new GridLayout(8,0));
        center.add(left);
            //set rate
            rate = new JLabel("<html><pre>RATE     :</pre><html>");
            left.add(rate);
            rate.setFont(f);
            dummy3 = new JPanel();
            left.add(dummy3);
            dummy4 = new JPanel();
            left.add(dummy4);
            //set feedback
            feed = new JLabel("<html><pre>FEEDBACK :</pre><html>");
            left.add(feed);
            feed.setFont(f);
        
            
        right = new JPanel(new GridLayout(8,0));
        center.add(right);
            //set radiobutton
            radbut = new JPanel(new GridLayout(0,5));
            right.add(radbut);
                //set but1
                rate1 = new JRadioButton();
                G.add(rate1);
                radbut.add(rate1);
                //set but2
                rate2 = new JRadioButton();
                G.add(rate2);
                radbut.add(rate2);
                //set but3
                rate3 = new JRadioButton();
                G.add(rate3);
                radbut.add(rate3);
                //set but4
                rate4 = new JRadioButton();
                G.add(rate4);
                radbut.add(rate4);
                //set but5
                rate5 = new JRadioButton();
                G.add(rate5);
                radbut.add(rate5);
            //set 12345
            dummy2 = new JPanel(new GridLayout(0,5));
            right.add(dummy2);
                //set1
                r1 = new JLabel("<html><pre> 1</pre><html>");
                dummy2.add(r1);
                //set2
                r2 = new JLabel("<html><pre> 2</pre><html>");
                dummy2.add(r2);
                //set3
                r3 = new JLabel("<html><pre> 3</pre><html>");
                dummy2.add(r3);
                //set4
                r4 = new JLabel("<html><pre> 4</pre><html>");
                dummy2.add(r4);
                //set5
                r5 = new JLabel("<html><pre> 5</pre><html>");
                dummy2.add(r5);

            //set1blankpanel
            dummypanel = new JPanel();
            right.add(dummypanel);
            
            //setFeedback
            feedback = new JTextField();
            right.add(feedback);
            
            
            
            setVisible(true);
            
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==cancel){
            dispose();
            customerpage = new CustomerPage(me);
            customerpage.setVisible(true);
        }
        else if(ae.getSource()==confirm){
            boolean found = true;
            String rating="";
            if(rate1.isSelected()){
                rating = "1";
            }
            else if(rate2.isSelected()){
                rating = "2";
            }
            else if(rate3.isSelected()){
                rating = "3";
            }
            else if(rate4.isSelected()){
                rating = "4";
            }
            else if(rate5.isSelected()){
                rating = "5";
            }
            else{
                found = false;
            }
            String Feedback = feedback.getText();
            if(Feedback.equals("")){
                found = false;
            }
            if(found){
                myorder.setFeedback(Feedback);
                myorder.setRating(rating);
                myorder.setStatus("2");
                updateorder.updatetxt();
                dispose();
                customerpage = new CustomerPage(me);
                customerpage.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(this,"Please Provide All Details!");
            }
            
            
        }
    }
    
}
