package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Date;
import Entity.Player;

import java.awt.*;
import java.awt.event.*;

import EntityList.*;
import File.*;
public class AddPlayer extends JFrame implements ActionListener {
    JPanel panel;
    JTable table;
    FileIO fIo=new FileIO();
    Font font = new Font("Segoe UI", 1, 18);

    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11,jLabel12,jLabel13;

    JTextField name,age,nation,salary,agreement,jerseyNo,position,leg,height,prevclub,goal,id,currentclub;

    JButton addBtn,cancelBtn;

    ImageIcon image;
    JLabel background;

    DefaultTableModel model;
    TeamList l;
    ManagePlayer mp;
    public AddPlayer(ManagePlayer mp,TeamList l,DefaultTableModel model){
		super("Player Management");
        this.l = l;
        this.mp=mp;
        this.model=model;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocation(200, 100);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/football.png").getImage());

        //Label
        jLabel1 = new JLabel("Name");
        jLabel1.setBounds(20,10,60,40);
        jLabel1.setFont(font);
        jLabel1.setForeground(Color.WHITE);
        this.add(jLabel1);

        jLabel2 = new JLabel("Age");
        jLabel2.setBounds(20,50,40,40);
        jLabel2.setFont(font);
        jLabel2.setForeground(Color.WHITE);
        this.add(jLabel2);

        jLabel3 = new JLabel("Nation");
        jLabel3.setBounds(20, 100, 60, 25);
        jLabel3.setFont(font);
        jLabel3.setForeground(Color.WHITE);
        this.add(jLabel3);

        jLabel4 = new JLabel("Salary");
        jLabel4.setBounds(20, 140, 70, 25);
        jLabel4.setFont(font);
        jLabel4.setForeground(Color.WHITE);
        this.add(jLabel4);

        jLabel5 = new JLabel("Agreement");
        jLabel5.setBounds(20, 180, 100, 25);
        jLabel5.setFont(font);
        jLabel5.setForeground(Color.WHITE);
        this.add(jLabel5);

        jLabel6 = new JLabel("Jersy No");
        jLabel6.setBounds(20, 220, 90, 25);
        jLabel6.setFont(font);
        jLabel6.setForeground(Color.WHITE);
        this.add(jLabel6);

        jLabel7 = new JLabel("Position");
        jLabel7.setBounds(20, 260, 80, 30);
        jLabel7.setFont(font);
        jLabel7.setForeground(Color.WHITE);
        this.add(jLabel7);

        jLabel8 = new JLabel("Leg");
        jLabel8.setBounds(290, 20, 50, 30);
        jLabel8.setFont(font);
        jLabel8.setForeground(Color.WHITE);
        this.add(jLabel8);

        jLabel9 = new JLabel("Height");
        jLabel9.setBounds(290, 50, 80, 50);
        jLabel9.setFont(font);
        jLabel9.setForeground(Color.WHITE);
        this.add(jLabel9);

        jLabel10 = new JLabel("PrevClub");
        jLabel10.setBounds(290, 100, 90, 30);
        jLabel10.setFont(font);
        jLabel10.setForeground(Color.WHITE);
        this.add(jLabel10);

        jLabel11 = new JLabel("Goal");
        jLabel11.setBounds(290, 130, 40, 50);
        jLabel11.setFont(font);
        jLabel11.setForeground(Color.WHITE);
        this.add(jLabel11);

        jLabel12 = new JLabel("ID");
        jLabel12.setBounds(290, 170, 70, 40);
        jLabel12.setFont(font);
        jLabel12.setForeground(Color.WHITE);
        this.add(jLabel12);

        jLabel13 = new JLabel("CurrentClub");
        jLabel13.setBounds(290, 220, 110, 25);
        jLabel13.setFont(font);
        jLabel13.setForeground(Color.WHITE);
        this.add(jLabel13);

        //TextField
        name = new JTextField();
        name.setBounds(110, 20, 130, 30);
        this.add(name);

        age = new JTextField();
        age.setBounds(110, 60, 130, 30);
        this.add(age);

        nation = new JTextField();
        nation.setBounds(110, 100, 130, 30);
        this.add(nation);

        salary = new JTextField();
        salary.setBounds(110, 140, 130, 30);
        this.add(salary);

        agreement = new JTextField();
        agreement.setBounds(130, 180, 110, 30);
        this.add(agreement);

        jerseyNo = new JTextField();
        jerseyNo.setBounds(130, 220, 110, 30);
        this.add(jerseyNo);

        position = new JTextField();
        position.setBounds(130, 260, 110, 30);
        this.add(position);

        leg = new JTextField();
        leg.setBounds(401, 20, 110, 30);
        this.add(leg);

        height = new JTextField();
        height.setBounds(400, 60, 110, 30);
        this.add(height);

        prevclub = new JTextField();
        prevclub.setBounds(400, 100, 110, 30);
        this.add(prevclub);

        goal = new JTextField();
        goal.setBounds(400, 140, 110, 30);
        this.add(goal);

        id = new JTextField();
        id.setBounds(400, 180, 110, 30);
        this.add(id);

        currentclub = new JTextField();
        currentclub.setBounds(400, 220, 110, 30);
        this.add(currentclub);

        //Btn
        addBtn = new JButton("Add Player");
        addBtn.setBounds(180, 320, 130, 40);
        addBtn.setFont(font);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);
        this.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(320, 320, 100, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(Color.ORANGE);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn);
        

        panel = new JPanel();
        this.add(panel);

        image = new ImageIcon("./Assets/football6.jpg");
        background = new JLabel();
        background.setBounds(0,0,700,500);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addBtn){
            //String name,int age,String nation,double salary,Date joiningdate,double agreement,int jerseyNo,String position,String leg,double height,String prevClub,int goal,int id
            Player p = new Player(name.getText(),Integer.parseInt(age.getText()),nation.getText(),Double.parseDouble(salary.getText()),new Date(1,1,2000),Double.parseDouble(agreement.getText()),Integer.parseInt(jerseyNo.getText()),position.getText(),leg.getText(),Double.parseDouble(height.getText()),prevclub.getText(),Integer.parseInt(goal.getText()),Integer.parseInt(id.getText()));

           l.getTeam(currentclub.getText()).insert(p);
           add();
        }
        else if(e.getSource()==cancelBtn){
            this.setVisible(false);
            mp.setVisible(true);
        }
    }

    void add(){
        // model.addRow(new Object[]{id.getText(),name.getText(),age.getText(),nation.getText(),salary.getText(),agreement.getText(),jerseyNo.getText(),position.getText(),leg.getText(),height.getText(),prevclub.getText(),goal.getText(),currentclub.getText()});

        String string="";
        string+=id.getText()+";"+name.getText()+";"+  age.getText()+";"+  nation.getText()+";"+  salary.getText()+";"+  agreement.getText()+";"+  jerseyNo.getText()+";"+  position.getText()+";"+  leg.getText()+";"+  height.getText()+";"+  prevclub.getText()+";"+  goal.getText()+";"+  currentclub.getText();
        
        fIo.writeInFile(string,"./File/players.txt",true);

        this.setVisible(false);
        mp.setVisible(true);
    }
   
}