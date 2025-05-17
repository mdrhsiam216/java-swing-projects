package GUI;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import File.FileIO;

public class Register extends JFrame implements ActionListener{
    private JLabel regLabel, nameLabel, addressLabel, contLabel, passLabel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField contField;
    private JPasswordField passField;
    private JButton backBtn;
    private JButton regBtn;
    private ImageIcon icon, image;
    private JLabel background;

    public Register(){
        this.setBounds(350,100,784,682);
        setTitle("Antenna");
        this.setTitle("Register");

        regLabel = new JLabel();
        nameLabel = new JLabel();
        addressLabel = new JLabel();
        contLabel = new JLabel();
        passLabel = new JLabel();
        nameField = new JTextField();
        addressField = new JTextField();
        contField = new JTextField();
        passField = new JPasswordField();
        backBtn = new JButton();
        backBtn.setBackground(Color.RED);
        regBtn = new JButton();
        regBtn.setBackground(Color.ORANGE);

        nameLabel.setText("Name");
        addressLabel.setText("address");
        contLabel.setText("Contact Number");
        passLabel.setText("Password");
        backBtn.setText("Back");
        regBtn.setText("Register");
        regLabel.setText("Register");

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/icon.jpg"));
        this.setIconImage(icon.getImage());

        this.setLayout(null);

        regLabel.setFont(new java.awt.Font("Segoe UI", 1, 20));
        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));        
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        regBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        contLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        passLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        nameField.setBounds(330, 170, 190, 40);
        addressField.setBounds(330, 220, 190, 40);
        contField.setBounds(330, 270, 190, 40);
        passField.setBounds(330, 320, 190, 40);

        backBtn.setBounds(420, 490, 100, 40);
        regBtn.setBounds(220, 490, 100, 40);

        contLabel.setBounds(270, 280, 60, 30);
        passLabel.setBounds(210, 330, 110, 30);
        nameLabel.setBounds(280, 180, 60, 20);
        regLabel.setBounds(380, 70, 80, 40);
        addressLabel.setBounds(290, 230, 40, 20);

        this.add(nameField);
        this.add(nameLabel);
        this.add(addressField);
        this.add(passLabel);
        this.add(regLabel);
        this.add(contLabel);
        this.add(addressLabel);
        this.add(contField);
        this.add(passField);
        this.add(regBtn);
        this.add(backBtn);

        backBtn.addActionListener(this);
        regBtn.addActionListener(this);

        // Image
        image = new ImageIcon("./Assets/top-view-medical-desk-arrangement-with-copy-space_23-2148502984 (1).jpg");
        background = new JLabel();
        background.setBounds(0, 0, 784, 682);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            this.dispose();
            Login l = new Login();
        }
        else if (e.getSource() == regBtn){
            String name = nameField.getText();
            String address = addressField.getText();
            String contact = contField.getText();
            String password = String.valueOf(passField.getPassword());

            if (name.isEmpty() || address.isEmpty() || contact.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill up all data", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                String data = name + ';' + address + ';' + contact + ';' + password;
                FileIO.writeInFile(data, "./File/users.txt", true);
                JOptionPane.showMessageDialog(this, "User registered", "Success", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    public static void main(String[] args) {
        Register r = new Register();
    }
}
