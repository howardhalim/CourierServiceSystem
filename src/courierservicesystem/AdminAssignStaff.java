package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class AdminAssignStaff extends JFrame implements ActionListener {

    private int sz= CourierServiceSystem.allstaff.size();
    private JPanel up,down,br,bl,center;
            
    private JLabel name[]  = new JLabel[sz];
    private JLabel id[] = new JLabel[sz];
    private JLabel name2[]  = new JLabel[sz];
    private JLabel id2[] = new JLabel[sz];
    private JPanel pane[] = new JPanel[sz]; 
    private JPanel pane2[] = new JPanel[sz];
    private JPanel pane3[] = new JPanel[sz];
    private JPanel left[] = new JPanel[sz];
    private JRadioButton check[] = new JRadioButton[sz];
    private ButtonGroup G = new ButtonGroup();
    private JButton confirm,edit,delete,cancel;
    
    private customer cusme;
    private staff staffme;
    private order myorder;
    public AdminAssignStaff(customer cusme,order or){
        this.cusme = cusme;
        myorder = or;
        setSize(500,900);
        setLocation(800,100);
        setTitle("COURIER SERVICE SYSTEM");
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font bold = new Font(Font.SANS_SERIF,Font.BOLD,14);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //setcenter
        center = new JPanel(new GridLayout(sz+6,0));
        add(center,BorderLayout.CENTER);
        
        //set-up
        up = new JPanel();
        add(up,BorderLayout.NORTH);
        up.setBackground(Color.LIGHT_GRAY);
        
        //set-down
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
        down.setBackground(Color.LIGHT_GRAY);
            //setconfirm
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
        br.setBackground(Color.LIGHT_GRAY);
        
        
        //setbl
        bl = new JPanel();
        add(bl,BorderLayout.WEST);
        bl.setBackground(Color.LIGHT_GRAY);
        
        for(int i=0;i<sz;i++){
            //set3panel
            pane[i] = new JPanel(new BorderLayout());
            center.add(pane[i]);          
            //set radiobutton
            left[i] = new JPanel(new BorderLayout());
            pane[i].add(left[i],BorderLayout.WEST);
            check[i] = new JRadioButton();
            left[i].add(check[i],BorderLayout.WEST);
            G.add(check[i]);
            
            //setpane2
            pane2[i] = new JPanel(new GridLayout(2,0));
            left[i].add(pane2[i],BorderLayout.CENTER);
            //setnameandid
            name2[i] = new JLabel("<html><pre>NAME    : </pre><html>");
            name2[i].setFont(f);
            id2[i] = new JLabel("<html><pre>ID      : </pre><html>");
            id2[i].setFont(f);
            pane2[i].add(name2[i]);
            pane2[i].add(id2[i]);
            
            staff x = CourierServiceSystem.allstaff.get(i);
            name[i] = new JLabel(x.getName());
            name[i].setFont(f);
            //name[i].setText(x.getName());
            id[i] = new JLabel(x.getId());
            id[i].setFont(f);
            //id[i].setText(x.getId());
            pane3[i]  = new JPanel(new GridLayout(2,0));
            //pane[i].setLayout(new GridLayout(2,0));
            pane[i].add(pane3[i],BorderLayout.CENTER);
            pane3[i].add(name[i]);
            pane3[i].add(id[i]);
            
            if(!x.getStatus().equals("0")){
                check[i].setEnabled(false);
                name[i].setEnabled(false);
                id[i].setEnabled(false);
                name2[i].setEnabled(false);
                id2[i].setEnabled(false);
            }
            
            
        }
        
        
        
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean found = false;
        for(int i=0;i<sz;i++){
            staff x = CourierServiceSystem.allstaff.get(i);
            if(check[i].isSelected()){
                staffme = x;
                x.setStatus("1");
                found = true;
                break;
            }  
        }
        if(ae.getSource()==cancel){
            CourierServiceSystem.adminpage.setVisible(true);
            dispose();
        }

        else if(ae.getSource()==confirm && found){
            int res = JOptionPane.showConfirmDialog(this,"Delivery Fee is RM 5\nDo You Want to Pay Now?"); 
            if(res == JOptionPane.YES_OPTION){
                
            
                updatestaff.updatetxt();
                
                myorder.setAssignstaff(staffme);
                myorder.setRating("");
                myorder.setFeedback("");
                myorder.setStatus("0");
                CourierServiceSystem.allorder.add(myorder);

                updateorder.updatetxt(); 
                bills x = new bills();
                x.setStatus("1");
                x.setCusname(cusme);
                x.setOrderid(myorder);
                x.setStaffname(staffme);
                CourierServiceSystem.allbills.add(x);
                updatebills.updatetxt();
                try{
                    TimeUnit.SECONDS.sleep(3);
                }
                catch(Exception ex){
                    
                }
                finally{
                    JOptionPane.showMessageDialog(this, "Bills Printed!");
                    printbills.print(myorder,0);
                }
                
            }
            else if(res == JOptionPane.CANCEL_OPTION){
                
            }
            else{
                for(int i=0;i<sz;i++){
                    staff x = CourierServiceSystem.allstaff.get(i);
                    if(check[i].isSelected()){
                        staffme = x;
                        x.setStatus("2");
                        break;
                    }  
                }
                updatestaff.updatetxt();
                
                myorder.setAssignstaff(staffme);
                myorder.setRating("");
                myorder.setFeedback("");
                myorder.setStatus("0");
                CourierServiceSystem.allorder.add(myorder);
                bills x = new bills();
                x.setStatus("0");
                x.setCusname(cusme);
                x.setOrderid(myorder);
                x.setStaffname(staffme);
                CourierServiceSystem.allbills.add(x);
                updateorder.updatetxt();
                updatebills.updatetxt();
                JOptionPane.showMessageDialog(this,"Payment Must Be Done, Then Delivery Will Be Proceeded\nPlease Proceed to Customer Page to Make The Payment");
                printbills.print(myorder,1);
            }

        
            
           CourierServiceSystem.adminpage.setVisible(true);
           dispose();
           
                
        } 
        else{
            JOptionPane.showMessageDialog(this,"Please Select a Staff!");
        }
            
    }
    
    
}
