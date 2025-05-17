package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FoodCourt_management_options extends JFrame implements ActionListener {
    JButton nextbtn, backbtn, btn1, btn2, btn3,btn4;
    JLabel background;
    ImageIcon image;

    Font f2 = new Font("cambria", Font.PLAIN, 20);

    public FoodCourt_management_options(){
        super("FoodCourt_management_options");
        System.out.println("FoodCourt_management_options.java");
        this.setSize(900, 600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //insert new Resturent button
        btn1 = new JButton("Insert new Food court");
        btn1.setBounds(270, 80, 400, 70);
        btn1.setFont(f2);
        btn1.setBackground(Color.white);
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        this.add(btn1);   

        //Remove Existing Resturent buttton
        btn2 = new JButton("Remove Existing Food court");
        btn2.setBounds(270, 170, 400, 70);
        btn2.setFont(f2);
        btn2.setBackground(Color.white);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(this);
        this.add(btn2);
        
        //Show all Resturent
        btn3 = new JButton("Show all Foodcourt");
        btn3.setBounds(270, 260, 400, 70);
        btn3.setFont(f2);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(Color.BLACK);
        btn3.addActionListener(this);
        this.add(btn3); 

        //back btn
        backbtn = new JButton("Back");
        backbtn.setBounds(380, 460, 120, 40);
        backbtn.setFont(f2);
        backbtn.setBackground(Color.white);
        backbtn.setForeground(Color.BLACK);
        backbtn.addActionListener(this);
        this.add(backbtn);
        

        image = new ImageIcon("./Assets/restaurant-interior-panorama-men-women-enjoying-delicious-food-couple-date-waitress-taking-order-man-reading-newspaper_575670-971 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(backbtn == e.getSource()){
            this.setVisible(false);
            Management frame = new Management();
            frame.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn1){
            Insert_foodcourt_requirement m = new Insert_foodcourt_requirement();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn2){
            Remove_foodcourt_requirement m = new Remove_foodcourt_requirement();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn3){
            Show_all_FoodCourt m= new Show_all_FoodCourt();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==backbtn){
            Management m = new Management();
            m.setVisible(true);
            this.dispose();
        }
    }
}
