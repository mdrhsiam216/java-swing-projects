package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Management extends JFrame implements ActionListener {
    JButton nextbtn, backbtn, btn1, btn2, btn3,btn4;
    JLabel background;
    ImageIcon image;

    Font f2 = new Font("cambria", Font.PLAIN, 20);

    public Management(){
        super("Management");
        System.out.println("management.java");
        this.setSize(900, 600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Employee management button
        btn1 = new JButton("Employee Management");
        btn1.setBounds(270, 80, 400, 70);
        btn1.setFont(f2);
        btn1.setBackground(new Color(92, 101, 204));
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        this.add(btn1);   

        //Restaurant Management buttton
        btn2 = new JButton("Restaurant Management");
        btn2.setBounds(270, 170, 400, 70);
        btn2.setFont(f2);
        btn2.setBackground(new Color(92, 101, 204));
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(this);
        this.add(btn2);
        
        //Restaurant Food Item Management
        btn3 = new JButton("Food court Management");
        btn3.setBounds(270, 260, 400, 70);
        btn3.setFont(f2);
        btn3.setBackground(new Color(92, 101, 204));
        btn3.setForeground(Color.BLACK);
        btn3.addActionListener(this);
        this.add(btn3); 

        //back btn
        backbtn = new JButton("Back");
        backbtn.setBounds(380, 460, 120, 40);
        backbtn.setFont(f2);
        backbtn.setBackground(new Color(92, 101, 204));
        backbtn.setForeground(Color.BLACK);
        backbtn.addActionListener(this);
        this.add(backbtn);
        

        image = new ImageIcon("./Assets/eating-food-court-middle-shopping-center-serving-fast-food-illustration_2175-3749.jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(backbtn == e.getSource()){
            LogIn frame = new LogIn();
            frame.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn1){
            Employee_management_options m = new Employee_management_options();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn2){
            Resturent_management_options m= new Resturent_management_options();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn3){
            FoodCourt_management_options m = new FoodCourt_management_options();
            m.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        Management frame = new Management();
        frame.setVisible(true);
    }
}
