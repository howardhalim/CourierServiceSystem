package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class loginpage extends JFrame implements ActionListener{
    private JLabel username,pas,header;
    private JPanel left,right,up,down;
    private JTextField name;
    private JPasswordField pass;
    private JButton login,cancel;
    public static StaffPage staffpage;
    public staff me;
    
    public loginpage(){
        
        //setJFrame
        setSize(500,250);
        setLocation(800,350);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,18);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setloginscreen
        left = new JPanel(new GridLayout(6,0));
        add(left,BorderLayout.WEST);
        left.setBackground(Color.white);
        
        right = new JPanel(new GridLayout(6,0));
        add(right,BorderLayout.CENTER);
        right.setBackground(Color.white);

        up = new JPanel();
        add(up,BorderLayout.NORTH);
        up.setBackground(Color.ORANGE);
        
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
        down.setBackground(Color.white);
        
        
        
        //set Header
        header = new JLabel("LOGIN PAGE");
        header.setFont(f);
        up.add(header);
        
        //setusername
        username = new JLabel("<html> <pre>Username   :</pre><html>");
        left.add(username);
        
        //setpas
        pas = new JLabel("<html><pre>Password   :</pre><html>");
        left.add(pas);
        
        
        //setinputname
        name = new JTextField();
        right.add(name);
        
        //setinputpass
        pass = new JPasswordField();
        right.add(pass);
        
        
        //setloginbutton
        login = new JButton("Submit");
        login.addActionListener(this);
        down.add(login);
        //setcancelbutton
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        down.add(cancel);
        
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==cancel){
            name.setText("");
            pass.setText("");
            setVisible(false);
            CourierServiceSystem.homepage.setVisible(true);
        }
        
        String uname = name.getText();
        char[] tpass =  pass.getPassword();
        String password = new String(tpass);
        
        if(ae.getSource() == login){
            if(uname.equals("admin") && password.equals("admin")){
                setVisible(false);
                CourierServiceSystem.adminpage.setVisible(true);
            }
            else{
                boolean found = false;
                
                for(int i = 0;i<CourierServiceSystem.allstaff.size();i++){
                    staff x = CourierServiceSystem.allstaff.get(i);
                    
                    String staffname,staffpass;
                    staffname = x.getUsername();
                    staffpass = x.getPassword();
                    
                    if(staffname.equals(uname) && staffpass.equals(password)){
                        me = x;
                        found = true;
                        break;
                    }
                    
                    
                }
                if(found){
                    setVisible(false);
                    staffpage = new StaffPage(me);
                    staffpage.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "USERNAME OR PASSWORD NOT FOUND!");
                }
                
               
            }
            name.setText("");
            pass.setText("");
            
        }
    }
    
}
