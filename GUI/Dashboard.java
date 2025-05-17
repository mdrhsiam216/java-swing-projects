package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Dashboard extends JFrame implements ActionListener{
    private String userName;
    private JButton appointBtn;
    private JButton myAppointBtn;
    private JButton logOutBtn;
    private JLabel welcomeLabel;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;

    public Dashboard(String userName){
        this.userName = userName;
        this.setSize(784,682);
        
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Patient Dashboard");
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());
        
        appointBtn = new JButton();
        myAppointBtn = new JButton();
        logOutBtn = new JButton();
        welcomeLabel = new JLabel();
        
        appointBtn.setText("Book an Appointment");
        myAppointBtn.setText("My Appointments");
        logOutBtn.setText("Logout");
        welcomeLabel.setText("Welcome "+userName);
        

        appointBtn.setFont(f2); 
        myAppointBtn.setFont(f2); 
        welcomeLabel.setFont(f2); 

        
        appointBtn.setBounds(290, 180, 220, 70);
        appointBtn.setBackground(Color.decode("#2E75B6"));
        myAppointBtn.setBounds(290, 310, 220, 70);
        myAppointBtn.setBackground(Color.ORANGE);
        
        logOutBtn.setBounds(350, 490, 90, 40);
        logOutBtn.setBackground(Color.RED);
        welcomeLabel.setBounds(350, 90, 190, 40);

        this.add(logOutBtn);
        this.add(appointBtn);
        this.add(myAppointBtn);
        this.add(welcomeLabel);
        appointBtn.addActionListener(this);
        myAppointBtn.addActionListener(this);
        logOutBtn.addActionListener(this);

        //image
        image = new ImageIcon("./Assets/arrangement-medical-objects-with-empty-notebook_23-2148502961 (1).jpg");
        background = new JLabel();
        background.setBounds(0,0,784,682);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logOutBtn) {
            this.dispose();
            Login loginPage = new Login();
        }
        else if(e.getSource()==appointBtn){
            this.dispose();
            SelectDisease d= new SelectDisease(userName);
        }
        else if(e.getSource()==myAppointBtn){
            this.dispose();
            Appointments a= new Appointments(userName);
            
        }
    }

}
