import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//ye mera database ka class hai
public class Myframe extends JFrame implements ActionListener {

    JTextField txt_name, txt_age, txt_phone, txt_address, txt_collegeName;
    JButton button;
    String name, age, phone, address, collegeName;
    int age_data;
    long phone_data;

    public Myframe() {
        super("Student survey system");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 300);
        this.setLocation(200, 200);

        Image icon = Toolkit.getDefaultToolkit().getImage("Untitled.png");
        this.setIconImage(icon);
        Color color=new Color(117,230,218) ;
        String font_srting="Constantia";
        LayoutManager layout = new GridLayout(6, 2,-130,10);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(color);
        this.getContentPane().setForeground(Color.yellow);
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(color);
       
        JLabel label_name = new JLabel("Name");
        label_name.setFont(new Font(font_srting, Font.BOLD, 20));
        txt_name = new JTextField(35);
        txt_name.setBackground(color);
        panel.add(label_name);
        panel.add(txt_name);
        
        JLabel label_age = new JLabel("Age");
        label_age.setFont(new Font(font_srting, Font.BOLD, 20));
        txt_age = new JTextField( 2);
        txt_age.setBackground(color);

        panel.add(label_age);
        panel.add(txt_age);

        JLabel label_phone = new JLabel("Phone No");
        label_phone.setFont(new Font(font_srting, Font.BOLD, 20));
        txt_phone = new JTextField(10);
        txt_phone.setBackground(color);
        panel.add(label_phone);
        panel.add(txt_phone);

        JLabel label_address = new JLabel("Address");
        label_address.setFont(new Font(font_srting, Font.BOLD, 20));
        txt_address = new JTextField(35);
        txt_address.setBackground(color);
        panel.add(label_address);
        panel.add(txt_address);

        JLabel label_collegeName = new JLabel("College Name");
        label_collegeName.setFont(new Font(font_srting, Font.BOLD, 20));    
        txt_collegeName = new JTextField(35);
        txt_collegeName.setBackground(color);
        panel.add(label_collegeName);
        panel.add(txt_collegeName);
        
        button = new JButton("Submit");
        button.addActionListener(this);
        button.setForeground(Color.red);
        button.setBackground(new Color(80, 200, 120));
        
        this.add(panel);
        this.add(button);
        
        this.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            name = txt_name.getText();
            age = txt_age.getText();
            phone = txt_phone.getText();
            address = txt_address.getText();
            collegeName = txt_collegeName.getText();
            age_data = Integer.parseInt(age);
            phone_data = Long.parseLong(phone);
            System.out.println(name + " " + age + " " + phone + " " + address + " " + collegeName);
            MysqlCon a = new MysqlCon();
            a.mydata(name, age_data, phone_data, address, collegeName);
            System.out.println("Data is updated");
            this.button.setEnabled(false);
        }

    }
}