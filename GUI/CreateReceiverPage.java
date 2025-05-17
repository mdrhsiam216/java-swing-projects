package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;

import File.*;

public class CreateReceiverPage extends JFrame implements ActionListener{

    JLabel label;
    JTextField UsernameField, NameField, contactNumberField, emailField, areaNameField, zipCodeField, bloodTypeField;
    JPasswordField passwordField;
    JButton registerBtn ,BackBtn;

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    LoginPage loginPage;
    RegisterPage registerPage;

    public CreateReceiverPage(LoginPage loginPage, RegisterPage registerPage){
        super("Create Receiver Page");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.loginPage=loginPage;
        this.registerPage=registerPage;

        label=new JLabel("Username");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,50,500,100);
        this.add(label);

        UsernameField=new JTextField();
        UsernameField.setFont(textArial20);
        UsernameField.setBounds(360,80,200,40);
        this.add(UsernameField);

        label=new JLabel("Name");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,100,500,100);
        this.add(label);

        NameField=new JTextField();
        NameField.setFont(textArial20);
        NameField.setBounds(360,130,200,40);
        this.add(NameField);

        label=new JLabel("Contact Number");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,150,500,100);
        this.add(label);

        contactNumberField=new JTextField();
        contactNumberField.setFont(textArial20);
        contactNumberField.setBounds(360,180,200,40);
        this.add(contactNumberField);

        label=new JLabel("Email");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,200,500,100);
        this.add(label);

        emailField=new JTextField();
        emailField.setFont(textArial20);
        emailField.setBounds(360,230,200,40);
        this.add(emailField);

        label=new JLabel("Area Name");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,250,500,100);
        this.add(label);

        areaNameField=new JTextField();
        areaNameField.setFont(textArial20);
        areaNameField.setBounds(360,280,200,40);
        this.add(areaNameField);

        label=new JLabel("Zip Code");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,300,500,100);
        this.add(label);

        zipCodeField=new JTextField();
        zipCodeField.setFont(textArial20);
        zipCodeField.setBounds(360,330,200,40);
        this.add(zipCodeField);

        label=new JLabel("Blood Needed");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,360,500,100);
        this.add(label);

        bloodTypeField=new JTextField();
        bloodTypeField.setFont(textArial20);
        bloodTypeField.setBounds(360,380,200,40);
        this.add(bloodTypeField);

        label=new JLabel("Password");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,450,500,100);
        this.add(label);

        passwordField=new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setFont(textArial20);
        passwordField.setBounds(360,480,200,40);
        this.add(passwordField);

        registerBtn=new JButton("Register");
        registerBtn.setFont(textArial20);
        registerBtn.setBackground(new Color(240,240,240));
        registerBtn.setBounds(950,590,200,40);
        registerBtn.addActionListener(this);
        this.add(registerBtn);

        BackBtn = new JButton("Back");
        BackBtn.setBounds(750, 590, 150, 40);
        BackBtn.setFont(textArial25);
        BackBtn.setBackground(Color.GRAY);
        BackBtn.setForeground(Color.WHITE);
        BackBtn.addActionListener(this);
        this.add(BackBtn);

        //Load Frame Icon
        ImageIcon frameIcon = new ImageIcon("./GUI/Resources/icon.jpg");
        this.setIconImage(frameIcon.getImage());

        this.setVisible(true);
    }

    // public static void main(String [] args){
    //     CreateReceiverPage createReceiverPage=new CreateReceiverPage();
    // }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==registerBtn){
            String pass=String.valueOf(passwordField.getPassword());
            Receiver r=new Receiver(UsernameField.getText(), NameField.getText(), contactNumberField.getText(),
                            emailField.getText(), areaNameField.getText(), zipCodeField.getText(), bloodTypeField.getText(), pass);
            ReceiverFileIO.registerReceiver(r);
            loginPage.setVisible(true);
            this.dispose();
        }else if(e.getSource()==BackBtn){
            registerPage.setVisible(true);
            this.dispose();
        }
    }

}