package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class AddStaffUsernamePassword extends JFrame implements ActionListener {

    private JLabel username,pas,header,confpas;
    private JPanel left,right,up,down,center,br,bl;
    private JTextField name;
    private JPasswordField pass,confpass;
    private JButton confirm,cancel;
    
    public AddStaffUsernamePassword(){
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
            
            //cancel
            cancel = new JButton("CANCEL");
            
            cancel.addActionListener(this);
            //setconfirmbutton
            confirm = new JButton("CONFIRM");
            down.add(confirm);
            confirm.addActionListener(this);
            down.add(cancel);
       
       
        //setbr
        br = new JPanel();
        add(br,BorderLayout.EAST);
      
        
        
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        
        //setleft
        left = new JPanel(new GridLayout(6,0));
        center.add(left,BorderLayout.WEST);
        
            //setusername
            username = new JLabel("<html><pre>USERNAME         :</pre><html>");
            left.add(username);
            username.setFont(f);
            
            //setpas
            pas = new JLabel("<html><pre>PASSWORD         :</pre><html>");
            left.add(pas);
            pas.setFont(f);
            
            //setconfpas
            confpas = new JLabel("<html><pre>CONFIRM PASSWORD :</pre><html>");
            left.add(confpas);
            confpas.setFont(f);
            
            
        //setright
        right = new JPanel(new GridLayout(6,0));
        center.add(right,BorderLayout.CENTER);
        
            //setinputusername
            name = new JTextField();
            right.add(name);
            
            //setinputpassword
            pass = new JPasswordField();
            right.add(pass);
            
            //setinputconfirmpassword
            confpass = new JPasswordField();
            right.add(confpass);
        
        //setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String uname = name.getText();
        char[] dum = pass.getPassword();
        char[] dum1 = confpass.getPassword();
        
        String password = new String(dum);
        String confirmpassword = new String(dum1);
        
        if(ae.getSource()==cancel){
            dispose();
            CourierServiceSystem.adminpage.setVisible(true);
        }
        else if(ae.getSource()==confirm){
            
            if(uname.equals("")||password.equals("")||confirmpassword.equals("")){
                JOptionPane.showMessageDialog(this, "All Data Must Be Provided!");
            }
            
            else{
                boolean found = false;

                found = CourierServiceSystem.staffusername.contains(uname);

                if(found){
                    JOptionPane.showMessageDialog(this,"USERNAME HAS BEEN USED");
                    name.setText("");
                    pass.setText("");
                    confpass.setText("");
                }

                else if(password.equals(confirmpassword)){
                    CourierServiceSystem.adminstaff.x.setUsername(uname);
                    CourierServiceSystem.adminstaff.x.setPassword(password);
                    CourierServiceSystem.adminstaff.x.setStatus("0");
                    CourierServiceSystem.allstaff.add(CourierServiceSystem.adminstaff.x);


                    updatestaff.updatetxt();
                    name.setText("");
                    pass.setText("");
                    confpass.setText("");
                    
                    CourierServiceSystem.adminpage.setVisible(true);
                    dispose();


                }
                else{
                    JOptionPane.showMessageDialog(this,"PASSWORD DOES NOT MATCH");
                    pass.setText("");
                    confpass.setText("");
                }         

            }
        }
    }
    
    
    
}
