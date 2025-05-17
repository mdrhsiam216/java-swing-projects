package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event_type extends JFrame implements ActionListener {
    JButton nextbtn, backbtn, btn1, btn2, btn3;
    JLabel background;
    ImageIcon image;

    Font f2 = new Font("cambria", Font.PLAIN, 30);

    public Event_type(){
        super("Chose Event_type");
        System.out.println("event type.java");
        this.setSize(600, 516);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());       

        //book event button
        btn1 = new JButton("Birthday");
        btn1.setBounds(190, 110, 200, 70);
        btn1.setFont(f2);
        btn1.setBackground(new Color(92, 101, 204));
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        this.add(btn1);    

        //book catering buttton
        btn2 = new JButton("Wedding");
        btn2.setBounds(190, 200, 200, 70);
        btn2.setFont(f2);
        btn2.setBackground(new Color(92, 101, 204));
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        this.add(btn2);
        
        //book decoration button
        btn3 = new JButton("Corporate");
        btn3.setBounds(190, 290, 200, 70);
        btn3.setFont(f2);
        btn3.setBackground(new Color(92, 101, 204));
        btn3.setForeground(Color.WHITE);
        btn3.addActionListener(this);
        this.add(btn3); 

        //back button
        backbtn = new JButton("Back");
        backbtn.setBounds(230, 400, 120, 40);
        backbtn.setFont(f2);
        backbtn.setBackground(new Color(92, 101, 204));
        backbtn.setForeground(Color.WHITE);
        backbtn.addActionListener(this);
        this.add(backbtn);

        image = new ImageIcon("./Assets/a.jpg");
		background = new JLabel();
		background.setBounds(0,0,600,520);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(backbtn == e.getSource()){
            Management frame = new Management();
            frame.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn1){
            Birthday_Gui m = new Birthday_Gui();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn2){
            Wedding_gui m= new Wedding_gui();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==btn3){
            Corporate_gui m= new Corporate_gui();
            m.setVisible(true);
            this.dispose();
        }
    }
    public static void main(String[] args) {
        Event_type e = new Event_type();
        e.setVisible(true);
    }

}

