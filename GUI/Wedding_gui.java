package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Entity.Birthday;
import Entity.Date;
import Entity.Wedding;
import EntityList.BirthdayList;
import EntityList.WeddingList;
import File.FileIO;

public class Wedding_gui extends JFrame implements ActionListener {
    JLabel datelabel,daylabel,monthlabel,yeralebel,vanuelabel,brideelabel,groooomlabel;
    JTextField day,month,year,vanue,bridee,groooom;
    JButton Next,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Wedding_gui(){
        super("Wedding page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());

        //Label
        datelabel = new JLabel("Enter date");
        datelabel.setBounds(100, 130, 110, 40);
        datelabel.setFont(font);
        datelabel.setForeground(Color.BLACK);
        this.add(datelabel);

        daylabel = new JLabel("DD");
        daylabel.setBounds(250, 90, 70, 30);
        daylabel.setFont(font);
        daylabel.setForeground(Color.BLACK);
        this.add(daylabel);

        monthlabel = new JLabel("MM");
        monthlabel.setBounds(370, 90, 70, 30);
        monthlabel.setFont(font);
        monthlabel.setForeground(Color.BLACK);
        this.add(monthlabel);

        yeralebel = new JLabel("YEAR");
        yeralebel.setBounds(480, 90, 70, 30);
        yeralebel.setFont(font);
        yeralebel.setForeground(Color.BLACK);
        this.add(yeralebel);

        brideelabel = new JLabel("bridee");
        brideelabel.setBounds(100, 200, 100, 30);
        brideelabel.setFont(font);
        brideelabel.setForeground(Color.BLACK);
        this.add(brideelabel);

        groooomlabel = new JLabel("Groom");
        groooomlabel.setBounds(100, 260, 100, 30);
        groooomlabel.setFont(font);
        groooomlabel.setForeground(Color.BLACK);
        this.add(groooomlabel);

        vanuelabel = new JLabel("Vanue");
        vanuelabel.setBounds(100, 330, 100, 30);
        vanuelabel.setFont(font);
        vanuelabel.setForeground(Color.BLACK);
        this.add(vanuelabel);

        //textfield
        day = new JTextField();
        day.setBounds(220, 130, 90, 40);
        day.setFont(font);
        this.add(day);

        month = new JTextField();
        month.setBounds(340, 130, 90, 40);
        month.setFont(font);
        this.add(month);

        year = new JTextField();
        year.setBounds(460, 130, 90, 40);
        year.setFont(font);
        this.add(year);

        bridee = new JTextField();
        bridee.setBounds(220, 200, 140, 40);
        bridee.setFont(font);
        this.add(bridee);

        groooom = new JTextField();
        groooom.setBounds(220, 260, 140, 40);
        groooom.setFont(font);
        this.add(groooom);

        vanue = new JTextField();
        vanue.setBounds(220, 330, 140, 40);
        vanue.setFont(font);
        this.add(vanue);

        //btn
        Next = new JButton("Next");
        Next.setBounds(300, 480, 120, 40);
        Next.setFont(font);
        Next.setBackground(new Color(92, 101, 204));
        Next.setForeground(Color.white);
        Next.addActionListener(this);
        this.add(Next);

        Back = new JButton("Back");
        Back.setBounds(90, 480, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        //update
        image = new ImageIcon("./Assets/bride-groom-getting-married_52683-32276-removebg-preview.png");
		background = new JLabel();
		background.setBounds(370,30,500,500);
		background.setIcon(image);
		this.add(background);
        //update end

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            this.setVisible(false);
            Management m= new Management();
            m.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==Next){

            if (day.getText() != "" && month.getText() != "" && year.getText() != "" && bridee.getText() != "" && groooom.getText() != "" && vanue.getText() != "" ) {

                int eventId= BirthdayList.BirthdayList.size()+1;
                String venue = vanue.getText();
                String bride= bridee.getText();
                String groom= groooom.getText();

                Date d = new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()) , Integer.parseInt(year.getText()));
                
                WeddingList.WeedingList.add(new Wedding(eventId, venue, d, bride, groom));
                //int eventId,String venue, Date date, String bride, String groom
                String line = eventId+";"+venue+";"+day.getText()+";"+month.getText()+";"+year.getText()+";"+bride+";"+groom;
                FileIO.writeInFile(line, "./File/wedding.txt", true);
                Catering_requirement p = new Catering_requirement();
                p.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please make sure all fields are filled out!");
            }
        }
    }
}