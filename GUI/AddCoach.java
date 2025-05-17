package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Coach;
import Entity.Date;
import EntityList.TeamList;
import File.FileIO;

public class AddCoach extends JFrame implements ActionListener {

JPanel panel;
    Font font = new Font("Segoe UI", 1, 18);

    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9;
    JTextField name,age,nation,salary,agreement,experience,achievements,id,currentclub;

    ImageIcon image;
    JLabel background;

    JButton addBtn,cancelBtn;
    ManageCoach m;
    TeamList l;
    DefaultTableModel model;
    FileIO fIo = new FileIO();

    public AddCoach(ManageCoach m,TeamList l,DefaultTableModel model){
        super("Add Coach");
        this.m = m;
        this.l = l;
        this.model=model;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocation(200, 100);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/football.png").getImage());

        //Label
        jLabel1 = new JLabel("Name");
        jLabel1.setBounds(20, 20, 60, 50);
        jLabel1.setFont(font);
        jLabel1.setForeground(Color.WHITE);
        this.add(jLabel1);
 
        jLabel2 = new JLabel("Age");
        jLabel2.setBounds(20, 70, 40, 40);
        jLabel2.setFont(font);
        jLabel2.setForeground(Color.WHITE);
        this.add(jLabel2);
 
        jLabel3 = new JLabel("Nation");
        jLabel3.setBounds(20, 130, 60, 25);
        jLabel3.setFont(font);
        jLabel3.setForeground(Color.WHITE);
        this.add(jLabel3);
 
        jLabel4 = new JLabel("Salary");
        jLabel4.setBounds(20, 170, 70, 50);
        jLabel4.setFont(font);
        jLabel4.setForeground(Color.WHITE);
        this.add(jLabel4);
 
        jLabel5 = new JLabel("Agreement");
        jLabel5.setBounds(300, 15, 100, 40);
        jLabel5.setFont(font);
        jLabel5.setForeground(Color.WHITE);
        this.add(jLabel5);

        jLabel6 = new JLabel("Experience");
        jLabel6.setBounds(300, 70, 110, 25);
        jLabel6.setFont(font);
        jLabel6.setForeground(Color.WHITE);
        this.add(jLabel6);

        jLabel7 = new JLabel("Achievements");
        jLabel7.setBounds(300, 120, 120, 30);
        jLabel7.setFont(font);
        jLabel7.setForeground(Color.WHITE);
        this.add(jLabel7);

        jLabel8 = new JLabel("ID");
        jLabel8.setBounds(300, 160, 70, 50);
        jLabel8.setFont(font);
        jLabel8.setForeground(Color.WHITE);
        this.add(jLabel8);

        jLabel9 = new JLabel("CurrentClub");
        jLabel9.setBounds(300, 220, 120, 30);
        jLabel9.setFont(font);
        jLabel9.setForeground(Color.WHITE);
        this.add(jLabel9);

        //Textfield
        name = new JTextField();
        name.setBounds(110, 30, 130, 30);
        this.add(name);

        age = new JTextField();
        age.setBounds(110, 80, 130, 30);
        this.add(age);

        nation = new JTextField();
        nation.setBounds(110, 130, 130, 30);
        this.add(nation);

        salary = new JTextField();
        salary.setBounds(110, 180, 130, 30);
        this.add(salary);

        agreement = new JTextField();
        agreement.setBounds(430, 20, 110, 30);
        this.add(agreement);

        experience = new JTextField();
        experience.setBounds(430, 70, 110, 30);
        this.add(experience);

        achievements = new JTextField();
        achievements.setBounds(430, 120, 110, 30);
        this.add(achievements);

        id = new JTextField();
        id.setBounds(430, 170, 110, 30);
        this.add(id);

        currentclub = new JTextField();
        currentclub.setBounds(430, 220, 110, 30);
        this.add(currentclub);

        //Btn
        addBtn = new JButton("Add Coach");
        addBtn.setBounds(170, 260, 140, 40);
        addBtn.setFont(font);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);
        this.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(330, 260, 110, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(Color.ORANGE);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn);
       
        panel = new JPanel();
        this.add(panel);

        image = new ImageIcon("./Assets/football4.jpg");
        background = new JLabel();
        background.setBounds(0,0,700,500);
        background.setIcon(image);
        this.add(background);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addBtn){
            //String name,  int age,  String nation  ,double salary,  Date joiningDate,  double agreement,   int experience,   String achievements,   int id
            Coach o = new Coach(name.getText(),  Integer.parseInt(age.getText()),  nation.getText(),  Double.parseDouble(salary.getText()),  new Date(1, 1, 2000),  Double.parseDouble(agreement.getText()),  Integer.parseInt(experience.getText()),  achievements.getText(),  Integer.parseInt(id.getText()));
            l.getTeam(currentclub.getText()).insertCoach(o);
            add();
        }
        else if(e.getSource()==cancelBtn){
            this.setVisible(false);
            m.setVisible(true);
        }
    }

    void add(){
        model.addRow(new Object[]{id.getText(),name.getText(),age.getText(),nation.getText(),salary.getText(),agreement.getText(),experience.getText(),achievements.getText(),currentclub.getText()});

        String string="";
        string=string+id.getText()+";"+age.getText()+";"+nation.getText()+";"+salary.getText()+";"+agreement.getText()+";"+experience.getText()+";"+achievements.getText()+";"+currentclub.getText();
        
        fIo.writeInFile(string,"./File/coach.txt",true);

        this.setVisible(false);
        m.setVisible(true);
    }
}