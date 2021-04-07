
package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CustomerRatingAndFeedbackChoose extends JFrame implements ActionListener{
    
    private int sz;
    private JPanel up,down,br,bl,center;
            
    private JLabel name[];
    private JLabel id[];
    private JLabel name2[];
    private JLabel id2[];
    private JPanel pane[]; 
    private JPanel pane2[];
    private JPanel pane3[];
    private JPanel left[];
    private JRadioButton check[];
    private ButtonGroup G = new ButtonGroup();
    private JButton back,confirm;
    customer cusme;
    private ArrayList<order> selectedorder = new ArrayList<order>();
    order me;
    public CustomerPage customerpage;
    public CustomerRatingAndFeedback CRAF;
    public CustomerRatingAndFeedbackChoose(ArrayList<order> x,customer z){
        selectedorder = x;
        cusme=z;
        
        sz = selectedorder.size();
        name = new JLabel[sz];
        id = new JLabel[sz];
        name2 =new JLabel[sz];
        id2 = new JLabel[sz];
        pane = new JPanel[sz];
        pane2 = new JPanel[sz];
        pane3 = new JPanel[sz];
        left = new JPanel[sz];
        check = new JRadioButton[sz];
        
        
        
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
            back = new JButton("CANCEL");
            down.add(back);
            back.addActionListener(this);
            confirm = new JButton("CONFIRM");
            down.add(confirm);
            confirm.addActionListener(this);
        
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
            
            order y = selectedorder.get(i);
            name[i] = new JLabel(y.getAssignstaff().getName());
            name[i].setFont(f);
            //name[i].setText(x.getName());
            id[i] = new JLabel(y.getOrderId());
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
                me = selectedorder.get(i);
                found = true;
                break;
            }
        }
        if(ae.getSource()==back){
            customerpage = new CustomerPage(cusme);
            customerpage.setVisible(true);
            dispose();
        }
        else if(ae.getSource()==confirm && found){
            CRAF = new CustomerRatingAndFeedback(cusme,me);
            CRAF.setVisible(true);
            dispose();
        }
        else if (!found){
            JOptionPane.showMessageDialog(this,"Please Choose an Order!");
        }

    }
    
}
