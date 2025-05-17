package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import File.FileIO;
import Entity.Consumable;

public class AddConsumable extends JFrame implements ActionListener {
    JPanel panel;
    FileIO fileIO = new FileIO();
    Font font = new Font("Segoe UI", Font.PLAIN, 16);

    JLabel nameLabel, priceLabel, expireLabel, companyLabel, typeLabel;

    JTextField nameField, priceField, expireField, companyField, typeField;

    JButton addBtn, cancelBtn;

    ImageIcon image;
    JLabel background;

    public AddConsumable() {
        super("Add Medicine");
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
        addBtn = new JButton("Add Medicine");
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
        image = new ImageIcon("./Assets/consumable.png");
        background = new JLabel();
        background.setBounds(150, 50, 500, 334);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            try {
                // Create a Consumable object
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String expireDate = expireField.getText();
                String company = companyField.getText();
                String type = typeField.getText();

                Consumable consumable = new Consumable(name, price, expireDate, company, type);


                // Save to file
                saveConsumableToFile(consumable);

                // Confirmation Message
                JOptionPane.showMessageDialog(this, "Medicine added successfully!");

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

    private void saveConsumableToFile(Consumable consumable) {
        String data = consumable.getName() + ";" +
                consumable.getPrice() + ";" +
                consumable.getExpireDate() + ";" +
                consumable.getCompany() + ";" +
                consumable.getType();

        fileIO.writeInFile(data, "./File/consumables.txt", true);
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        expireField.setText("");
        companyField.setText("");
        typeField.setText("");
    }
}
