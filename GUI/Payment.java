package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Entity.Cart;
import File.FileIO;

public class Payment extends JFrame implements ActionListener {

    JPanel panel;
    JLabel paymentLabel, nameLabel, phnLabel, payableLabel, paidLabel;
    JTextField name, phn, paid;
    JButton submitBtn, backBtn;

    ImageIcon image;
    JLabel background;

    Font font = new Font("arial", Font.PLAIN, 16);
    Font font1 = new Font("arial", Font.BOLD, 20);

    public Payment() {
        super("Payment");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocation(200, 200);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/icon.jpg").getImage());

        panel = new JPanel();

        paymentLabel = new JLabel("Payment");
        paymentLabel.setBounds(200, 50, 150, 40);
        paymentLabel.setFont(font1);
        paymentLabel.setForeground(Color.BLACK);
        this.add(paymentLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(60, 150, 200, 40);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.BLACK);
        this.add(nameLabel);

        name = new JTextField();
        name.setBounds(140, 150, 150, 30);
        this.add(name);

        phnLabel = new JLabel("Number");
        phnLabel.setBounds(60, 190, 150, 40);
        phnLabel.setFont(font);
        phnLabel.setForeground(Color.BLACK);
        this.add(phnLabel);

        phn = new JTextField();
        phn.setBounds(140, 200, 150, 30);
        this.add(phn);

        payableLabel = new JLabel("Payable");
        payableLabel.setBounds(60, 250, 200, 40);
        payableLabel.setFont(font);
        payableLabel.setForeground(Color.BLACK);
        this.add(payableLabel);

        int price = 0;
        // loop through the cart.
        for (int i = 0; i < Cart.cart.size(); i++) {
            price += Cart.cart.get(i).getPrice();
        }

        payableLabel = new JLabel(price + "BDT");
        payableLabel.setBounds(140, 250, 200, 40);
        payableLabel.setFont(font);
        payableLabel.setForeground(Color.BLACK);
        this.add(payableLabel);

        paidLabel = new JLabel("Paid");
        paidLabel.setBounds(60, 300, 150, 40);
        paidLabel.setFont(font);
        paidLabel.setForeground(Color.BLACK);
        this.add(paidLabel);

        paid = new JTextField();
        paid.setBounds(140, 300, 150, 30);
        this.add(paid);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(220, 350, 130, 30);
        submitBtn.setFont(font);
        submitBtn.setBackground(Color.cyan);
        submitBtn.addActionListener(this);
        this.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(80, 350, 130, 30);
        backBtn.setFont(font);
        backBtn.setBackground(Color.GREEN);
        backBtn.addActionListener(this);
        this.add(backBtn);

        image = new ImageIcon("./Assets/Payment.jpg");
        background = new JLabel();
        background.setBounds(0, 0, 600, 500);
        background.setIcon(image);
        this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            new SellMedicine();
        } else if (e.getSource() == submitBtn) {
            // Retrieve values from text fields
            String customerName = name.getText().trim();
            String phoneNumber = phn.getText().trim();
            String paidAmountStr = paid.getText().trim();

            // Validate that all fields are filled
            if (customerName.isEmpty() || phoneNumber.isEmpty() || paidAmountStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert paid amount to integer
            int paidAmount;
            try {
                paidAmount = Integer.parseInt(paidAmountStr);
            } catch (NumberFormatException ex) {
                // Handle invalid input
                JOptionPane.showMessageDialog(this, "Invalid paid amount. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculate total price from the cart
            int totalPrice = 0;
            for (int i = 0; i < Cart.cart.size(); i++) {
                totalPrice += Cart.cart.get(i).getPrice();
            }

            // Check if the paid amount matches the total price
            if (paidAmount == totalPrice) {
                // Prepare the data to be written to the file
                String products = new String();
                for (int i = 0; i < Cart.cart.size(); i++) {
                    products += Cart.cart.get(i).getName();
                    products += ";";
                }

                String dataToWrite = String.format("%s;%s;%d;%s%n", customerName, phoneNumber, paidAmount, products);

                // Write to sell.txt using FileIO class
                try {
                    FileIO.writeInFile(dataToWrite, "./File/sell.txt", true);
                    Cart.cart.clear(); // Clear the cart after successful payment
                    JOptionPane.showMessageDialog(this, "Payment successful. Data saved.");
                    this.dispose();
                    new SellMedicine();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Failed to save payment data. Error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Paid amount does not match the total price.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
