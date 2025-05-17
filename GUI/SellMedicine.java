package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.*;
import EntityList.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SellMedicine extends JFrame implements ActionListener {
    JPanel panel;
    JButton backBtn, loadBtn, addOtherBtn, nextBtn, addToCartBtn;

    ImageIcon image;
    JLabel background;

    Font font = new Font("arial", Font.PLAIN, 16);

    JTable table, table1, table2;
    DefaultTableModel model, model1, model2;
    String medType = null;

    // clear the cart array

    public SellMedicine() {
        super("Medicine Management");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1500, 500);
        this.setLocation(50, 100);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/icon.jpg").getImage());

        panel = new JPanel();

        backBtn = new JButton("<- Back");
        loadBtn = new JButton("Load Medicine");
        addOtherBtn = new JButton("Add Other");
        nextBtn = new JButton("Next ->");
        addToCartBtn = new JButton("Add to Cart");

        backBtn.setBounds(500, 430, 130, 30);
        backBtn.setBackground(Color.ORANGE);
        backBtn.addActionListener(this);
        loadBtn.setBounds(930, 80, 140, 30);
        loadBtn.setBackground(Color.GREEN);
        loadBtn.addActionListener(this);

        addOtherBtn.setBounds(190, 80, 150, 30);
        addOtherBtn.setBackground(Color.cyan);
        addOtherBtn.addActionListener(this);

        nextBtn.setBounds(650, 430, 130, 30);
        nextBtn.setBackground(Color.MAGENTA);
        nextBtn.addActionListener(this);

        addToCartBtn.setBounds(1250, 80, 130, 30);
        addToCartBtn.setBackground(Color.MAGENTA);
        addToCartBtn.addActionListener(this);

        panel.add(backBtn);
        panel.add(loadBtn);
        panel.add(addOtherBtn);
        panel.add(nextBtn);
        panel.add(addToCartBtn);

        createMedicineTable();
        createTypeTable();
        createSelectedTable();

        image = new ImageIcon("./Assets/Manage medecine.jpg");
        background = new JLabel();
        background.setBounds(0, 0, 1500, 500);
        background.setIcon(image);
        panel.add(background);

        this.setVisible(true);
    }

    public void createMedicineTable() {
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Expire Date");
        model.addColumn("Company");

        table = new JTable(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        table.setBounds(0, 0, 400, 300);
        table.setRowHeight(30);
        table.setBackground(new Color(174, 247, 255));
        table.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(100, 130, 800, 300);

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    public void createTypeTable() {
        model1 = new DefaultTableModel();
        model1.addColumn("Type");

        table1 = new JTable(model1);
        table1.setFont(font);
        table1.getTableHeader().setFont(font);

        table1.setRowHeight(30);
        table1.setBackground(new Color(174, 247, 255));
        table1.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table1);
        scrollpane.setBounds(950, 130, 200, 300);

        model1.addRow(new Object[] { "consumable" });
        model1.addRow(new Object[] { "syrup" });
        model1.addRow(new Object[] { "others" });

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    public void createSelectedTable() {
        model2 = new DefaultTableModel();
        model2.addColumn("Cart");

        table2 = new JTable(model2);
        table2.setFont(font);
        table2.getTableHeader().setFont(font);

        table2.setRowHeight(30);
        table2.setBackground(new Color(174, 247, 255));
        table2.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table2);
        scrollpane.setBounds(1190, 130, 200, 300);

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            new Dashboard();
        } else if (e.getSource() == loadBtn) {
            System.out.println("Load button clicked");

            // Clear the current table
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            // Get the selected type from table1
            int selectedRow = table1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a medicine type to load.", "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selectedType = table1.getModel().getValueAt(selectedRow, 0).toString().toLowerCase();
            System.out.println("Selected Type: " + selectedType);

            String filePath = "";
            if (selectedType.equals("consumable")) {
                filePath = "./File/consumables.txt";
            } else if (selectedType.equals("syrup")) {
                filePath = "./File/syrups.txt";
            } else if (selectedType.equals("others")) {
                filePath = "./File/others.txt";
            } else {
                JOptionPane.showMessageDialog(this, "An error occurred while loading data.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Scanner scanner = new Scanner(new File(filePath))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Reading line: " + line); // Debugging output

                    String[] cols = line.split(";");
                    if (cols.length == 5) { // Ensuring correct format: Name;Price;ExpireDate;Company;Type
                        model.addRow(new Object[] {
                                cols[0], // Name
                                cols[1], // Price
                                cols[2], // Expire Date
                                cols[3] // Company (No need to add the 'Type' column)
                        });
                    } else {
                        System.out.println("Skipped line (unexpected format): " + line);
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error: File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while loading data.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else if (e.getSource() == addToCartBtn) {
            int selectedRow = table.getSelectedRow(); 
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a product to add.", "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            String selectedProduct = table.getModel().getValueAt(selectedRow, 0).toString();
        
            //----------------
            int s = table1.getSelectedRow(); // Selecting from the Type Table
            if (s == -1) {
                JOptionPane.showMessageDialog(this, "Please select a medicine type.", "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            String selectedType = table1.getModel().getValueAt(s, 0).toString().toLowerCase(); // 🔹 Fixed index
        
            System.out.println("Selected Type: " + selectedType);
        
            Medicine m = null;
            if (selectedType.equals("consumable")) {
                m = ConsumableList.getConsumableByName(selectedProduct);
            } else if (selectedType.equals("syrup")) {
                m = SyrupList.getSyrupByName(selectedProduct);
            } else if (selectedType.equals("others")) {
                m = OthersList.getOtherByName(selectedProduct);
            } else {
                JOptionPane.showMessageDialog(this, "An error occurred while loading data.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            //----------------
            if (m != null) { 
                // Null check before adding to cart
                model2.addRow(new Object[] { selectedProduct });
                Cart.cart.add(m);
            } else {
                JOptionPane.showMessageDialog(this, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(nextBtn == e.getSource()){
            if (Cart.cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                this.dispose();
                new Payment();
            }
            
        }
    }
}
