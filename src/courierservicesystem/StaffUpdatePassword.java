package courierservicesystem;
    import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class StaffUpdatePassword extends JFrame implements ActionListener {

    private JLabel username,pas,header,confpas,newpas;
    private JPanel left,right,up,down,center,br,bl;
    private JTextField name;
    private JPasswordField pass,confpass,newpass;
    private JButton confirm,cancel;
    
    private staff me;
    
    public StaffUpdatePassword(staff me){
        this.me = me;
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
            //setconfirmbutton
            confirm = new JButton("CONFIRM");
            down.add(confirm);
            confirm.addActionListener(this);
            //setcancel
            cancel = new JButton("CANCEL");
            down.add(cancel);
            cancel.addActionListener(this);
       
       
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
            username = new JLabel("<html><pre>USERNAME              :</pre><html>");
            left.add(username);
            username.setFont(f);
            
            //setpas
            pas = new JLabel("<html><pre>OLD PASSWORD          :</pre><html>");
            left.add(pas);
            pas.setFont(f);
            
            //setnewpas
            newpas = new JLabel("<html><pre>NEW PASSWORD          :</pre><html>");
            left.add(newpas);
            newpas.setFont(f);
            
            //setconfpas
            confpas = new JLabel("<html><pre>CONFIRM NEW PASSWORD  :</pre><html>");
            left.add(confpas);
            confpas.setFont(f);
            
            
        //setright
        right = new JPanel(new GridLayout(6,0));
        center.add(right,BorderLayout.CENTER);
        
            //setinputusername
            name = new JTextField(me.getUsername());
            name.setEnabled(false);
            right.add(name);
            
            //setinputpassword
            pass = new JPasswordField();
            right.add(pass);
            
            //setnewpassword
            newpass = new JPasswordField();
            right.add(newpass);
            
            //setinputconfirmpassword
            confpass = new JPasswordField();
            right.add(confpass);
        
        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String oldpass,nwpass,cnfpass;
       char[] old,nw,conf;
       old = pass.getPassword();
       nw = newpass.getPassword();
       conf = confpass.getPassword();
       
       oldpass = new String(old);
       nwpass = new String(nw);
       cnfpass = new String(conf);
       if(ae.getSource()==cancel){
           dispose();
           CourierServiceSystem.loginpage.staffpage.setVisible(true);
       }
       if(ae.getSource()==confirm){
           if(oldpass.equals("")||nwpass.equals("")||cnfpass.equals("")){
               JOptionPane.showMessageDialog(this, "All Data Must Be Provided!");
           }
           else{
                if(!oldpass.equals( me.getPassword())){
                    JOptionPane.showMessageDialog(this,"WRONG OLD PASSWORD!");
                    pass.setText("");
                    newpass.setText("");
                    confpass.setText("");
                }
                else if(nwpass.equals(cnfpass)){
                    me.setPassword(nwpass);
                    updatestaff.updatetxt();
                    CourierServiceSystem.loginpage.staffpage.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"PASSWORD IS NOT MATCH!");
                    pass.setText("");
                    newpass.setText("");
                    confpass.setText("");
                }
           }
           
       }
    }
}
