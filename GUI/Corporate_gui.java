package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Entity.Corporate;
import Entity.Date;
import Entity.Wedding;
import EntityList.BirthdayList;
import EntityList.CorporateList;
import EntityList.WeddingList;
import File.FileIO;

public class Corporate_gui extends JFrame implements ActionListener {
    JLabel datelabel,daylabel,monthlabel,yeralebel,vanuelabel,themelabel;
    JTextField day,month,year,vanue,theme;
    JButton Next,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Corporate_gui(){
        super("Corporate page");
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

        themelabel = new JLabel("Theme");
        themelabel.setBounds(100, 250, 150, 30);
        themelabel.setFont(font);
        themelabel.setForeground(Color.BLACK);
        this.add(themelabel);

        vanuelabel = new JLabel("Vanue");
        vanuelabel.setBounds(100, 350, 100, 30);
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

        theme = new JTextField();
        theme.setBounds(220, 250, 140, 40);
        theme.setFont(font);
        this.add(theme);

        vanue = new JTextField();
        vanue.setBounds(220, 350, 140, 40);
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
        image = new ImageIcon("./Assets/business-team-discussing-ideas-startup_74855-4380-removebg-preview.png");
		background = new JLabel();
		background.setBounds(250,90,632,395);
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

            if (day.getText() != "" && month.getText() != "" && year.getText() != "" && theme.getText() != "" && vanue.getText() != "" ) {
                Catering_requirement frame = new Catering_requirement();
                frame.setVisible(true);
                dispose();
                int eventId= BirthdayList.BirthdayList.size()+1;
                String venue = vanue.getText();
                String themee= theme.getText();

                Date d = new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()) , Integer.parseInt(year.getText()));
                
                CorporateList.CorporateList.add(new Corporate(eventId, venue, d, themee));
                //int eventId,String venue, Date date, String theme
                String line = eventId+";"+venue+";"+day.getText()+";"+month.getText()+";"+year.getText()+";"+themee;
                FileIO.writeInFile(line, "./File/corporate.txt", true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please make sure all fields are filled out!");
            }
        }
    }

}


