package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Entity.Employee;
import EntityList.EmployeeList;

public class Insert_employee_requirement extends JFrame implements ActionListener {
    JLabel idlabel, namelabel, salarylabel;
    JTextField id, name, salary;
    JButton Insert,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Insert_employee_requirement(){
        super("Add_Employee_requirement page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Label
        idlabel = new JLabel("Enter Id");
        idlabel.setBounds(450, 130, 110, 40);
        idlabel.setFont(font);
        idlabel.setForeground(Color.BLACK);
        this.add(idlabel);

        namelabel = new JLabel("Enter name");
        namelabel.setBounds(450, 210, 100, 40);
        namelabel.setFont(font);
        namelabel.setForeground(Color.BLACK);
        this.add(namelabel);

        salarylabel = new JLabel("Enter salary");
        salarylabel.setBounds(450, 290, 130, 40);
        salarylabel.setFont(font);
        salarylabel.setForeground(Color.BLACK);
        this.add(salarylabel);

        //textfield
        id = new JTextField();
        id.setBounds(590, 130, 210, 40);
        id.setFont(font);
        this.add(id);

        name = new JTextField();
        name.setBounds(590, 210, 210, 40);
        name.setFont(font);
        this.add(name);

        salary = new JTextField();
        salary.setBounds(590, 290, 210, 40);
        salary.setFont(font);
        this.add(salary);

        //btn
        Insert = new JButton("Insert");
        Insert.setBounds(690, 440, 120, 40);
        Insert.setFont(font);
        Insert.setBackground(new Color(92, 101, 204));
        Insert.setForeground(Color.white);
        Insert.addActionListener(this);
        this.add(Insert);

        Back = new JButton("Back");
        Back.setBounds(490, 440, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        image = new ImageIcon("./Assets/hand-drawn-family-preparing-zongzi_23-2148546305-removebg-preview.png");
		background = new JLabel();
		background.setBounds(30,0,500,500);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Employee_management_options frame = new Employee_management_options();
            this.dispose();
        }
        else if(e.getSource()==Insert){
            if(id.getText()!="" && name.getText() !="" && salary.getText()!=""){
                String n = name.getText();
                String i= id.getText();
                Double s= Double.parseDouble(salary.getText());

                //String id, String nm, double slr
                (EmployeeList.e).add(new Employee(i, n, s));

                String line = i+";"+n+";"+s;
                System.out.println(line);
                
                File.FileIO.writeInFile(line, "./File/employee.txt", true);
                
                Employee_management_options p = new Employee_management_options();
                p.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    public static void main(String[] args) {
        Insert_employee_requirement frame = new Insert_employee_requirement();
        frame.setVisible(true);
    }
}