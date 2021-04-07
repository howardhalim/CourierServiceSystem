package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminStaff extends JFrame implements ActionListener {

    public AdminStaffList adminstafflist;
    public AdminStaffSearch adminstaffsearch;
    
    private JPanel center,up,down,br,bl,firstpanel,secondpanel,thirdpanel,fourthpanel,dummypanel;
    private JButton add,delete,update,search,stafflist,back;
    private JLabel header,dummy;
    public staff x;
    public AddStaff addstaff;
    
    public AdminStaff(){
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
            header = new JLabel("STAFF");
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
        stafflist = new JButton("LIST");
        center.add(stafflist);
        stafflist.addActionListener(this);
        
        
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
            
            addstaff = new AddStaff();
            addstaff.setVisible(true);
            setVisible(false);
            //addstaff.dispose();
            
        }
        else if(ae.getSource()==search){
            
            adminstaffsearch = new AdminStaffSearch();
            adminstaffsearch.setVisible(true);
            setVisible(false);
            
            
            
            
//            String searchname;
//            searchname = JOptionPane.showInputDialog("Search by Name: ");
//            for(int i=0;i<CourierServiceSystem.allstaff.size();i++){
//                staff x = CourierServiceSystem.allstaff.get(i);
//                
//                if(x.getName().equals(searchname)){
//                    JOptionPane.showMessageDialog(this, "NAME: "+x.getName()+"\nID: "+x.getId());
//                }
//                
//            }
        }
        else if(ae.getSource() == stafflist){
            adminstafflist = new AdminStaffList();
            adminstafflist.setVisible(true);
            setVisible(false);
        }
    }
    
}
