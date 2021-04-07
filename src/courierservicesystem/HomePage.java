package courierservicesystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{

    JLabel header, homepagecontent,notes;
    JPanel loginpanel, headerpanel , centerpanel ;
    JButton login,customerlogin;
   
    public HomePage(){
        //set JFRAME
        setSize(500,250);
        setLocation(800,350);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,16);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //set headerpanel
        headerpanel = new JPanel();
        add(headerpanel,BorderLayout.NORTH);
        headerpanel.setBackground(Color.CYAN);
        
        //set loginpanel
        loginpanel = new JPanel();
        add(loginpanel,BorderLayout.SOUTH);
        loginpanel.setBackground(Color.CYAN);
        
        //set centerpanel
        centerpanel = new JPanel();
        add(centerpanel, BorderLayout.CENTER);
        centerpanel.setBackground(Color.LIGHT_GRAY);
        
        
        //set header
        header = new JLabel("Welcome to Courier Service System");
        headerpanel.add(header);
        
        //set homepagecontent
        homepagecontent = new JLabel("<html>Proceed with login button for admin and staffs.<br>Proceed with Customer Login button <br>for Customer Login<html>");
        notes = new JLabel("<html>IMPORTANT NOTES<html>");
        notes.setForeground(Color.RED);
        notes.setFont(f);
        homepagecontent.setForeground(Color.BLACK);
        homepagecontent.setFont(f);
        centerpanel.add(notes);
        centerpanel.add(homepagecontent);
        
        
        
        //set login button
        login = new JButton("Login");
        login.addActionListener(this);
        loginpanel.add(login);
        
        //set customerlogin button
        customerlogin = new JButton("Customer Login");
        customerlogin.addActionListener(this);
        loginpanel.add(customerlogin);




        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==login){
           setVisible(false);
           CourierServiceSystem.loginpage.setVisible(true);
       }
       else if(ae.getSource()==customerlogin){
           setVisible(false);
           CourierServiceSystem.customerloginpage.setVisible(true);
       }
    }
    
    
    
    
}
