package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Employee;
import EntityList.EmployeeList;
import File.FileIO;

public class Show_all_employee extends JFrame implements ActionListener {
    JButton Search,Back;
    ImageIcon image;
    JLabel background;
    JPanel panel;

    JTable table,table1;
    DefaultTableModel model,model1;
    JScrollPane scrollPane;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Show_all_employee(){
        super("Show_all_employee page");
        System.out.println("show all employee");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());
        
        Back = new JButton("Back");
        Back.setBounds(350, 480, 120, 40);
        Back.setFont(font);
        Back.setBackground(new Color(92, 101, 204));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        this.add(Back); 

        panel = new JPanel();

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Salary");

        table.setModel(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 400, 300);
		table.setRowHeight(30);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(180, 96, 578, 300);
        scrollPane.setBackground(Color.WHITE);
        this.add(scrollPane);
        createTable();

        EmployeeList.e.clear();
        loadEmployee();

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            Employee_management_options frame = new Employee_management_options();
            this.dispose();
        }
    }

    public void createTable() {
        ArrayList<Employee> allTeam = EmployeeList.e;
        
        for (int i=0;i<allTeam.size();i++) {
                model.addRow(new Object[]{allTeam.get(i).getEmpId(),allTeam.get(i).getName(),allTeam.get(i).getSalary()});
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

    public static void main(String[] args) {
        Show_all_employee frame = new Show_all_employee();
        frame.setVisible(true);
    }
}





