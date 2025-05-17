package GUI;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import Entity.Decor;
import EntityList.DecorList;
import File.FileIO;

public class Decoration_requirement extends JFrame implements ActionListener {
    JLabel arealabel, chairlabel;
    JTextField area, chair;
    JButton Next,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Decoration_requirement(){
        super("Decoration_requirement page");
        this.setSize(700,500);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.png").getImage());

        //Label
        arealabel = new JLabel("Area(Squre ft.)");
        arealabel.setBounds(120, 130, 150, 40);
        arealabel.setFont(font);
        arealabel.setForeground(Color.BLACK);
        this.add(arealabel);

        chairlabel = new JLabel("Number of Guest");
        chairlabel.setBounds(120, 230, 150, 40);
        chairlabel.setFont(font);
        chairlabel.setForeground(Color.BLACK);
        this.add(chairlabel);

        //textfield
        area = new JTextField();
        area.setBounds(280, 130, 210, 40);
        area.setFont(font);
        this.add(area);

        chair = new JTextField();
        chair.setBounds(280, 230, 210, 40);
        chair.setFont(font);
        this.add(chair);


        //btn
        Next = new JButton("Next");
        Next.setBounds(390, 380, 120, 40);
        Next.setFont(font);
        Next.setBackground(new Color(92, 101, 204));
        Next.setForeground(Color.white);
        Next.addActionListener(this);
        this.add(Next);

        Back = new JButton("Back");
        Back.setBounds(140, 380, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back);
        
        image = new ImageIcon("./Assets/imageedit_2_6835167697 (1).png");
		background = new JLabel();
		background.setBounds(0,0,700,500);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            this.setVisible(false);
            Management m=new Management();
            this.dispose();
        }
        else if(e.getSource()==Next){
            if(area.getText()!="" && chair.getText() != ""){
                //int eventId,String venue, Date date, double area
                int eventId = DecorList.DecorList.size()+1;
                String venu = "iccb";

                LocalDate currentDate = LocalDate.now();

                // Get day, month, and year separately
                int day = currentDate.getDayOfMonth();
                int month = currentDate.getMonthValue();
                int year = currentDate.getYear();

                double areaa = Integer.parseInt(area.getText());

                DecorList.DecorList.add(new Decor(eventId, venu, null, areaa));

                String line = eventId+";"+venu+";"+day+";"+month+";"+year+";"+areaa;
                FileIO.writeInFile(line, "./File/decor.txt", true);
                Pay p = new Pay();
                p.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please fill all the fields!");
            }
        }
    }
}



