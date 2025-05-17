package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import File.FileIO;
import Entity.Others;

public class AddOthers extends JFrame implements ActionListener {
    JPanel panel;
    FileIO fileIO = new FileIO();
    Font font = new Font("Segoe UI", Font.PLAIN, 18);

    JLabel nameLabel, priceLabel, expireLabel, companyLabel, typeLabel;

    JTextField nameField, priceField, expireField, companyField, typeField;

    JButton addBtn, cancelBtn;

    ImageIcon image;
    JLabel background;

    public AddOthers() {
        super("Add Others");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocation(200, 100);
        this.setLayout(null);

        // Window Icon
        this.setIconImage(new ImageIcon("./Assets/icon.jpg").getImage());

        // Labels
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 40);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.BLACK);
        this.add(nameLabel);

        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(20, 80, 100, 40);
        priceLabel.setFont(font);
        priceLabel.setForeground(Color.BLACK);
        this.add(priceLabel);

        expireLabel = new JLabel("Expire Date:");
        expireLabel.setBounds(20, 140, 120, 40);
        expireLabel.setFont(font);
        expireLabel.setForeground(Color.BLACK);
        this.add(expireLabel);

        companyLabel = new JLabel("Company:");
        companyLabel.setBounds(20, 200, 100, 40);
        companyLabel.setFont(font);
        companyLabel.setForeground(Color.BLACK);
        this.add(companyLabel);

        typeLabel = new JLabel("Type:");
        typeLabel.setBounds(20, 260, 100, 40);
        typeLabel.setFont(font);
        typeLabel.setForeground(Color.BLACK);
        this.add(typeLabel);

        // Text Fields
        nameField = new JTextField();
        nameField.setBounds(150, 20, 150, 30);
        this.add(nameField);

        priceField = new JTextField();
        priceField.setBounds(150, 80, 150, 30);
        this.add(priceField);

        expireField = new JTextField();
        expireField.setBounds(150, 140, 150, 30);
        this.add(expireField);

        companyField = new JTextField();
        companyField.setBounds(150, 200, 150, 30);
        this.add(companyField);

        typeField = new JTextField();
        typeField.setBounds(150, 260, 150, 30);
        this.add(typeField);

        // Buttons
        addBtn = new JButton("Add Others");
        addBtn.setBounds(150, 340, 150, 40);
        addBtn.setFont(font);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);
        this.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(320, 340, 100, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(Color.ORANGE);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn);

        // Background Image
        image = new ImageIcon("./Assets/syrup.png");
        background = new JLabel();
        background.setBounds(200, 50, 400, 400);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            try {
                // Create an Others object
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String expireDate = expireField.getText();
                String company = companyField.getText();
                String type = typeField.getText();

                Others others = new Others(name, price, expireDate, company, type);

                // Save to file
                saveOthersToFile(others);

                // Confirmation Message
                JOptionPane.showMessageDialog(this, "Others added successfully!");

                // Clear fields
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please check the fields.");
            }
        } else if (e.getSource() == cancelBtn) {
            this.dispose();
            new ManageMedicine();
        }
    }

    private void saveOthersToFile(Others others) {
        String data = others.getName() + ";" +
                others.getPrice() + ";" +
                others.getExpireDate() + ";" +
                others.getCompany() + ";" +
                others.getType();

        fileIO.writeInFile(data, "./File/others.txt", true);
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        expireField.setText("");
        companyField.setText("");
        typeField.setText("");
    }
}
