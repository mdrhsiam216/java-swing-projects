package GUI;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import Entity.Catering;
import Entity.Decor;
import EntityList.CateringList;
import EntityList.DecorList;
import File.FileIO;

public class Catering_requirement extends JFrame implements ActionListener {
    JLabel starterlabel, mainlabel, beveragelebel;
    JTextField starter, main, beverage;
    JButton Next,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Catering_requirement(){
        super("Catering_requirement page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());

        //Label
        starterlabel = new JLabel("Starter Item");
        starterlabel.setBounds(470, 130, 110, 40);
        starterlabel.setFont(font);
        starterlabel.setForeground(Color.BLACK);
        this.add(starterlabel);

        mainlabel = new JLabel("Main");
        mainlabel.setBounds(470, 210, 100, 40);
        mainlabel.setFont(font);
        mainlabel.setForeground(Color.BLACK);
        this.add(mainlabel);

        beveragelebel = new JLabel("Beverage");
        beveragelebel.setBounds(470, 290, 100, 40);
        beveragelebel.setFont(font);
        beveragelebel.setForeground(Color.BLACK);
        this.add(beveragelebel);

        //textfield
        starter = new JTextField();
        starter.setBounds(590, 130, 210, 40);
        starter.setFont(font);
        this.add(starter);

        main = new JTextField();
        main.setBounds(590, 210, 210, 40);
        main.setFont(font);
        this.add(main);

        beverage = new JTextField();
        beverage.setBounds(590, 290, 210, 40);
        beverage.setFont(font);
        this.add(beverage);

        //btn
        Next = new JButton("Next");
        Next.setBounds(690, 440, 120, 40);
        Next.setFont(font);
        Next.setBackground(new Color(92, 101, 204));
        Next.setForeground(Color.white);
        Next.addActionListener(this);
        this.add(Next);

        Back = new JButton("Back");
        Back.setBounds(490, 440, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        image = new ImageIcon("./Assets/fried-chicken-sticker-white-background_1308-64824-removebg-preview (1).png");
		background = new JLabel();
		background.setBounds(10,100,500,300);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Management m= new Management();
            this.dispose();
        }
        else if(e.getSource()==Next){
            if(starter.getText()!="" && main.getText() !="" && beverage.getText()!=""){
                String s = starter.getText().toLowerCase();
                String ma = main.getText().toLowerCase();
                String bv = beverage.getText().toLowerCase();
                int id= CateringList.CateringList.size()+1;

                CateringList.CateringList.add(new Catering(id, s, ma, bv));
                //int orderId,String starter, String mainCourse, String beverage

                String line = id+";"+s+";"+ma+";"+bv;
                FileIO.writeInFile(line, "./File/catering.txt", true);
                Pay p = new Pay();
                p.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}


