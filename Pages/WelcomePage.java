package Pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame {
    private JPanel panel;
    private JLabel userLabel, imgLabel1, imgLabel2;
    private JButton lgnBtn, registerBtn;
    private Color myColor1, myColor2, clr3;
    private Font myFont;
    private ImageIcon img;

    public WelcomePage() {
        super("AIUB Parking Management System");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myColor1 = new Color(0, 0, 0);
        myColor2 = new Color(238, 253, 111);
		clr3 = new Color(255, 255, 204);

        panel = new JPanel();
        panel.setLayout(null);

       
        lgnBtn = new JButton("Login");
        lgnBtn.setBounds(750, 500, 150, 35);
        lgnBtn.setBackground(myColor2);
        lgnBtn.setForeground(myColor1);
        lgnBtn.setFont(new Font("Century", Font.BOLD, 18));
        panel.add(lgnBtn);

        registerBtn = new JButton("Register");
        registerBtn.setFont(new Font("Century", Font.BOLD, 18));
        registerBtn.setBounds(930, 500, 150, 35);
        registerBtn.setBackground(myColor2);
		registerBtn.setForeground(myColor1);

        panel.add(registerBtn);

   

        img = new ImageIcon("Images/BGG.png");
        imgLabel2 = new JLabel(img);
        imgLabel2.setBounds(0, 0, 1200, 800);
        panel.add(imgLabel2);

        this.add(panel);

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrationPage registrationFrame = new RegistrationPage();
                registrationFrame.setVisible(true);
                dispose();
            }
        });

        lgnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginFrame = new LoginPage();
                loginFrame.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        WelcomePage wc = new WelcomePage();
        wc.setVisible(true);
    }
}
