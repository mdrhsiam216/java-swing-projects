package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Entity.*;

import EntityList.EmployeeList;
import EntityList.RestaurantList;

public class Remove_resturent_requirement extends JFrame implements ActionListener {
    JLabel idlabel, namelabel, salarylabel;
    JTextField id, name, salary;
    JButton Remove,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Remove_resturent_requirement(){
        super("Remove_resturent_requirement page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Label
        idlabel = new JLabel("Enter Resturent Id");
        idlabel.setBounds(250, 150, 200, 40);
        idlabel.setFont(font);
        idlabel.setForeground(Color.WHITE);
        this.add(idlabel);

        //textfield
        id = new JTextField();
        id.setBounds(450, 150, 210, 40);
        id.setFont(font);
        this.add(id);

        //btn
        Remove = new JButton("Remove");
        Remove.setBounds(500, 440, 120, 40);
        Remove.setFont(font);
        Remove.setBackground(new Color(92, 101, 204));
        Remove.setForeground(Color.white);
        Remove.addActionListener(this);
        this.add(Remove);

        Back = new JButton("Back");
        Back.setBounds(250, 440, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        image = new ImageIcon("./Assets/business-team-discussing-ideas-startup_74855-4380.jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Resturent_management_options frame = new Resturent_management_options();
            frame.setVisible(true);
            this.dispose();
        }

        else if(e.getSource()==Remove){
            if(id.getText()!=""){
                String n= id.getText();
                String line="";
                int j= RestaurantList.e.size()-1;
                for(int i=0;i<j-1;i++){
                    if(((Restaurant)RestaurantList.e.get(i)).getRid().equals(n)){
                        RestaurantList.e.remove(i);
                    }
                    else{
                        if(j==i){
                            line += RestaurantList.e.get(i).getRid()+";"+RestaurantList.e.get(i).getName();
                        }
                        else{
                            line += RestaurantList.e.get(i).getRid()+";"+RestaurantList.e.get(i).getName()+"\n";
                        }
                    }
                }
                line=line.substring(0, line.length()-2);
                File.FileIO.writeInFile(line, "./File/resturent.txt", false);
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
        Remove_resturent_requirement frame = new Remove_resturent_requirement();
        frame.setVisible(true);
    }
}