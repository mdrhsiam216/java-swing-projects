package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame {
    private JPanel panel;
    private JTextField userTF;
    private JPasswordField passTF;
    private JButton lgnBtn;

    public Login() {
        super("User Login");
        this.setSize(600, 400); // Set frame size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Student ID:");
        userLabel.setBounds(50, 50, 150, 30);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(200, 50, 200, 30);
        panel.add(userTF);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 150, 30);
        panel.add(passLabel);

        passTF = new JPasswordField();
        passTF.setBounds(200, 100, 200, 30);
        panel.add(passTF);

        lgnBtn = new JButton("Login");
        lgnBtn.setBounds(200, 150, 100, 40);
        lgnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = userTF.getText();
                String password = new String(passTF.getPassword());

                if (validateLogin(studentID, password)) {
                    
                    openStudentDashboard(studentID);
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid Student ID or Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(lgnBtn);

        this.add(panel);
    }

    private boolean validateLogin(String studentID, String password) {
        
        File userFile = new File("user/users.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            boolean idMatch = false;
            boolean passwordMatch = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Student ID: " + studentID)) {
                    idMatch = true;
                } else if (idMatch && line.contains("Password: " + password)) {
                    passwordMatch = true;
                }

                if (idMatch && passwordMatch) {
                    return true; // Login successful
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false; // Login failed
    }

    private void openStudentDashboard(String studentID) {
        
        dispose(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}
