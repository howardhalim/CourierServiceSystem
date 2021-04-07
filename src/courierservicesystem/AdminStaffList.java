package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminStaffList extends JFrame implements ActionListener {

    private int sz= CourierServiceSystem.allstaff.size();
    private JPanel up,down,br,bl,center;
            
    private JLabel name[]  = new JLabel[sz];
    private JLabel id[] = new JLabel[sz];
    private JLabel name2[]  = new JLabel[sz];
    private JLabel id2[] = new JLabel[sz];
    private JPanel pane[] = new JPanel[sz]; 
    private JPanel pane2[] = new JPanel[sz];
    private JPanel pane3[] = new JPanel[sz];
    
    private JButton back = new JButton();
    
    public AdminStaffList(){
        
        
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
            //setback
            back = new JButton("BACK");
            down.add(back);
            back.addActionListener(this);
        
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

            
            //setpane2
            pane2[i] = new JPanel(new GridLayout(2,0));
            pane[i].add(pane2[i],BorderLayout.WEST);
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
            
        }
        
        
        
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==back){
            
            CourierServiceSystem.adminstaff.setVisible(true);
            
            dispose();
        }
        
        
    }
    
}
