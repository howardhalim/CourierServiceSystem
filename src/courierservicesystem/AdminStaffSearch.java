package courierservicesystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminStaffSearch extends JFrame implements ActionListener {

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
    private JButton back,edit,delete, search,view;
    
    staff me;
    public AdminStaffSearchEdit ASSE;
    public AdminStaffSearchBar ASSB;
    public AdminStaffSearchView ASSV;
    public AdminStaffSearch(){
        
        
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
        up = new JPanel(new BorderLayout());
        add(up,BorderLayout.NORTH);
        up.setBackground(Color.LIGHT_GRAY);
            //set search bar
            search = new JButton("Search");
            up.add(search,BorderLayout.EAST);
            search.addActionListener(this);
        
        //set-down
        down = new JPanel();
        add(down,BorderLayout.SOUTH);
        down.setBackground(Color.LIGHT_GRAY);
            //setback
            back = new JButton("BACK");
            down.add(back);
            back.addActionListener(this);
            edit = new JButton("EDIT");
            down.add(edit);
            edit.addActionListener(this);
            delete = new JButton("DELETE");
            down.add(delete);
            delete.addActionListener(this);
            view  = new JButton("VIEW");
            view.addActionListener(this);
            down.add(view);
        
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
            
        }
        
        
        
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean found = false;
        for(int i=0;i<sz;i++){
            if(check[i].isSelected()){
                me = CourierServiceSystem.allstaff.get(i);
                found = true;
                break;
            }
        }
        
        if(ae.getSource()==back){
            CourierServiceSystem.adminstaff.setVisible(true);
            dispose();
        }
        else if(ae.getSource() == search){
            try{
                String x = JOptionPane.showInputDialog(this,"Name: ");
                ASSB = new AdminStaffSearchBar(x);
                ASSB.setVisible(true);
                dispose();
            }catch(Exception ex){
                
            }
        }
        else if(!found){
            JOptionPane.showMessageDialog(this,"Please Select a Staff!");
        }
        
        else if(ae.getSource() == edit){
            ASSE = new AdminStaffSearchEdit(me);
            ASSE.setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource() == delete){
            int res = JOptionPane.showConfirmDialog(this,"Are You Sure?");
            if(res == JOptionPane.YES_OPTION){
                CourierServiceSystem.allstaff.remove(me);
                updatestaff.updatetxt();
            }
            dispose();
            CourierServiceSystem.adminstaff.setVisible(true);
        }
        
        else if(ae.getSource()==view){
            ASSV = new AdminStaffSearchView(me);
            ASSV.setVisible(true);
            dispose();
        }
    }
    
}
