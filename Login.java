import java.awt.*;
import javax.swing.*;

import Data.FileIO;

import java.awt.event.*;

public class Login extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel, background;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1;
    private JButton btn1, btn2, btn3, nBtn;
    private JPasswordField tf2;
    private Cursor cursor;
    ImageIcon image;

    Login() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("LogIn");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // label
        label1 = new JLabel();
        label1.setText("User Login");
        label1.setBounds(200, 50, 500, 90);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(100, 200, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(300, 210, 200, 35);
        tf1.setFont(f5);
        c.add(tf1);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(100, 270, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(300, 280, 200, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        c.add(tf2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(90, 450, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(340, 450, 215, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.BLACK);
        btn2.setBackground(Color.white);
        c.add(btn2);

        btn3 = new JButton("Login");
        btn3.setBounds(590, 450, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.BLACK);
        btn3.setBackground(Color.WHITE);
        c.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        image = new ImageIcon("./images/vecteezy_travel-banner-tourism-background-vector-summer-vacation_7096303 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,1000,600);
		background.setIcon(image);
		// this.add(background);
        c.add(background);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        // Login Button
btn3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        String textField1 = tf1.getText().toLowerCase(); // User Name 
        String textField2 = tf2.getText(); // Password

        if (textField1.isEmpty() || textField2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String userNameS = textField1;
            String passwordS = textField2;

            int flag = FileIO.checkUser(userNameS, passwordS, "./Data/user.txt");

            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Login Successful.", "Travel Agency!",
                        JOptionPane.WARNING_MESSAGE);
                setVisible(false);
                Packs frame = new Packs();
                frame.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "password didn't match", "invalid password",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
});

    }

    public static void main(String[] args) {

        Login frame = new Login();
        frame.setVisible(true);
    }
}
