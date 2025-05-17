package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import File.FileIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdmin extends JFrame implements ActionListener{
    private JLabel adminSignupLabel,background;
    private JButton backBtn;
    private JLabel usernamelabel;
    private JButton addBtn;
    private JLabel passlabel;
    private JPasswordField passfield;
    private JTextField namefield;
    private ImageIcon icon,image;
    private Font f1,f2;
    private String username;

    public  AddAdmin(String username){
        this.username=username;
        adminSignupLabel = new JLabel();
        backBtn = new JButton();
        addBtn = new JButton();
        usernamelabel = new JLabel();
        passlabel = new JLabel();
        namefield = new JTextField();
        passfield = new JPasswordField();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Admin");
        setSize(871,  520);
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 23);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        adminSignupLabel.setFont(f1);
        adminSignupLabel.setText("Admin sign up");
        this.add(adminSignupLabel);
        adminSignupLabel.setBounds(360, 55, 200, 30);

        backBtn.setText("Back");
        backBtn.setFont(f2);
        backBtn.setBackground(Color.RED);
        backBtn.addActionListener(this);
        this.add(backBtn);
        backBtn.setBounds(320, 310, 100, 40);

        addBtn.setText("add admin");
        addBtn.setFont(f2);
        addBtn.setBackground(Color.ORANGE);
        addBtn.addActionListener(this);
        this.add(addBtn);
        addBtn.setBounds(470, 310, 120, 40);

        usernamelabel.setText("user name");
        usernamelabel.setFont(f2);
        this.add(usernamelabel);
        usernamelabel.setBounds(290, 170, 110, 30);

        passlabel.setText("password");
        passlabel.setFont(f2);
        this.add(passlabel);
        passlabel.setBounds(290, 240, 100, 30);

        this.add(namefield);
        namefield.setBounds(390, 170, 170, 40);

        this.add(passfield);
        passfield.setBounds(390, 230, 170, 40);

        //image
        image = new ImageIcon("./Assets/envio-42k (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,871,520);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBtn){
            this.dispose();
            AdminDashboard d= new AdminDashboard(this.username);
        }
        else if(e.getSource()==addBtn){
            if(namefield.getText().isEmpty() || passfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fields cannot be empty!");
            }
            else{
                String userName = namefield.getText();
                String password = passfield.getText();
                String line = userName+";"+password;
                FileIO.writeInFile(line,"./File/admin.txt", true);
                JOptionPane.showMessageDialog(null,"Admin added successfully.");
                this.dispose();
                AdminDashboard d=new AdminDashboard(this.username);
            }
            
        }
    }
}
