package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import File.FileIO;

public class Registration extends JFrame implements ActionListener {
    JLabel namelabel,passlabel;
    JTextField name;
    JPasswordField pass;
    JButton RegisterBtn,cancelBtn;
    LogIn lg;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Registration(LogIn lg){
        super("Registration page");
        this.lg = lg;
        this.setSize(500, 400);
        this.setLocation(300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/football.png").getImage());

        //Label
        namelabel = new JLabel("Enter username");
        namelabel.setBounds(30, 50, 140, 25);
        namelabel.setFont(font);
        namelabel.setForeground(Color.WHITE);
        this.add(namelabel);

        passlabel = new JLabel("Enter password");
        passlabel.setBounds(30, 100, 140, 25);
        passlabel.setFont(font);
        passlabel.setForeground(Color.WHITE);
        this.add(passlabel);

        //textfield
        name = new JTextField();
        name.setBounds(190, 50, 140, 25);
        name.setFont(font);
        this.add(name);

        pass = new JPasswordField();
        pass.setBounds(190, 100, 140, 25);
        pass.setFont(font);
        this.add(pass);

        //btn
        RegisterBtn = new JButton("Register");
        RegisterBtn.setBounds(130, 150, 120, 35);
        RegisterBtn.setFont(font);
        RegisterBtn.addActionListener(this);
        this.add(RegisterBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(280, 150, 120, 35);
        cancelBtn.setFont(font);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn); 
        
        image = new ImageIcon("./Assets/goalpost.jpg");
		background = new JLabel();
		background.setBounds(0,0,500,400);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(RegisterBtn == e.getSource()){
                FileIO.registerUser(name.getText(), String.valueOf(pass.getPassword()), "./File/users.txt");
                JOptionPane.showMessageDialog(this, "Registration successfull");
                this.setVisible(false);
        }
        else if(e.getSource()==cancelBtn){
            this.setVisible(false);
        }
    }
}