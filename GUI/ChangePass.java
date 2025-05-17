package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import File.FileIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangePass extends JFrame implements ActionListener{
    private JLabel adminSignupLabel,background;
    private JButton backBtn;
    private JLabel usernamelabel;
    private JButton addBtn;
    private JLabel passlabel;
    private JPasswordField passfield;
    private JTextField pass1;
    private ImageIcon icon,image;
    private Font f1,f2;
    private String username;

    public  ChangePass(String username){
        this.username=username;
        adminSignupLabel = new JLabel();
        backBtn = new JButton();
        addBtn = new JButton();
        usernamelabel = new JLabel();
        passlabel = new JLabel();
        pass1 = new JTextField();
        passfield = new JPasswordField();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Change Password");
        setSize(871,  520);
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        f1 = new Font("Segoe UI Black", Font.BOLD, 23);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        adminSignupLabel.setFont(f1);
        adminSignupLabel.setText("Change password");
        this.add(adminSignupLabel);
        adminSignupLabel.setBounds(380, 55, 180, 30);

        backBtn.setText("Back");
        backBtn.setFont(f2);
        backBtn.setBackground(Color.RED);
        backBtn.addActionListener(this);
        this.add(backBtn);
        backBtn.setBounds(320, 310, 100, 40);

        addBtn.setText("update");
        addBtn.setFont(f2);
        addBtn.setBackground(Color.ORANGE);
        addBtn.addActionListener(this);
        this.add(addBtn);
        addBtn.setBounds(470, 310, 120, 40);

        usernamelabel.setText("new password");
        usernamelabel.setFont(f2);
        this.add(usernamelabel);
        usernamelabel.setBounds(310, 170, 80, 30);

        passlabel.setText("condfirm password");
        passlabel.setFont(f2);
        this.add(passlabel);
        passlabel.setBounds(310, 240, 70, 30);

        this.add(pass1);
        pass1.setBounds(390, 170, 170, 40);

        this.add(passfield);
        passfield.setBounds(390, 230, 170, 40);

        //image
        image = new ImageIcon("./Assets/envio-42k (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,871,520);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBtn){
            this.dispose();
            AdminDashboard d= new AdminDashboard(username);
        }
        else if(e.getSource()==addBtn){
            if(pass1.getText().isEmpty() || passfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fields cannot be empty!");
            }
            else{
                String pass = pass1.getText();
                String confpass = passfield.getText();
                if(pass.equals(confpass)){
                    ArrayList <String> lines = FileIO.readFIle("./File/admin.txt");
                    String c="";
                    for(String a: lines){
                        String[] b = a.split(";");
                        if(b[0].equals(this.username)){
                            // System.out.println("comparing with "+ username+" and "+ );
                            c+= username+";"+confpass+"\n";
                        }
                        else{
                            c+=a+"\n";
                        }
                    }
                    c= c.substring(0, c.length() - 1);
                    FileIO.writeInFile("","./File/admin.txt", false);
                    FileIO.writeInFile(c,"./File/admin.txt", false);
                    this.dispose();
                    ImageIcon icon = new ImageIcon("./Assets/gettyimages-182436004-612x612-removebg-preview (1).png");
                    JLabel label = new JLabel("password changed", icon, JLabel.CENTER);
                    JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.PLAIN_MESSAGE);
                    AdminDashboard d=new AdminDashboard(this.username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"password didn't match");
                }
            }
            
        }
    }
}
