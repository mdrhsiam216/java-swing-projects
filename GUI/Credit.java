package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Credit extends JFrame implements ActionListener{
    private JLabel jLabel3;
    private JLabel jLabel11;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JLabel jLabel8;
    private JLabel jLabel10;
    private JButton jButton1;
    JLabel background;
    ImageIcon icon,image;

    public Credit(){
        this.setSize(728, 478);
        this.setLocationRelativeTo(null);
        jLabel11 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Credit");
        this.setForeground(Color.decode("#87CEEB"));
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Created by");
        this.add(jLabel11);
        jLabel11.setBounds(300, 50, 160, 30);

        jLabel3.setText("IBRAHIM ADHAM MAZUMDER");
        this.add(jLabel3);
        jLabel3.setBounds(280, 130, 190, 30);

        jLabel4.setText("23-51162-1");
        this.add(jLabel4);
        jLabel4.setBounds(280, 160, 140, 16);

        jLabel5.setText("ANTARA BHOWMIC");
        this.add(jLabel5);
        jLabel5.setBounds(280, 200, 120, 16);

        jLabel6.setText("23-51952-2");
        this.add(jLabel6);
        jLabel6.setBounds(280, 220, 80, 16);

        jLabel7.setText("Zahid ul Islam");
        this.add(jLabel7);
        jLabel7.setBounds(280, 260, 100, 16);

        jLabel8.setText(" 23-52120-2");
        this.add(jLabel8);
        jLabel8.setBounds(280, 280, 80, 16);

        jLabel9.setText("SUMAIYA AKTER");
        this.add(jLabel9);
        jLabel9.setBounds(280, 320, 100, 16);

        jLabel10.setText("23 -53943-3");
        this.add(jLabel10);
        jLabel10.setBounds(280, 340, 80, 16);

        jButton1.setText("Close");
        this.add(jButton1);
        jButton1.setBounds(280, 390, 75, 23);
        jButton1.addActionListener(this);

        image = new ImageIcon("./Assets/plain-background-s758onqju5vtljs5 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,728,478);
		background.setIcon(image);
		this.add(background);
        

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton1){
            this.dispose();
            LogIn l = new LogIn();
        }
    }
    public static void main(String[] args) {
       Credit c = new Credit();
       c.setVisible(true); 
    }
}