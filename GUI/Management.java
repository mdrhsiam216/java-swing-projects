package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Management extends JFrame implements ActionListener {
    JButton nextbtn, backbtn, btn1, btn2, btn3;
    JLabel background;
    ImageIcon image;

    Font f2 = new Font("cambria", Font.PLAIN, 20);

    public Management(){
        super("Chose Event");
        System.out.println("management.java");
        this.setSize(800, 500);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());

        //book event button
        btn1 = new JButton("Book Event");
        btn1.setBounds(270, 80, 200, 70);
        btn1.setFont(f2);
        btn1.setBackground(Color.white);
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        this.add(btn1);   

        //book catering buttton
        btn2 = new JButton("Book Catering");
        btn2.setBounds(270, 170, 200, 70);
        btn2.setFont(f2);
        btn2.setBackground(Color.white);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(this);
        this.add(btn2);
        
        //book decoration button
        btn3 = new JButton("Book Decoration");
        btn3.setBounds(270, 260, 200, 70);
        btn3.setFont(f2);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(Color.BLACK);
        btn3.addActionListener(this);
        this.add(btn3); 

        //back button
        backbtn = new JButton("Back");
        backbtn.setBounds(300, 370, 120, 40);
        backbtn.setFont(f2);
        backbtn.setBackground(Color.white);
        backbtn.setForeground(Color.BLACK);
        backbtn.addActionListener(this);
        this.add(backbtn);

        image = new ImageIcon("./Assets/wedding-arch-decoration-skyscraper-rooftop_107791-9289 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,800,500);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(backbtn == e.getSource()){
            this.setVisible(false);
            LogIn frame = new LogIn();
            frame.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn1){
            Event_type m = new Event_type();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn2){
            Catering_requirement m= new Catering_requirement();
             m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn3){
            Decoration_requirement m = new Decoration_requirement();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==backbtn){
            LogIn m= new LogIn();
            m.setVisible(true);
            this.dispose();
        }
    }
}