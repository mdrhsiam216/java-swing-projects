package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;
import File.FileIO;

import java.util.ArrayList;

public class AddTeam extends JFrame implements ActionListener{
    JTextField name, id;
    JPanel panel;
    JLabel namelabel,idlabel;
    JButton addBtn,exitBtn;

    ImageIcon image;
    JLabel background;
    Font font = new Font("Segoe UI", 1, 18);

    TeamList l;
    FileIO fIo;
    Manageteam m;
    DefaultTableModel model;
    public AddTeam(Manageteam m,TeamList l,DefaultTableModel model) {
        super("Team Management");
        this.l=l;
        this.m=m;
        this.model = model;
        fIo = new FileIO();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocation(200, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/football.png").getImage());

        name=new JTextField();
        id=new JTextField();
        panel = new JPanel();
        panel.setLayout(null);
		panel.setSize(500,400);
		panel.setBackground(new Color(200,200,200));

        namelabel = new JLabel("Enter Team name");
        namelabel.setBounds(30,50,250,40);
        namelabel.setFont(font);
        namelabel.setForeground(Color.WHITE);
        this.add(namelabel);

        idlabel = new JLabel("Enter ID");
        idlabel.setBounds(60    ,100,250,40);
        idlabel.setFont(font);
        idlabel.setForeground(Color.WHITE);
        this.add(idlabel);
        
        //text field
        name.setBounds(180,50,200,40);
        id.setBounds(180, 100, 200, 40);
        panel.add(name);
        panel.add(id);
        this.add(panel);

        //Btn
        addBtn = new JButton("Create Team");
        addBtn.setBounds(100,220,150,40);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);
        addBtn.setLayout(null);
        
        exitBtn=new JButton("Cancell");
        exitBtn.setBounds(270,220,150,40);
        exitBtn.setBackground(Color.RED);
        exitBtn.addActionListener(this);
        exitBtn.setLayout(null);

        panel.add(addBtn);
        panel.add(exitBtn);

        image = new ImageIcon("./Assets/messi2.jpg");
        background = new JLabel();
        background.setBounds(0,0,500,400);
        background.setIcon(image);
        panel.add(background);


        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addBtn){

            ArrayList <Team> allTeamss = l.getAll();

            int flag=0;
            for (int i=0;i<allTeamss.size();i++) {
                if(name.getText().equals(allTeamss.get(i).getTeamName())){
                    System.out.println("team matched");
                    flag++;
                }
                else{
                    System.out.println("team did not match");
                }
            }
            if(flag==0){
                add();
            }
            else{
                JOptionPane.showMessageDialog(this, "Team already exists", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==exitBtn){
            this.setVisible(false);
            m.setVisible(true);
            m.createTable();
        }
    }
    
    void add(){
        l.insert(new Team( Integer.parseInt(id.getText()) , name.getText()));
        model.addRow(new Object[]{id.getText(), name.getText()});
        fIo.writeInFile(id.getText()+";"+name.getText(),"./File/teams.txt",true);
        this.dispose();
        m.setVisible(true);
    }
}