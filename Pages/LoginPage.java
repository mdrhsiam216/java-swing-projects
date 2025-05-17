package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JPanel panel;
    private JLabel title, studentIDLabel, passwordLabel;
    private JTextField studentIDField;
    private JPasswordField passwordField;
    private JButton loginButton, backButton; // Added backButton field

    public LoginPage() {
        setTitle("Login Form");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("Images/BgReg.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(null);

        
		 backButton = new JButton();
        ImageIcon arrowIcon = new ImageIcon("Images/arrow.png"); 
       
        Image scaledArrowImage = arrowIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledArrowIcon = new ImageIcon(scaledArrowImage);
        backButton.setIcon(scaledArrowIcon);
        backButton.setBounds(20, 20, 30, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomePage homePage = new WelcomePage(); 
                homePage.setVisible(true); 
                dispose(); 
            }
        });
        panel.add(backButton);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(500, 50, 200, 40);
        panel.add(title);

        int xLabel = 300;
        int xField = 500;
        int yStart = 200;
        int yGap = 60;

        studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setForeground(Color.WHITE);
        studentIDLabel.setBounds(xLabel, yStart, 150, 30);
        panel.add(studentIDLabel);

        studentIDField = new JTextField();
        studentIDField.setBounds(xField, yStart, 300, 30);
        panel.add(studentIDField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(xLabel, yStart + yGap, 150, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(xField, yStart + yGap, 300, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(500, yStart + 2 * yGap, 150, 40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (!studentID.isEmpty() && !password.isEmpty()) {
                    if (studentID.equals("12345") && password.equals("admin")) {
                        
                        Admindashboard adminDashboard = new Admindashboard();
                        adminDashboard.setVisible(true);
                    } else {
                       
                        StudentDashboard studentDashboard = new StudentDashboard(studentID);
                        studentDashboard.setVisible(true);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });
    }
}
