package GUI;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import Entity.Disease;
import Entity.Doctor;
import File.FileIO;

public class Confirm extends JFrame implements ActionListener{
    private JLabel confirmAppLabel;
    private JLabel DrLabel;
    private JLabel BCSLabel;
    private JLabel feeLabel;
    private JButton confBookBtn;
    private JLabel patientLabel;
    private JButton cancelBtn;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;
    String userName;
    Doctor doc;
    Disease disease;

    public Confirm(String userName,Doctor doc,Disease disease){
        this.userName = userName;
        this.doc = doc;
        this.disease = disease;
        this.setSize(784,682);
        
        this.setLocationRelativeTo(null);
        setTitle("confirm appointment");

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());
        
        confirmAppLabel = new JLabel();
        DrLabel = new JLabel();
        BCSLabel = new JLabel();
        feeLabel = new JLabel();
        confBookBtn = new JButton();
        cancelBtn = new JButton();
        patientLabel = new JLabel();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        patientLabel.setFont(f1); // NOI18N
        confirmAppLabel.setFont(f1); // NOI18N
        DrLabel.setFont(f2); // NOI18N
        BCSLabel.setFont(f2); // NOI18N
        this.add(confirmAppLabel);
        
        DrLabel.setText("Dr. "+doc.getName());
        BCSLabel.setText("BCS health, DMC");
        confirmAppLabel.setText("Confirm Appointment");
        feeLabel.setText("fee: "+doc.getFee()+" bdt");
        confBookBtn.setText("confirm & book");
        cancelBtn.setText("cancel");
        patientLabel.setText("patient: " + userName);
        
        confirmAppLabel.setBounds(250, 80, 210, 30);
        DrLabel.setBounds(300, 230, 280, 40);
        BCSLabel.setBounds(280, 250, 260, 40);
        patientLabel.setBounds(270, 160, 150, 40);
        confBookBtn.setBounds(240, 400, 150, 50);
        confBookBtn.setFont(new java.awt.Font("Segoe UI", 0, 16));
        // confBookBtn.setBackground(Color.decode("#2E75B6"));
        confBookBtn.setBackground(Color.GREEN);
        feeLabel.setBounds(295, 340, 90, 30);
        cancelBtn.setBounds(280, 490, 90, 50);
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 16));
        cancelBtn.setBackground(Color.RED);


        this.add(DrLabel);
        this.add(BCSLabel);
        this.add(feeLabel);
        this.add(confBookBtn);
        this.add(cancelBtn);
        this.add(patientLabel);
        confBookBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        //image
        image = new ImageIcon("./Assets/sss.jpg");
        background = new JLabel();
        background.setBounds(0,0,784,682);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confBookBtn) {
            String ine = userName+";"+ doc.getName()+  ";" +disease.getName() +  ";" + doc.getFee();
            FileIO.writeInFile(ine, "./File/appointment.txt", true);
            ImageIcon icon = new ImageIcon("./Assets/gettyimages-182436004-612x612-removebg-preview (1).png");
            JLabel label = new JLabel("Appointment Confirmed and Booked Successfully!", icon, JLabel.CENTER);
            JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            Dashboard d= new Dashboard(userName);
        }
        else if (e.getSource() == cancelBtn){
            this.dispose();
            Dashboard d= new Dashboard(userName);
        }
    }

}
