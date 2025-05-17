package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Disease;
import Entity.Doctor;
import EntityList.DoctorList;
import File.FileIO;

public class SelectDoctor extends JFrame implements ActionListener {
    private JLabel diseaseLabel;
    private JScrollPane jScrollPane1;
    private JButton continueBtn;
    private JButton backBtn;
    private String userName;
    private Disease disease;
    private DefaultTableModel model;
    private JPanel panel;
    JTable table;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;

    public SelectDoctor(String userName, Disease disease) {
        this.userName = userName;
        this.disease = disease;
        this.setSize( 794, 710);
        this.setLocationRelativeTo(null);
        setTitle("select doctor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 20);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        diseaseLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        continueBtn = new JButton();
        backBtn = new JButton();
        panel = new JPanel();

        diseaseLabel.setText("Select a Doctor");
        continueBtn.setText("continue");
        backBtn.setText("Back");

        diseaseLabel.setFont(f1); 

        continueBtn.setBounds(500, 610, 140, 40);
        continueBtn.setBackground(Color.GREEN);
        backBtn.setBounds(150, 610, 130, 40);
        backBtn.setBackground(Color.ORANGE);
        diseaseLabel.setBounds(330, 40, 160, 30);
        jScrollPane1.setBounds(150, 100, 490, 480);

        createTable();
        loadDoctor();

        this.add(jScrollPane1);
        this.add(continueBtn);
        this.add(backBtn);
        this.add(diseaseLabel);

        backBtn.addActionListener(this);
        continueBtn.addActionListener(this);

        //image
        image = new ImageIcon("./Assets/flat-lay-medical-elements-composition-with-coronavirus-tag-notepad_23-2148502913 (1).jpg");
        background = new JLabel();
        background.setBounds(0,0,794,710);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            this.dispose();
            Dashboard p = new Dashboard(userName);
        }
        
        else if (e.getSource() == continueBtn) {
            int rows[] = table.getSelectedRows();
            String doc="";
            String fee="";

            if(rows!=null){
                Arrays.sort(rows);
                for(int i= rows.length-1; i>=0;i--){
                    int id = Integer.parseInt(table.getModel().getValueAt(rows[i],0).toString());
                    doc=table.getModel().getValueAt(rows[i],1).toString();
                    fee= table.getModel().getValueAt(rows[i],4).toString();
                }
                this.dispose();
                Confirm c= new Confirm(userName, DoctorList.getDocByname(doc), disease);
            }

            else{
                JOptionPane.showMessageDialog(this, "select a doctor first",
                "Error", JOptionPane.WARNING_MESSAGE);
            }

        }

        else if(e.getSource()==backBtn){
            this.dispose();
            Dashboard d = new Dashboard(userName);
        }
    }

    public void createTable() { 
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Speciality");
        model.addColumn("Time");
        model.addColumn("Free");


        table = new JTable(model);
		table.setBounds(330, 40, 160, 30);
		table.setRowHeight(30);
        table.setBackground(new Color(174,247,255));
		table.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(150, 100, 490, 480);
		
        
        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }


    void loadDoctor(){
        //here goes the code to add doctor
        //sample:

        // model.addRow(new Object[]{int, str});
        //run this line as much as you want
        
        ArrayList doctors = DoctorList.getDocList();
        for(int i=0; i<doctors.size();i++){
            Doctor d =  (Doctor)doctors.get(i);
            if(disease.getName().equals(d.getSpecialty())){
                int id = d.getId();
                String name = d.getName();
                String speci= d.getSpecialty();
                String time = "6 pm";
                int fee = d.getFee();
                model.addRow(new Object[]{id,name,speci,time,fee});
            }
        }
    }
}
