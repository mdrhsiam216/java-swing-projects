package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import EntityList.DoctorList;
import File.FileIO;

public class Appointments extends JFrame implements ActionListener{
    private JLabel appointLabel;
    private JScrollPane jScrollPane1;
    private JButton backBtn;
    private String userName;
    private DefaultTableModel model;
    private JPanel panel;
    private JTable table;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;
    private JButton delBtn;

    public Appointments(String username){
        this.userName = username;
        
        this.setSize(794, 710);
        this.setLocationRelativeTo(null);
        setTitle("Appointments");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 20);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 18);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        appointLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        backBtn = new JButton();
        panel = new JPanel();

        delBtn = new JButton();
        delBtn.setBounds(300, 610, 130, 40);
        delBtn.setBackground(Color.RED);
        delBtn.setText("Delete");
        delBtn.addActionListener(this);
        
        appointLabel.setText("Your appointments");
        backBtn.setText("Back");
        
        appointLabel.setFont(f1); 
        
        backBtn.setBounds(150, 610, 130, 40);
        backBtn.setFont(f2);
        backBtn.setBackground(Color.decode("#2E75B6"));
        appointLabel.setBounds(330, 40, 220, 30);
        jScrollPane1.setBounds(150, 100, 490, 480);
        
        createTable();
        loadAppointment();
        
        this.add(delBtn);
        this.add(jScrollPane1);
        this.add(backBtn);
        this.add(appointLabel);
        
        //image
        image = new ImageIcon("./Assets/arrangement-medical-objects-with-empty-frame_23-2148502962 (1).jpg");
        background = new JLabel();
        background.setBounds(0,0,794,710);
        background.setIcon(image);
        this.add(background);

        backBtn.addActionListener(this);

        this.setVisible(true);
    }

    private void loadAppointment() {
        ArrayList line = FileIO.readAppointment(userName);
        for(int i=0; i<line.size();i++){
            String cols[] = ((String) line.get(i)).split(";");
            String doc = cols[1];
            String problem = cols[2];
            String fee= cols[3];
            
            model.addRow(new Object[]{doc,problem,fee});
        }
    }

    public void createTable() { 
        model = new DefaultTableModel();
        model.addColumn("Doctor");
        model.addColumn("Disease");
        model.addColumn("Time");
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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBtn){
            this.dispose();
            Dashboard d= new Dashboard(userName);
        }
        else if(e.getSource()==delBtn){
            int rows[] = table.getSelectedRows();
			if(rows!=null){
                ArrayList <String> lines = FileIO.readFIle("./File/appointment.txt");
                String rep="";
                Arrays.sort(rows);
				for(int i= rows.length-1; i>=0;i--){
                    String docName=table.getModel().getValueAt(rows[i],0).toString();
                    for (String a : lines) {
                        String b[] = a.split(";");
                        if(!b[1].equals(docName)){
                            rep+=a+"\n";
                        }
                    }
                    model.removeRow(rows[i]);
				}
                rep=rep.substring(0, rep.length() - 1);
                FileIO.writeInFile("","./File/appointment.txt", false);
                FileIO.writeInFile(rep,"./File/appointment.txt", false);
			}
        }
    }
}
