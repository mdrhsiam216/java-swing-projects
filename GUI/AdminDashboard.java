package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class AdminDashboard extends JFrame implements ActionListener{
    private JLabel adminDashLabel,background;
    private JButton doctBtn;
    private JButton patieBtn;
    private JButton logOutBtn;
    private ImageIcon icon, image;
    private Font f1,f2;
    private JButton addBtn;
    private JButton changePassBtn;
    private String username;

    public AdminDashboard(String username){
        this.username = username;
        this.setSize( 773, 686);
        
        this.setLocationRelativeTo(null);
        adminDashLabel = new JLabel();
        doctBtn = new JButton();
        patieBtn = new JButton();
        addBtn = new JButton();
        logOutBtn = new JButton();
        changePassBtn= new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 20);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        adminDashLabel.setFont(f1); 
        adminDashLabel.setText("Admin Dashboard");
        this.add(adminDashLabel);
        adminDashLabel.setBounds(500, 70, 200, 40);

        doctBtn.setFont(f2);
        doctBtn.setText("Doctor management");
        doctBtn.addActionListener(this);
        this.add(doctBtn);
        doctBtn.setBounds(500, 160, 190, 50);
        doctBtn.setBackground(Color.decode("#2E75B6"));
        
        
        
        patieBtn.setFont(f2); 
        patieBtn.setText("Patient management");
        this.add(patieBtn);
        patieBtn.setBounds(500, 260, 190, 50);
        patieBtn.setBackground(Color.orange);
        patieBtn.addActionListener(this);
        
        
        addBtn.setFont(f2); 
        addBtn.setText("Add admin");
        this.add(addBtn);
        addBtn.setBounds(500, 360, 190, 50);
        addBtn.setBackground(Color.green);
        addBtn.addActionListener(this);
        
        logOutBtn.setBackground(Color.RED);
        logOutBtn.setText("Logout");
        this.add(logOutBtn);
        logOutBtn.setBounds(540, 550, 90, 30);
        logOutBtn.addActionListener(this);
        
        changePassBtn.setFont(f2);
        changePassBtn.setText("change password");
        changePassBtn.addActionListener(this);
        this.add(changePassBtn);
        changePassBtn.setBounds(500, 460, 190, 50);
        changePassBtn.setBackground(Color.decode("#2E75B6"));

        //image
        image = new ImageIcon("./Assets/envio-33 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,773,686);
		background.setIcon(image);
		this.add(background);
        
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logOutBtn){
            this.dispose();
            Login lg = new Login();
        }
        else if(e.getSource()==doctBtn){
            this.dispose();
            DoctMangement d= new DoctMangement(this.username);
        }
        else if (e.getSource() == patieBtn) {
            this.dispose();
            PatientManagement p= new PatientManagement(this.username);
        }
        
        else if(e.getSource()==addBtn){
            this.dispose();
            AddAdmin aa = new AddAdmin(this.username);
        }
        else if(e.getSource()==changePassBtn){
            this.dispose();
            ChangePass c= new ChangePass(this.username);
        }
    }
}
