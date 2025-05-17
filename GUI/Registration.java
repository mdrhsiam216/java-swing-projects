package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import File.FileIO;

public class Registration extends JFrame implements ActionListener {
    JLabel namelabel,passlabel,phonelabel;
    JTextField name,phone;
    JPasswordField pass;
    JButton RegisterBtn,cancelBtn;
    LogIn lg;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.BOLD, 20);
    
    public Registration(LogIn lg){
        super("Registration page");
        this.lg = lg;
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Label
        namelabel = new JLabel("Enter username");
        namelabel.setBounds(270, 140, 180, 51);
        namelabel.setFont(font);
        namelabel.setForeground(Color.BLACK);
        this.add(namelabel);

        passlabel = new JLabel("Enter password");
        passlabel.setBounds(270, 230, 170, 40);
        passlabel.setFont(font);
        passlabel.setForeground(Color.BLACK);
        this.add(passlabel);

        //textfield
        name = new JTextField();
        name.setBounds(450, 150, 160, 40);
        name.setFont(font);
        this.add(name);

        pass = new JPasswordField();
        pass.setBounds(450, 230, 160, 40);
        pass.setFont(font);
        this.add(pass);


        //btn
        RegisterBtn = new JButton("Register");
        RegisterBtn.setBounds(230, 410, 130, 40);
        RegisterBtn.setFont(font);
        RegisterBtn.setBackground(new Color(92, 101, 204));
        RegisterBtn.setForeground(Color.white);
        RegisterBtn.addActionListener(this);
        this.add(RegisterBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(480, 410, 120, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(new Color(92, 101, 204));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn); 
        
        image = new ImageIcon("./Assets/food-court-isometric-concept_1284-16170.jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
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

