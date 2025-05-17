package GUI;
import javax.swing.*;

import Entity.*;
import EntityList.*;
import File.FileIO;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Homepage extends JFrame implements ActionListener {
    JLabel lable1, lable2,lable3,label4;
    JButton nextbtn;
    JLabel background;
    ImageIcon image;

    Font f1 = new Font("Tahoma", Font.BOLD, 43);
    Font f2 = new Font("cambria", Font.PLAIN, 20);

    public Homepage(){
        super("Homepage");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());

        //Lable1
        lable1 = new JLabel("Event Management System");
        lable1.setBounds(200, 10, 600, 100);
        lable1.setFont(f1);
        lable1.setForeground(Color.BLACK);
        this.add(lable1);

        //nextBTN
        nextbtn = new JButton("Next");
        nextbtn.setBounds(420, 500, 150, 40);
        nextbtn.setFont(f2);
        nextbtn.setBackground(new Color(92, 101, 204));
        nextbtn.setForeground(Color.WHITE);
        nextbtn.addActionListener(this);
        this.add(nextbtn);

        image = new ImageIcon("./Assets/hm.png");
		background = new JLabel();
		background.setBounds(150,0,900,600);
		background.setIcon(image);
		this.add(background);
        loadCatering();
        loadCorporate();
        loadDecor();
        loadWedding();
        loadBd();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (nextbtn == e.getSource()){
            LogIn lonin = new LogIn();
            this.dispose();
        }
    }
    
    public void loadBd(){
        ArrayList <String> f = FileIO.readFromFile("./File/birthday.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            //int eventId,String venue, Date date, String name
            //id;venue;day;month;year;name
            int id = Integer.parseInt(rows[0]);
            String venue= rows[1];
            Date date= new Date(Integer.parseInt(rows[2]), Integer.parseInt(rows[3]), Integer.parseInt(rows[4]));
            String name = rows[5];
            BirthdayList.BirthdayList.add(new Birthday(id, venue, date, name));
        }
    }

    public void loadWedding(){
        ArrayList <String> f = FileIO.readFromFile("./File/wedding.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            //int eventId,String venue, Date date, String bride, String groom

            int id = Integer.parseInt(rows[0]);
            String venue= rows[1];
            Date date= new Date(Integer.parseInt(rows[2]), Integer.parseInt(rows[3]), Integer.parseInt(rows[4]));
            String bride = rows[5];
            String groom = rows[6];
            WeddingList.WeedingList.add(new Wedding(id,venue,date,bride,groom));
        }
    }

    public void loadDecor(){
        ArrayList <String> f = FileIO.readFromFile("./File/decor.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            //int eventId,String venue, Date date, double area

            int id = Integer.parseInt(rows[0]);
            String venue= rows[1];
            Date date= new Date(Integer.parseInt(rows[2]), Integer.parseInt(rows[3]), Integer.parseInt(rows[4]));
            String area = rows[5];
            DecorList.DecorList.add(new Decor(id, venue, date, id));
        }
    }

    public void loadCorporate(){
        ArrayList <String> f = FileIO.readFromFile("./File/corporate.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            //int eventId,String venue, Date date, String theme

            int id = Integer.parseInt(rows[0]);
            String venue= rows[1];
            Date date= new Date(Integer.parseInt(rows[2]), Integer.parseInt(rows[3]), Integer.parseInt(rows[4]));
            String theme = rows[5];
            
            CorporateList.CorporateList.add(new Corporate(id, venue, date, theme));
        }
    }

    public void loadCatering(){
        ArrayList <String> f = FileIO.readFromFile("./File/catering.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            //int orderId,String starter, String mainCourse, String dessert, String beverage

            int id = Integer.parseInt(rows[0]);

            String starter= rows[1];
            
            String mainCourse= rows[2];
            
            
            String beverage= rows[3];

            CateringList.CateringList.add(new Catering(id, starter, mainCourse,beverage));
        }
    }
}
