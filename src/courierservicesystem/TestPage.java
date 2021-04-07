package courierservicesystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class TestPage extends JFrame implements ActionListener{
    private JButton Admin,Customer;
    public TestPage(){
        setSize(500,250);
        setLocation(800,350);
        setLayout(new GridLayout(1,2));
        getContentPane().setBackground(Color.RED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,18);
        Admin = new JButton("Admin");
        Admin.setBackground(Color.yellow);
        Admin.addActionListener(this);
        Customer = new JButton("Customer");
        Customer.addActionListener(this);
        Admin.setFont(f);
        Customer.setFont(f);
        add(Admin);
        add(Customer);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource() == Admin){
//            setVisible(false);
//        }
//        else if(ae.getSource() == Customer){
//            setVisible(false);
//        }
    }
}
