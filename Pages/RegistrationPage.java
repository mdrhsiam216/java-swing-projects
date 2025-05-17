package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import Classes.Account;

public class RegistrationPage extends JFrame {
    private JPanel panel;
    private JLabel title, usernameLabel, phoneNumberLabel, studentIDLabel, vehicleInfoLabel, paymentMethodLabel, passwordLabel, uploadImageLabel;
    private JTextField usernameField, phoneNumberField, studentIDField, vehicleInfoField, paymentMethodField;
    private JPasswordField passwordField;
    private JButton submitButton,uploadButton,backButton;
	   private File selectedImageFile;

    public RegistrationPage() {
        setTitle("Registration Form");
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

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(450, 50, 300, 40); 
        panel.add(title);

        int xLabel = 300;
        int xField = 500;
        int yStart = 120;
        int yGap = 60;

        // Username
        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(xLabel, yStart, 150, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(xField, yStart, 300, 30);
        panel.add(usernameField);

        // Phone Number
        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setBounds(xLabel, yStart + yGap, 150, 30);
        panel.add(phoneNumberLabel);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(xField, yStart + yGap, 300, 30);
        panel.add(phoneNumberField);

        // Student ID
        studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setForeground(Color.WHITE);
        studentIDLabel.setBounds(xLabel, yStart + 2 * yGap, 150, 30);
        panel.add(studentIDLabel);

        studentIDField = new JTextField();
        studentIDField.setBounds(xField, yStart + 2 * yGap, 300, 30);
        panel.add(studentIDField);

        // Vehicle Information
        vehicleInfoLabel = new JLabel("Vehicle Information:");
        vehicleInfoLabel.setForeground(Color.WHITE);
        vehicleInfoLabel.setBounds(xLabel, yStart + 3 * yGap, 200, 30);
        panel.add(vehicleInfoLabel);

        vehicleInfoField = new JTextField();
        vehicleInfoField.setBounds(xField, yStart + 3 * yGap, 300, 30);
        panel.add(vehicleInfoField);

        // Payment Method
        paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setForeground(Color.WHITE);
        paymentMethodLabel.setBounds(xLabel, yStart + 4 * yGap, 200, 30);
        panel.add(paymentMethodLabel);

        paymentMethodField = new JTextField();
        paymentMethodField.setBounds(xField, yStart + 4 * yGap, 300, 30);
        panel.add(paymentMethodField);

        // Password
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(xLabel, yStart + 5 * yGap, 150, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(xField, yStart + 5 * yGap, 300, 30);
        panel.add(passwordField);

        // Submit Button
		
        uploadImageLabel = new JLabel("Upload Image:");
        uploadImageLabel.setForeground(Color.WHITE);
        uploadImageLabel.setBounds(xLabel, yStart + 6 * yGap, 150, 30);
        panel.add(uploadImageLabel);

        uploadButton = new JButton("Choose Image");
        uploadButton.setFont(new Font("Arial", Font.PLAIN, 18));
        uploadButton.setBounds(xField, yStart + 6 * yGap, 150, 30);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                }
            }
        });
        panel.add(uploadButton);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBounds(500, yStart + 7 * yGap, 150, 40); 
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    if (!userExists(studentIDField.getText())) {
                        registerUser();
                    } else {
                        JOptionPane.showMessageDialog(panel, "User with the same Student ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(submitButton);

        getContentPane().add(panel);
    }



    private boolean validateFields() {
        String username = usernameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String studentID = studentIDField.getText();
        String vehicleInfo = vehicleInfoField.getText();
        String paymentMethod = paymentMethodField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (username.isEmpty() || phoneNumber.isEmpty() || studentID.isEmpty() ||
            vehicleInfo.isEmpty() || paymentMethod.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(panel, "Invalid phone number format. Please enter 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidStudentID(studentID)) {
            JOptionPane.showMessageDialog(panel, "Invalid student ID format. Please use format xx-xxxxx-x.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 11 && phoneNumber.matches("[0-9]+");
    }

    private boolean isValidStudentID(String studentID) {
        return studentID.matches("\\d{2}-\\d{5}-\\d");
    }

    private void registerUser() {
        String username = usernameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String studentID = studentIDField.getText();
        String vehicleInfo = vehicleInfoField.getText();
        String paymentMethod = paymentMethodField.getText();
        String password = String.valueOf(passwordField.getPassword());
		String parkingLotNumber = generateRandomParkingLot();

        Account account = new Account(username, phoneNumber, studentID, vehicleInfo, paymentMethod, password, parkingLotNumber);
        account.addAccount();
		saveUserImage(studentID);

       int option = JOptionPane.showOptionDialog(panel, "Registration successful! Information saved.", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, "OK");
		if (option == JOptionPane.OK_OPTION) {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            dispose(); 
        }
    }
	
	private String generateRandomParkingLot() {
    int parkingLotSuffix = (int) (Math.random() * 90) + 10; // Random number between 10 and 99
    return "A-" + parkingLotSuffix;
}
	
	private void saveUserImage(String studentID) {
        File imageFolder = new File("Images");
        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }

        
        File userImageFolder = new File(imageFolder, studentID);
        if (!userImageFolder.exists()) {
            userImageFolder.mkdir();
        }

        
        File imageFile = new File(userImageFolder, "profile.jpg");
        try {
            Files.copy(selectedImageFile.toPath(), imageFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel, "Failed to save image.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public boolean userExists(String studentID) {
    boolean exists = false;
    File file = new File(".\\Users\\user.txt");

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split("\t");

            if (values.length >=4 && values[2].equals(studentID)) {
                exists = true;
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return exists;
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.setVisible(true);
        });
    }
}
