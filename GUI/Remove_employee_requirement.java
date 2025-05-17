package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import EntityList.EmployeeList;

public class Remove_employee_requirement extends JFrame implements ActionListener {
    JLabel idlabel, namelabel, salarylabel;
    JTextField id, name, salary;
    JButton Remove,Back;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Remove_employee_requirement(){
        super("Remove_employee_requirement page");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        //Label
        idlabel = new JLabel("Enter Employee Id");
        idlabel.setBounds(400, 130, 200, 40);
        idlabel.setFont(font);
        idlabel.setForeground(Color.BLACK);
        this.add(idlabel);

        //textfield
        id = new JTextField();
        id.setBounds(590, 130, 210, 40);
        id.setFont(font);
        this.add(id);

        //btn
        Remove = new JButton("Remove");
        Remove.setBounds(690, 440, 120, 40);
        Remove.setFont(font);
        Remove.setBackground(new Color(92, 101, 204));
        Remove.setForeground(Color.white);
        Remove.addActionListener(this);
        this.add(Remove);

        Back = new JButton("Back");
        Back.setBounds(490, 440, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 
        
        image = new ImageIcon("./Assets/waitress-carrying-takeaway-coffee-customers-outdoor-cafe_74855-11185-removebg-preview.png");
		background = new JLabel();
		background.setBounds(10,50,612,408);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Employee_management_options frame = new Employee_management_options();
            frame.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==Remove){
            
            if(id.getText()!=""){
                String n= id.getText();
                String line="";
                File.FileIO.writeInFile(line, "./File/employee.txt", false);

                int j= EmployeeList.e.size();
                System.out.println("employee list size: "+ j);
                for(int i=0;i<j-1;i++){
                    if(EmployeeList.e.get(i).getEmpId().equals(n)){
                        System.out.println("removing "+ EmployeeList.e.get(i).getEmpId() );
                        EmployeeList.e.remove(i);
                    }
                    else{
                        if(j==i){
                            line += EmployeeList.e.get(i).getEmpId()+";"+EmployeeList.e.get(i).getName()+";"+EmployeeList.e.get(i).getSalary();
                        }
                        else{
                            line += EmployeeList.e.get(i).getEmpId()+";"+EmployeeList.e.get(i).getName()+";"+EmployeeList.e.get(i).getSalary()+"\n";
                        }
                    }
                    System.out.println(EmployeeList.e.get(i).getEmpId()+";"+EmployeeList.e.get(i).getName()+";"+EmployeeList.e.get(i).getSalary());
                }
                line=line.substring(0, line.length()-2);
                File.FileIO.writeInFile(line, "./File/employee.txt", false);

                Employee_management_options p= new Employee_management_options();

                p.setVisible(true);
                this.dispose();
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        Remove_employee_requirement frame = new Remove_employee_requirement();
        frame.setVisible(true);
    }
}




