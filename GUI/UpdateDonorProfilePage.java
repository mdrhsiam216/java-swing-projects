package GUI;
import javax.swing.*;

import Entity.*;
import EntityList.*;
import File.DonorFileIO;

import java.awt.*;
import java.awt.event.*;

public class UpdateDonorProfilePage extends JFrame implements ActionListener{

    JLabel label;
    JTextField UsernameField, NameField, contactNumberField, emailField, areaNameField, zipCodeField, bloodGroupField, rhFactorField;
    JPasswordField passwordField;
    JButton updateBtn ,BackBtn;

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    AdminPage adminPage;

    public UpdateDonorProfilePage(AdminPage adminPage){

        super("Create Donor Page");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.adminPage=adminPage;

        label=new JLabel("Username");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,50,500,100);
        this.add(label);

        UsernameField=new JTextField();
        UsernameField.setFont(textArial20);
        UsernameField.setBounds(350,80,200,40);
        this.add(UsernameField);

        label=new JLabel("Name");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,100,500,100);
        this.add(label);

        NameField=new JTextField();
        NameField.setFont(textArial20);
        NameField.setBounds(350,130,200,40);
        this.add(NameField);

        label=new JLabel("Contact Number");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,150,500,100);
        this.add(label);

        contactNumberField=new JTextField();
        contactNumberField.setFont(textArial20);
        contactNumberField.setBounds(350,180,200,40);
        this.add(contactNumberField);

        label=new JLabel("Email");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,200,500,100);
        this.add(label);

        emailField=new JTextField();
        emailField.setFont(textArial20);
        emailField.setBounds(350,230,200,40);
        this.add(emailField);

        label=new JLabel("Area Name");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,250,500,100);
        this.add(label);

        areaNameField=new JTextField();
        areaNameField.setFont(textArial20);
        areaNameField.setBounds(350,280,200,40);
        this.add(areaNameField);

        label=new JLabel("Zip Code");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,300,500,100);
        this.add(label);

        zipCodeField=new JTextField();
        zipCodeField.setFont(textArial20);
        zipCodeField.setFont(textArial20);
        zipCodeField.setBounds(350,330,200,40);
        this.add(zipCodeField);

        label=new JLabel("Blood Group");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,350,500,100);
        this.add(label);

        bloodGroupField=new JTextField();
        bloodGroupField.setFont(textArial20);
        bloodGroupField.setBounds(350,380,200,40);
        this.add(bloodGroupField);

        label=new JLabel("RH Factor");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,400,500,100);
        this.add(label);

        rhFactorField=new JTextField();
        rhFactorField.setFont(textArial20);
        rhFactorField.setBounds(350,430,200,40);
        this.add(rhFactorField);

        label=new JLabel("Password");
        label.setFont(textArial20);
        label.setForeground(Color.BLACK);
        label.setBounds(200,450,500,100);
        this.add(label);

        passwordField=new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setFont(textArial20);
        passwordField.setFont(textArial20);
        passwordField.setBounds(350,480,200,40);
        this.add(passwordField);

        updateBtn=new JButton("Update");
        updateBtn.setFont( textArial20);
        updateBtn.setBackground(new Color(240,240,240));
        updateBtn.setBounds(950,530,200,40);
        updateBtn.addActionListener(this);
        this.add(updateBtn);


        BackBtn = new JButton("Back");
        BackBtn.setBounds(750, 530, 150, 40);
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

    public void actionPerformed(ActionEvent e){
        if(updateBtn==e.getSource()){
            
            adminPage.setVisible(true);
            this.dispose();
        }else if(BackBtn==e.getSource()){
            adminPage.setVisible(true);
            this.dispose();
        }
    }

}