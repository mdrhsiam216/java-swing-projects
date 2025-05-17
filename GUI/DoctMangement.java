package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Entity.Doctor;
import Entity.Person;
import EntityList.DoctorList;
import File.FileIO;

public class DoctMangement extends JFrame implements ActionListener {
    private DefaultTableModel model;
    private JPanel panel;
    private JTable table;
    private ImageIcon icon,image;
    private JLabel background;
    private JButton backBtn;
    private JButton delBtn;
    private JButton addBtn;
    private JLabel manageDocLabel;
    private Font f1,f2;
    private String username;
    
    public DoctMangement(String username) {
        this.setSize( 794, 710);
        this.username = username;
        
        this.setLocationRelativeTo(null);
        setTitle("Select Disease");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);
        
        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        manageDocLabel = new JLabel();
        backBtn = new JButton();
        
        delBtn = new JButton();
        delBtn.setBounds(390, 110, 100, 40);
        delBtn.setBackground(Color.RED);
        delBtn.setText("Delete");
        delBtn.addActionListener(this);
        
        
        addBtn = new JButton();
        panel = new JPanel();
        
        backBtn.setBounds(130, 110, 100, 40);
        addBtn.setBounds(260, 110, 100, 40);
        
        backBtn.setBackground(Color.ORANGE);
        addBtn.setBackground(Color.GREEN);
        
        
        
        setTitle("Manage Doctor");
        
        manageDocLabel.setFont(f1);
        
        manageDocLabel.setText("Manage Doctor");
        backBtn.setText("go back");
        addBtn.setText("add doctor");
        
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);
        
        
        createTable();
        loadDoc();
        this.add(backBtn);
        this.add(manageDocLabel);
        this.add(addBtn);
        this.add(delBtn);
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
            this.dispose(); // Dispose of the current frame once
            AdminDashboard p = new AdminDashboard(username);
        }
        
        else if (e.getSource() == delBtn) {
            int rows[] = table.getSelectedRows();
			if(rows!=null){
                Arrays.sort(rows);
				for(int i= rows.length-1; i>=0;i--){
                    String docName=table.getModel().getValueAt(rows[i],1).toString();
                    DoctorList.delDocByName(docName);
                    System.out.println("object deleted");
                    
                    System.out.println(docName + " deleted");
                    //have to delete object
                    DoctorList.delDocByName(docName);
                    model.removeRow(rows[i]);

                    updateFile();
				}
			}
        }
        
        else if(e.getSource()==addBtn){
            this.dispose();
            AddDoctor ad=new AddDoctor(this.username);
        }
    }

    public void createTable() { 
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Doctor");
        model.addColumn("speciality");

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

    void loadDoc(){
        ArrayList <Person> doctors = DoctorList.doctors;
        for(int i=0; i<doctors.size();i++){
            Doctor d =  (Doctor)doctors.get(i);
            int id =(int) d.getId();
            String name = d.getName();
            String speci= d.getSpecialty();
            model.addRow(new Object[]{id,name,speci});
        }
    }

    public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
        ArrayList fileData= FileIO.readDoctor();
			for(int i= 0; i < rows; i++){
				String line;

                String id = table.getModel().getValueAt(i,0).toString();
				String name = table.getModel().getValueAt(i,1).toString();
				
                String s= fileData.get(i).toString();
                String[] temp = s.split(";");
                System.out.println("comparing "+temp[1]+" vs "+name);
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
			FileIO.writeInFile(allLines,"./File/doctors.txt",false);
	}
}
