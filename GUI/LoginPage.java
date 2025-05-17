package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;

import File.*;

public class LoginPage extends JFrame implements ActionListener{

    JLabel userNameText, userPassText;
    JTextField userName;
    JPasswordField password;
    JButton signinDonorBtn, signinReceiverBtn, signinAdminBtn, SignupBtn, BackBtn;

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    HomePage homePage;

    public LoginPage(HomePage homePage){

        super("Login Page");
        // this.setSize(440, 330);
        // this.setLocation(440, 250);
        this.setSize(1280,720);
        this.setLocation(30, 15);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Connected Pages
        this.homePage=homePage;

        // Load Login User Icon
		ImageIcon loginUser = new ImageIcon("./GUI/Resources/loginUser.png");
		JLabel loginUserIcon = new JLabel(loginUser);
		loginUserIcon.setBounds(622,300,32,32);
		this.add(loginUserIcon);

        //User Name Lable
        userNameText = new JLabel("Username");
        userNameText.setBounds(670, 300, 100, 30);
        userNameText.setFont(textArial20);
        this.add(userNameText);

        //User Name TextField
        userName = new JTextField();
        userName.setBounds(790, 300, 240, 30);
        userName.setFont(textArial20);
        this.add(userName);

        // Load Login Password Icon
		ImageIcon loginPassword = new ImageIcon("./GUI/Resources/loginPassword.png");
		JLabel loginPasswordIcon = new JLabel(loginPassword);
		loginPasswordIcon.setBounds(622,345,32,32);
		this.add(loginPasswordIcon);

        //User Password Label 
        userPassText = new JLabel("Password");
        userPassText.setBounds(670, 345, 100, 30);
        userPassText.setFont(textArial20);
        this.add(userPassText);

        //User Password Password Field
        password = new JPasswordField();
        password.setBounds(790, 345, 240, 30);
        password.setEchoChar('*');
        password.setFont(textArial20);
        this.add(password);

        // Sign in

        signinReceiverBtn = new JButton("Sign in as Receiver");
        signinReceiverBtn.setBounds(800, 410, 220, 32);
        signinReceiverBtn.setFont(textArial20);
        signinReceiverBtn.setBackground(Color.RED);
        signinReceiverBtn.setForeground(Color.WHITE);
        signinReceiverBtn.addActionListener(this);
        this.add(signinReceiverBtn);

        signinDonorBtn = new JButton("Sign in as Donor");
        signinDonorBtn.setBounds(800, 450, 220, 32);
        signinDonorBtn.setFont(textArial20);
        signinDonorBtn.setBackground(Color.RED);
        signinDonorBtn.setForeground(Color.WHITE);
        signinDonorBtn.addActionListener(this);
        this.add(signinDonorBtn);

        signinAdminBtn = new JButton("Sign in as Admin");
        signinAdminBtn.setBounds(800, 490, 220, 32);
        signinAdminBtn.setFont(textArial20);
        signinAdminBtn.setBackground(Color.RED);
        signinAdminBtn.setForeground(Color.WHITE);
        signinAdminBtn.addActionListener(this);
        this.add(signinAdminBtn);

        // Create Account/ Sign up
        SignupBtn = new JButton("Create New Account");
        SignupBtn.setBounds(800, 550, 220, 32);
        SignupBtn.setFont(textArial20);
        SignupBtn.setBackground(Color.RED);
        SignupBtn.setForeground(Color.WHITE);
        SignupBtn.addActionListener(this);
        this.add(SignupBtn);

        // Back
        BackBtn = new JButton("Back");
        BackBtn.setBounds(635, 550, 120, 32);
        BackBtn.setFont(textArial20);
        BackBtn.setBackground(Color.GRAY);
        BackBtn.setForeground(Color.WHITE);
        BackBtn.addActionListener(this);
        this.add(BackBtn);

        //Load Frame Icon
        ImageIcon frameIcon = new ImageIcon("./GUI/Resources/login.png");
        this.setIconImage(frameIcon.getImage());

        // Load Background Image
		ImageIcon homeBg = new ImageIcon("./GUI/Resources/loginBg.jpg");
		JLabel homeBackground = new JLabel(homeBg);
		homeBackground.setBounds(0,0,1280,720);
        // this.getContentPane().setBackground(Color.RED);
		this.add(homeBackground);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(signinAdminBtn == e.getSource()){
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
            // System.out.println(userName.getText());
            // System.out.println(String.valueOf(password.getPassword()));
            if(AdminFileIO.checkAdminUser(name, pass)){
            // if(name.equals("admin") && pass.equals("admin")){
                JOptionPane.showMessageDialog(this, "Login Successfull");
                // List users = new List(100);
                DonorList donorList=new DonorList(111);
                ReceiverFileIO.loadDonor(donorList);
                ReceiverList receiverList=new ReceiverList(111);
                DonorFileIO.loadReceiver(receiverList);
                AdminPage adminPage= new AdminPage(this, donorList, receiverList);
                userName.setText("");
                password.setText("");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(signinDonorBtn == e.getSource()){
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
            // System.out.println(userName.getText());
            // System.out.println(String.valueOf(password.getPassword()));
            if(DonorFileIO.checkDonorUser(name, pass)){
            // if(name.equals("admin") && pass.equals("admin")){
                JOptionPane.showMessageDialog(this, "Login Successfull");
                ReceiverList receiverList=new ReceiverList(111);
                DonorFileIO.loadReceiver(receiverList);
                DonorPage donorPage=new DonorPage(this, receiverList);
                userName.setText("");
                password.setText("");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(signinReceiverBtn == e.getSource()){
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
            // System.out.println(userName.getText());
            // System.out.println(String.valueOf(password.getPassword()));
            if(ReceiverFileIO.checkReceiverUser(name, pass)){
            // if(name.equals("admin") && pass.equals("admin")){
                JOptionPane.showMessageDialog(this, "Login Successfull");
                DonorList donorList=new DonorList(111);
                ReceiverFileIO.loadDonor(donorList);
                ReceiverList receiverList=new ReceiverList(111);
                DonorFileIO.loadReceiver(receiverList);
                ReceiverPage receiverPage= new ReceiverPage(this, donorList, receiverList, name);
                userName.setText("");
                password.setText("");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(SignupBtn == e.getSource()){
            RegisterPage registerPage=new RegisterPage(this);
            this.setVisible(false);
        }else if(BackBtn == e.getSource()){
            homePage.setVisible(true);
            this.dispose();
        }
    }
}
