package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import EntityList.ConsumableList;
import EntityList.OthersList;
import EntityList.SyrupList;
import File.FileIO;


public class Login extends JFrame implements ActionListener {

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField name;
    private JPasswordField passField;
    private JButton signup;
    private JLabel jLabel3;
    private JButton login;
    private ImageIcon icon, image;
    private JLabel background;

    public Login() {
        this.setBounds(455, 160, 750, 544);
        this.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Log in");


        jLabel1 = new JLabel("User Name");
        jLabel2 = new JLabel("Password");
        name = new JTextField("");
        passField = new JPasswordField("");
        jLabel3 = new JLabel("Login Page");
        signup = new JButton("Sign in");
        login = new JButton("Log in");
         // Icon
         icon = new ImageIcon(getClass().getResource("/Assets/icon.jpg"));
         this.setIconImage(icon.getImage());

        passField.setEchoChar('*');

        jLabel1.setBounds(140, 130, 70, 30);
        jLabel2.setBounds(150, 210, 80, 30);
        name.setBounds(230, 120, 230, 40);
        passField.setBounds(230, 210, 230, 40);
        jLabel3.setBounds(240, 30, 110, 30);
        
        signup.setBounds(130, 320, 130, 40);
        login.setBounds(330, 320, 130, 40);


        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.BLACK);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);

        //image
        image = new ImageIcon("./Assets/812_generated-removebg-preview (1).png");
		background = new JLabel();
		background.setBounds(280,50,500,357);
		background.setIcon(image);
		this.add(background);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        login.setFont(new java.awt.Font("Segoe UI", 1, 14));

        this.add(jLabel2);
        this.add(name);
        this.add(passField);
        this.add(jLabel3);
        this.add(signup);
        this.add(login);
        this.add(jLabel1);

        signup.addActionListener(this);
        login.addActionListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            this.dispose();
            new Register();
        }
        else if(e.getSource() == login){
            boolean res = FileIO.login(name.getText(), passField.getText(), "./File/users.txt");
            if(res){
                this.dispose();
                new Dashboard();
            }
        }
    }
}