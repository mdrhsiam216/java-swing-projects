package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import File.FileIO;
import Entity.Syrup;

public class AddSyrup extends JFrame implements ActionListener {
    JPanel panel;
    FileIO fileIO = new FileIO();
    Font font = new Font("Segoe UI", Font.PLAIN, 18);

    JLabel nameLabel, priceLabel, expireLabel, companyLabel, quantityLabel;

    JTextField nameField, priceField, expireField, companyField, quantityField;

    JButton addBtn, cancelBtn;

    ImageIcon image;
    JLabel background;

    public AddSyrup() {
        super("Add Syrup");
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

        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 260, 100, 40);
        quantityLabel.setFont(font);
        quantityLabel.setForeground(Color.BLACK);
        this.add(quantityLabel);

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

        quantityField = new JTextField();
        quantityField.setBounds(150, 260, 150, 30);
        this.add(quantityField);

        // Buttons
        addBtn = new JButton("Add Syrup");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            try {
                // Create a Syrup object
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String expireDate = expireField.getText();
                String company = companyField.getText();
                int quantity = Integer.parseInt(quantityField.getText());

                Syrup syrup = new Syrup(name, expireDate, price, company, quantity);

                // Save to file
                saveSyrupToFile(syrup);

                // Confirmation Message
                JOptionPane.showMessageDialog(this, "Syrup added successfully!");

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

    private void saveSyrupToFile(Syrup syrup) {
        String data = syrup.getName() + ";" +
                syrup.getPrice() + ";" +
                syrup.getExpireDate() + ";" +
                syrup.getCompany() + ";" +
                syrup.getQuantity();

        fileIO.writeInFile(data, "./File/syrups.txt", true);
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        expireField.setText("");
        companyField.setText("");
        quantityField.setText("");
    }
}