package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;

import File.*;

public class RegisterPage  extends JFrame implements ActionListener{

    JButton createDonor,createReceiver, BackBtn;

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    LoginPage loginPage;

    public RegisterPage(LoginPage loginPage){
        super("Register Page");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.loginPage=loginPage;

        createDonor=new JButton("Create as Donor");
        createDonor.setFont(textArial20);
        createDonor.setBackground(new Color(240,240,240));
        createDonor.setBounds(200,250,200,40);
        createDonor.addActionListener(this);
        this.add(createDonor);

        createReceiver=new JButton("Create as Receiver");
        createReceiver.setFont(textArial20);
        createReceiver.setBackground(new Color(240,240,240));
        createReceiver.setBounds(800,250,230,40);
        createReceiver.addActionListener(this);
        this.add(createReceiver);

        BackBtn = new JButton("Back");
        BackBtn.setBounds(1080, 590, 120, 32);
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
    //     RegisterPage register=new RegisterPage();
    //     register.setVisible(true);
    // }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==createDonor){
            CreateDonorPage createDonorPage=new CreateDonorPage(loginPage, this);
            this.setVisible(false);
        }else if(e.getSource()==createReceiver){
            CreateReceiverPage createReceiverPage=new CreateReceiverPage(loginPage, this);
            this.setVisible(false);
        }else if(e.getSource()==BackBtn){
            loginPage.setVisible(true);
            this.dispose();
        }
    }

}

