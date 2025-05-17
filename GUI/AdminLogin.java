package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import File.FileIO;

public class AdminLogin extends JFrame implements ActionListener {

    private JLabel userNameLabel;
    private JLabel passLabel;
    private JTextField userNameField;
    private JPasswordField passField;
    private JLabel adminLogPageLabel;
    private JButton cancelBtn,logInBtn;
    private ImageIcon icon, image1;
    private JLabel background;
    private Font f1,f2;


    public AdminLogin() {
        this.setSize( 750, 544);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Log in");

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        userNameLabel = new JLabel("User Name");
        passLabel = new JLabel("Password");
        userNameField = new JTextField();
        passField = new JPasswordField();
        adminLogPageLabel = new JLabel("Admin Login Page");
        logInBtn = new JButton("Log in");
        cancelBtn = new JButton("Back");

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        passField.setEchoChar('*');

        userNameLabel.setBounds(40, 130, 80, 30);
        passLabel.setBounds(40, 210, 80, 30);
        userNameField.setBounds(140, 120, 200, 40);
        passField.setBounds(140, 210, 200, 40);
        adminLogPageLabel.setBounds(140, 30, 180, 30);
        cancelBtn.setBounds(240, 320, 130, 40);
        logInBtn.setBounds(60, 320, 130, 40);

        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setForeground(Color.BLACK);
        logInBtn.setBackground(Color.WHITE);
        logInBtn.setForeground(Color.BLACK);

        //image1
        image1 = new ImageIcon("./Assets/812_generated-removebg-preview (1).png");
		background = new JLabel();
		background.setBounds(300,50,500,357);
		background.setIcon(image1);
		this.add(background);

		background = new JLabel();
		background.setBounds(400,400,50,50);
		this.add(background);


        userNameLabel.setFont(f2);
        passLabel.setFont(f2); 
        adminLogPageLabel.setFont(f1);
        logInBtn.setFont(f2); 
        cancelBtn.setFont(f2);
        this.add(passLabel);
        this.add(userNameField);
        this.add(passField);
        this.add(adminLogPageLabel);
        this.add(logInBtn);
        this.add(userNameLabel);
        this.add(cancelBtn);

        logInBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInBtn) {
            String userName = userNameField.getText().toString();
            String password = String.valueOf(passField.getPassword());

            System.out.println("getting value "+FileIO.checkAdmin(userName, password,"./File/admin.txt"));

            if (!userName.isEmpty() && !password.isEmpty()) {
                if (FileIO.checkAdmin(userName, password,"./File/admin.txt") == 1) {
                    ImageIcon icon = new ImageIcon("./Assets/gettyimages-182436004-612x612-removebg-preview (1).png");
                    JLabel label = new JLabel("Login Successful", icon, JLabel.CENTER);
                    JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                    AdminDashboard d= new AdminDashboard(userNameField.getText());

                }
                else {
                    JOptionPane.showMessageDialog(this, "incorrect password",
                            "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "fill up all data",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource()==cancelBtn){
            this.dispose();
            Login l = new Login();
        }
    }
}