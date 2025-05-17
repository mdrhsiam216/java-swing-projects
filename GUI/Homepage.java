package GUI;
import javax.swing.*;

import Entity.Employee;
import Entity.FoodCourt;
import Entity.Restaurant;
import EntityList.EmployeeList;
import EntityList.FoodCourtList;
import EntityList.RestaurantList;
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

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Lable1
        lable1 = new JLabel("Restuarant Management System");
        lable1.setBounds(100, 10, 800, 100);
        lable1.setFont(f1);
        lable1.setForeground(Color.BLACK);
        this.add(lable1);

        //nextBTN
        nextbtn = new JButton("Next");
        nextbtn.setBounds(400, 500, 150, 40);
        nextbtn.setFont(f2);
        nextbtn.setBackground(new Color(92, 101, 204));
        nextbtn.setForeground(Color.WHITE);
        nextbtn.addActionListener(this);
        this.add(nextbtn);

        image = new ImageIcon("./Assets/open-air-festival-camping-area-retro-cartoon-banner-with-food-court-tents-fathers-with-kids_1284-20328-removebg-preview.png");
		background = new JLabel();
		background.setBounds(130,70,670,372);
		background.setIcon(image);
		this.add(background);
        loadEmployee();
        loadResturent();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (nextbtn == e.getSource()){
            LogIn lonin = new LogIn();
            this.dispose();
        }
    }

    public void loadEmployee(){
        ArrayList <String> f = FileIO.readFromFile("./File/employee.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            String id = rows[0];
            String name= rows[1];
            Double salary = Double.parseDouble(rows[2]) ;
            EmployeeList.e.add(new Employee(id, name, salary));
        }
    }

    public void loadResturent(){
        ArrayList <String> f = File.FileIO.readFromFile("./File/resturent.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            String id = rows[0];
            String name= rows[1];
            
            RestaurantList.e.add(new Restaurant(id,name));
        }
    }
    public void loadFoodCourt(){
        ArrayList <String> f = File.FileIO.readFromFile("./File/foodcourt.txt");
        for(int i=0;i<f.size();i++){
            String rows[]= f.get(i).split(";");

            String id = rows[0];
            String name= rows[1];
            
            FoodCourtList.e.add(new FoodCourt(name, id));
        }
    }

    public static void main(String[] args) {
        Homepage frame = new Homepage();
        frame.setVisible(true);
    }
}

