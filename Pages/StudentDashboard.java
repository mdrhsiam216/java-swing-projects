package Pages;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JButton logoutButton;
    private JButton editButton;
    private JLabel profilePictureLabel;
    private JPanel userInfoPanel;
	private Color myclr1;

    public StudentDashboard(String studentID) {
        setTitle("Student Dashboard");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
		myclr1 = new Color(140, 230, 168);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(myclr1);
        headerPanel.setPreferredSize(new Dimension(1200, 150)); // Increased height
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Added padding

        
        try {
            File profileFolder = new File("Images/" + studentID);
            File[] profileFiles = profileFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpeg"));
            
            if (profileFiles != null && profileFiles.length > 0) {
                BufferedImage profileImage = ImageIO.read(profileFiles[0]);
                profilePictureLabel = new JLabel();
                profilePictureLabel.setIcon(new ImageIcon(getScaledImage(profileImage, 100, 100))); // Scale the profile picture
                profilePictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
                profilePictureLabel.setVerticalAlignment(SwingConstants.CENTER);
                profilePictureLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for circular effect
                headerPanel.add(profilePictureLabel, BorderLayout.WEST);
            } else {
                
                profilePictureLabel = new JLabel("Profile Picture");
                profilePictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
                profilePictureLabel.setVerticalAlignment(SwingConstants.CENTER);
                profilePictureLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for circular effect
                headerPanel.add(profilePictureLabel, BorderLayout.WEST);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Username Label
        usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Add left margin for username
        headerPanel.add(usernameLabel, BorderLayout.CENTER);

        // Logout and Edit Buttons
		logoutButton = new JButton("Logout");
		 logoutButton.setBounds(440, 200, 100, 10);
		 logoutButton.setBackground(myclr1);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Century", Font.BOLD, 18));
		logoutButton.setBorderPainted(false); 
        headerPanel.add(logoutButton, BorderLayout.EAST);
		
		logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                dispose();
            }
        });




        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Panel for User Info
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        // User Info Panel
        userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(0, 1, 10, 10));
        userInfoPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Student Information"),
                BorderFactory.createEmptyBorder(10, 20, 20, 20)
        ));
        centerPanel.add(userInfoPanel, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

       
        loadUserInfo(studentID);

        getContentPane().add(mainPanel);
    }

   private void loadUserInfo(String studentID) {
    String filePath = "Users/user.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split("\t");
            if (userInfo.length >= 7 && userInfo[2].equals(studentID)) {
                usernameLabel.setText("Welcome, " + userInfo[0]);
                addUserInfo("Phone Number:", userInfo[1]);
                addUserInfo("Student ID:", userInfo[2]);
                addUserInfo("Vehicle Information:", userInfo[3]);
                addUserInfo("Payment Method:", userInfo[4]);
                addUserInfo("Parking Lot Number:", userInfo[6]); 
                break; 
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void addUserInfo(String labelText, String value) {
    JLabel infoLabel = new JLabel(labelText);
    infoLabel.setForeground(Color.WHITE);
    infoLabel.setFont(new Font("Arial", Font.BOLD, 30));

    JLabel valueLabel = new JLabel(value);
    valueLabel.setForeground(Color.WHITE);
    valueLabel.setFont(new Font("Arial", Font.BOLD, 30));

    JPanel userInfoEntry = new JPanel(new BorderLayout());
    userInfoEntry.setBackground(myclr1); 
    userInfoEntry.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    userInfoEntry.add(infoLabel, BorderLayout.WEST);
    userInfoEntry.add(valueLabel, BorderLayout.CENTER);

    userInfoPanel.add(userInfoEntry);
}


    
    private Image getScaledImage(Image srcImg, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
        });
    }
}
