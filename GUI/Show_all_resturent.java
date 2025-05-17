package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Employee;
import Entity.Restaurant;
import EntityList.EmployeeList;
import EntityList.RestaurantList;

public class Show_all_resturent extends JFrame implements ActionListener {
    JButton Back;
    ImageIcon image;
    JLabel background;

    JTable table,table1;
    DefaultTableModel model,model1;
    JScrollPane scrollPane;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Show_all_resturent(){
        super("Show_all_resturent page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //btn
        Back = new JButton("Back");
        Back.setBounds(350, 480, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("Resturent ID");
        model.addColumn("Resturent Name");

        table.setModel(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 400, 300);
		table.setRowHeight(30);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(180, 96, 500, 300);
        scrollPane.setBackground(Color.WHITE);
        this.add(scrollPane);
        createTable();

        RestaurantList.e.clear();
        loadResturent();

        this.setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Resturent_management_options frame = new Resturent_management_options();
            this.dispose();
        }
        
    }

    public void createTable() {
        ArrayList<Restaurant> allTeam = RestaurantList.e;
        
        for (int i=0;i<allTeam.size();i++) {
            model.addRow(new Object[]{allTeam.get(i).getRid(),allTeam.get(i).getName()});
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


    public static void main(String[] args) {
        Show_all_resturent frame = new Show_all_resturent();
        frame.setVisible(true);
    }
}





