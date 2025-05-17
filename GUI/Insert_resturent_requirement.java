package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import Entity.Restaurant;
import EntityList.RestaurantList;
import File.*;

public class Insert_resturent_requirement extends JFrame implements ActionListener {
    JLabel idlabel, namelabel, salarylabel;
    JTextField id, name, salary;
    JButton Insert,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Insert_resturent_requirement(){
        super("Insert_resturent_requirement page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Label
        idlabel = new JLabel("Enter resturent Id");
        idlabel.setBounds(250, 130, 250, 40);
        idlabel.setFont(font);
        idlabel.setForeground(Color.WHITE);
        this.add(idlabel);

        namelabel = new JLabel("Enter resturent name");
        namelabel.setBounds(250, 210, 250, 40);
        namelabel.setFont(font);
        namelabel.setForeground(Color.WHITE);
        this.add(namelabel);

        // salarylabel = new JLabel("Enter salary");
        // salarylabel.setBounds(470, 290, 100, 40);
        // salarylabel.setFont(font);
        // salarylabel.setForeground(Color.BLACK);
        // this.add(salarylabel);

        //textfield
        id = new JTextField();
        id.setBounds(450, 130, 210, 40);
        id.setFont(font);
        this.add(id);

        name = new JTextField();
        name.setBounds(450, 210, 210, 40);
        name.setFont(font);
        this.add(name);

        //btn
        Insert = new JButton("Insert");
        Insert.setBounds(400, 440, 120, 40);
        Insert.setFont(font);
        Insert.setBackground(new Color(92, 101, 204));
        Insert.setForeground(Color.white);
        Insert.addActionListener(this);
        this.add(Insert);

        Back = new JButton("Back");
        Back.setBounds(250, 440, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        image = new ImageIcon("./Assets/night-scene-mini-booth-beverage-shop-with-chair-table-near-nature-park_1150-48824 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Resturent_management_options frame = new Resturent_management_options();
            this.dispose();
        }
        else if(e.getSource()==Insert){
            if(id.getText()!="" && name.getText() !="" ){
                String n = name.getText();
                String i= id.getText();
                //String rid,String name
                RestaurantList.e.add(new Restaurant(i,n));
                
                String line = i+";"+n;
                System.out.println(line);
                
                FileIO.writeInFile(line, "./File/resturent.txt", true);
                Resturent_management_options p= new Resturent_management_options();
                p.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Insert_resturent_requirement frame  = new Insert_resturent_requirement();
        frame.setVisible(true);
    }
}