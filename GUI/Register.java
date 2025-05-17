package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import Entity.Patient;
import EntityList.PatientList;
import File.FileIO;

public class Register extends JFrame implements ActionListener{
    private JLabel regLabel,nameLabel,fNameLabel,mNameLabel,ageLabel,genderLabel,contLabel,emailLabel,passLabel;

    private JTextField nameField,fnameField,mnameField,ageField,genderField,contField, emailField;

    private JPasswordField passField;
    private JButton backBtn;
    private JButton regBtn;
    private ImageIcon icon, image;
    private JLabel background;
    private Font f1,f2;

    public Register(){
        this.setSize(784,682);
        this.setLocationRelativeTo(null);
        this.setTitle("Register");

        regLabel = new JLabel();
        nameLabel = new JLabel();
        fNameLabel = new JLabel();
        mNameLabel = new JLabel();
        ageLabel = new JLabel();
        genderLabel = new JLabel();
        contLabel = new JLabel();
        emailLabel = new JLabel();
        passLabel = new JLabel();
        nameField = new JTextField();
        fnameField = new JTextField();
        mnameField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();
        contField = new JTextField();
        emailField = new JTextField();
        passField = new JPasswordField();
        backBtn = new JButton();
        backBtn.setBackground(Color.RED);
        regBtn = new JButton();
        regBtn.setBackground(Color.ORANGE);

        nameLabel.setText("Name");
        fNameLabel.setText("Father's Name");
        mNameLabel.setText("Mother's Name");
        ageLabel.setText("Age");
        genderLabel.setText("Gender");
        contLabel.setText("Contact Number");
        emailLabel.setText("Email Id");
        passLabel.setText("Password");
        backBtn.setText("Back");
        regBtn.setText("Register");
        regLabel.setText("Register");

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        f1 = new Font("Segoe UI Black", Font.BOLD, 20);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        this.setLayout(null);

        regLabel.setFont(f1); 
        regLabel.setBounds(330, 10, 100, 40);
        nameLabel.setFont(f2);
        nameLabel.setBounds(280, 80, 60, 20);
        fNameLabel.setFont(f2);
        fNameLabel.setBounds(220, 130, 110, 20);
        mNameLabel.setBounds(220, 170, 110, 30);
        ageLabel.setBounds(290, 230, 40, 20);
        mNameLabel.setFont(f2);
        backBtn.setFont(f2); 
        regBtn.setFont(f2); 
        ageLabel.setFont(f2); 
        genderLabel.setFont(f2);
        emailLabel.setFont(f2); 
        contLabel.setFont(f2); 
        passLabel.setFont(f2); 
        
       
        
        genderLabel.setBounds(270, 280, 60, 30);
        genderField.setBounds(330, 270, 190, 40);
        contField.setBounds(330, 320, 190, 40);
        emailField.setBounds(330, 370, 190, 40);
        passField.setBounds(330, 420, 190, 40);
        backBtn.setBounds(420, 490, 100, 40);
        regBtn.setBounds(220, 490, 100, 40);
        contLabel.setBounds(200, 330, 120, 30);
        emailLabel.setBounds(260, 370, 60, 40);
        passLabel.setBounds(250, 430, 80, 20);
        nameField.setBounds(330, 70, 190, 40);
        fnameField.setBounds(330, 120, 190, 40);
        mnameField.setBounds(330, 170, 190, 40);
        ageField.setBounds(330, 220, 190, 40);
        
        this.add(nameField);
        this.add(nameLabel);
        this.add(ageField);
        this.add(emailLabel);
        this.add(fnameField);
        this.add(fNameLabel);
        this.add(mnameField);
        this.add(passLabel);
        this.add(mNameLabel);
        this.add(regLabel);
        this.add(contLabel);
        this.add(genderField);
        this.add(ageLabel);
        this.add(contField);
        this.add(genderLabel);
        this.add(emailField);
        this.add(passField);
        this.add(regBtn);
        this.add(backBtn);

        backBtn.addActionListener(this);
        regBtn.addActionListener(this);

         //image
         image = new ImageIcon("./Assets/top-view-medical-desk-arrangement-with-copy-space_23-2148502984 (1).jpg");
         background = new JLabel();
         background.setBounds(0,0,784,682);
         background.setIcon(image);
         this.add(background);

        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            this.dispose();
            Login l= new Login();
        }
        else if(e.getSource()==regBtn){
            String name= nameField.getText();
            String fName= fnameField.getText();
            String mName= mnameField.getText();
            String strAge = ageField.getText();
            String gender = genderField.getText();
            String email= emailField.getText();
            String contact = contField.getText();
            String password= String.valueOf(passField.getPassword());

            if(name.isEmpty() || fName.isEmpty() || mName.isEmpty()|| ageField.getText().isEmpty() || email.isEmpty()|| gender.isEmpty() || password.isEmpty()) {
                //option pane message
                JOptionPane.showMessageDialog(this, "fill up all data", 
											  "Error",JOptionPane.WARNING_MESSAGE);
            }
            else{
                // writeInFile(String line,String fname,boolean append)
                String s= name+";"+fName+';'+mName+';'+Integer.parseInt(strAge)+';'+gender+";"+email+';'+contact+';'+password;
                FileIO.writeInFile(s,"./File/patient.txt", true);
                ImageIcon icon = new ImageIcon("./Assets/gettyimages-182436004-612x612-removebg-preview (1).png");
                JLabel label = new JLabel("Register Successful", icon, JLabel.CENTER);
                JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.PLAIN_MESSAGE);
                PatientList.patientList.add(new Patient(1, name, fName, mName, Integer.parseInt(ageField.getText()), gender, contact, email));
                this.dispose();
                Login l = new Login();
            }
        }
    }
    public static void main(String[] args) {
        Register frame = new Register();
        frame.setVisible(true);
    }
}
