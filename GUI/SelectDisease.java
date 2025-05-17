package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.Disease;
import EntityList.DiseaseList;

public class SelectDisease extends JFrame implements ActionListener {
    private JLabel diseaseLabel;
    private JScrollPane jScrollPane1;
    private JButton continueBtn;
    private JButton backBtn;
    private String userName;
    private String disease;
    private DefaultTableModel model;
    private JPanel panel;
    private JTable table;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;

    public SelectDisease(String userName) {
        this.userName = userName;
        this.setSize( 794, 710);
        this.setLocationRelativeTo(null);
        setTitle("Select Disease");
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

        diseaseLabel.setText("Select a disease");
        continueBtn.setText("Continue");
        backBtn.setText("Back");

        diseaseLabel.setFont(f1); 

        continueBtn.setBounds(500, 610, 140, 40);
        continueBtn.setBackground(Color.GREEN);
        backBtn.setBounds(150, 610, 130, 40);
        backBtn.setBackground(Color.ORANGE);
        diseaseLabel.setBounds(330, 40, 190, 30);
        jScrollPane1.setBounds(150, 100, 490, 480);


        //table creation
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Disease");

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

        loadDisease();

        this.add(jScrollPane1);
        this.add(continueBtn);
        this.add(backBtn);
        this.add(diseaseLabel);

        backBtn.addActionListener(this);
        continueBtn.addActionListener(this);

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
            Dashboard p = new Dashboard(userName);
        }
        
        else if (e.getSource() == continueBtn) {
            
            int rows[] = table.getSelectedRows();
            if(rows!=null){
                Arrays.sort(rows);
                for(int i= rows.length-1; i>=0;i--){
                    int id = Integer.parseInt(table.getModel().getValueAt(rows[i],0).toString());
                    String name=table.getModel().getValueAt(rows[i],1).toString();
                    System.out.println(name+" "+id);
                    this.disease=name;
                }

                SelectDoctor d= new SelectDoctor(userName,DiseaseList.getDiseaseByname(disease));
                
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "select a disease first",
                            "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        else if(e.getSource()==backBtn){
            this.dispose();
            Dashboard d = new Dashboard(userName);
        }
    }

    void loadDisease(){
        ArrayList diseases = DiseaseList.getDiseaseList();

        for(int i=0; i<diseases.size();i++){
            Disease d= (Disease) diseases.get(i);
            int id = d.getId();
            String name = d.getName();
            model.addRow(new Object[]{id,name});
        }
    }
}
