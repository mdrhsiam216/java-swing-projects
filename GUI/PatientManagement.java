package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Patient;
import EntityList.PatientList;
import File.FileIO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PatientManagement extends JFrame implements ActionListener{
    private DefaultTableModel model;
    private JPanel panel;
    private JTable table;
    private ImageIcon icon,image;
    private JLabel background;
    private JButton backBtn;
    private JButton delBtn;
    private JLabel managePatLabel;
    private Font f1,f2;
    private String username;


    public PatientManagement(String username){
        this.username = username;
        this.setSize( 794, 710);
        this.setLocationRelativeTo(null);
        setTitle("Select Disease");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);
        
        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        managePatLabel = new JLabel();
        backBtn = new JButton();
        delBtn = new JButton();
        panel = new JPanel();

        backBtn.setBounds(130, 110, 100, 40);
        delBtn.setBounds(390, 110, 100, 40);

        backBtn.setBackground(Color.ORANGE);
        delBtn.setBackground(Color.GREEN);
        


        setTitle("Manage Patient");
        
        managePatLabel.setFont(f1); 
        
        managePatLabel.setText("Manage Patient");
        backBtn.setText("go back");
        delBtn.setText("Delete");
        
        createTable();
        loadPatients();
        this.add(delBtn);
        this.add(backBtn);
        this.add(managePatLabel);
        this.add(delBtn);
        this.add(backBtn);
        
        backBtn.addActionListener(this);
        delBtn.addActionListener(this);
        
        //image
        image = new ImageIcon("./Assets/flat-lay-medical-desk-composition-with-copy-space_23-2148502943 (1).jpg");
        background = new JLabel();
        background.setBounds(0,0,794,710);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            AdminDashboard p = new AdminDashboard(this.username);
        }
        
        else if (e.getSource() == delBtn) {
            int rows[] = table.getSelectedRows();
			if(rows!=null){
                Arrays.sort(rows);
				for(int i= rows.length-1; i>=0;i--){
                    String patName=table.getModel().getValueAt(rows[i],1).toString();
                    PatientList.delPatByName(patName);
                    System.out.println("object deleted");
                    
                    System.out.println(patName + " deleted");
                    model.removeRow(rows[i]);

                    updateFile();
				}
            }
        }
    }

    public void createTable() { 
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");

        table = new JTable(model);
		table.setBounds(330, 40, 160, 30);
		table.setRowHeight(30);
        table.setBackground(new Color(174,247,255));
		table.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(130, 170, 490, 480);
		
        
        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    void loadPatients(){
        ArrayList patients = PatientList.getPatients();
        for(int i=0; i<patients.size();i++){
            Patient d =  (Patient)patients.get(i);

            int id = d.getId();
            String name = d.getName();
            model.addRow(new Object[]{id,name});
        }
    }

    public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
        ArrayList fileData= FileIO.readFIle("./File/patient.txt");
			for(int i= 0; i < rows; i++){
				String line;

                String id = table.getModel().getValueAt(i,0).toString();
				String name = table.getModel().getValueAt(i,1).toString();
				
                String s= fileData.get(i).toString();
                String[] temp = s.split(";");
                System.out.println("comparing "+temp[0]+" vs "+name);
                if(!temp[1].equals(name)){
                    if(i<rows-1){
                        line = s+ "\n";
                    }
                    else{
                        line =s;
                    }
                    allLines += line;
                }
			}
			FileIO.writeInFile(allLines,"./File/patient.txt",false);
	}
}
