package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import EntityList.ConsumableList;
import EntityList.OthersList;
import EntityList.SyrupList;
import File.FileIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ManageMedicine extends JFrame implements ActionListener {
    JPanel panel;
    JButton backBtn, addConsumableBtn, delete, addSyrupBtn, updateBtn, loadBtn, addOtherBtn;

    ImageIcon image;
    JLabel background;

    Font font = new Font("arial", Font.PLAIN, 16);

    JTable table, table1;
    DefaultTableModel model, model1;
    String medType = null;

    public ManageMedicine() {
        super("medispere");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1500, 500);
        this.setLocation(50, 100);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("./Assets/icon.jpg").getImage());

        panel = new JPanel();

        backBtn = new JButton("<- Back");
        addConsumableBtn = new JButton("Add Medicine");
        delete = new JButton("Delete");
        addSyrupBtn = new JButton("Add Syrup");
        updateBtn = new JButton("Update");
        loadBtn = new JButton("Load Medicine");
        addOtherBtn = new JButton("Add Other");

        backBtn.setBounds(700, 430, 130, 30);
        backBtn.setBackground(Color.ORANGE);
        backBtn.addActionListener(this);

        addConsumableBtn.setBounds(350, 80, 150, 30);
        addConsumableBtn.setBackground(Color.GREEN);
        addConsumableBtn.addActionListener(this);

        delete.setBounds(810, 80, 100, 30);
        delete.setBackground(Color.RED);
        delete.addActionListener(this);

        addSyrupBtn.setBounds(510, 80, 130, 30);
        addSyrupBtn.setBackground(Color.ORANGE);
        addSyrupBtn.addActionListener(this);

        updateBtn.setBounds(660, 80, 130, 30);
        updateBtn.setBackground(Color.YELLOW);
        updateBtn.addActionListener(this);

        loadBtn.setBounds(930, 80, 140, 30);
        loadBtn.setBackground(Color.GREEN);
        loadBtn.addActionListener(this);

        addOtherBtn.setBounds(190, 80, 150, 30);
        addOtherBtn.setBackground(Color.cyan);
        addOtherBtn.addActionListener(this);

        panel.add(backBtn);
        panel.add(addConsumableBtn);
        panel.add(delete);
        panel.add(addSyrupBtn);
        panel.add(updateBtn);
        panel.add(loadBtn);
        panel.add(addOtherBtn);

        createMedicineTable();
        createTypeTable();

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
        model.addColumn("Type/quantity");

        table = new JTable(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        table.setBounds(0, 0, 400, 300);
        table.setRowHeight(30);
        table.setBackground(new Color(174, 247, 255));
        table.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(100, 130, 1000, 300);

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
        scrollpane.setBounds(1230, 130, 200, 300);

        model1.addRow(new Object[] { "consumable" });
        model1.addRow(new Object[] { "syrup" });
        model1.addRow(new Object[] { "others" });

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    public void updateFile() {
        int rowCount = model.getRowCount();
        String data = new String();

        for (int i = 0; i < rowCount; i++) {
            String name = model.getValueAt(i, 0).toString();
            String price = model.getValueAt(i, 1).toString();
            String expireDate = model.getValueAt(i, 2).toString();
            String company = model.getValueAt(i, 3).toString();
            String type = model.getValueAt(i, 4).toString().toLowerCase();

            String row = name + ";" + price + ";" + expireDate + ";" + company + ";" + type + "\n";
            data += row;

        }

        // Write data to respective files
        try {
            if (medType.equals("consumable")) {
                FileIO.writeInFile(data, "./File/consumables.txt", false);
                JOptionPane.showMessageDialog(this, "consumable updated successfully!");
                ConsumableList.consumables = null;
                ConsumableList.loadConsumables();
            } else if (medType.equals("syrup")) {
                FileIO.writeInFile(data, "./File/syrups.txt", false);
                JOptionPane.showMessageDialog(this, "syrup updated successfully!");
                SyrupList.syrups = null;
                SyrupList.loadSyrups();
            } else if (medType.equals("others")) {
                FileIO.writeInFile(data, "./File/others.txt", false);
                JOptionPane.showMessageDialog(this, "others updated successfully!");
                OthersList.others = null;
                OthersList.loadOthers();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to update files. Error: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.dispose();
            new Dashboard();
        } else if (e.getSource() == addConsumableBtn) {
            this.dispose();
            new AddConsumable();
        } else if (e.getSource() == delete) {
            int[] rows = table.getSelectedRows();
            if (rows.length > 0) {
                Arrays.sort(rows);
                for (int i = rows.length - 1; i >= 0; i--) {
                    model.removeRow(rows[i]);
                }
                updateFile();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == addSyrupBtn) {
            this.dispose();
            new AddSyrup();
        } else if (e.getSource() == updateBtn) {
            updateFile();
        }

        else if (e.getSource() == loadBtn) {
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

            medType = selectedType;
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
            }

            try (Scanner scanner = new Scanner(new File(filePath))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Reading line: " + line); // Debugging output

                    String[] cols = line.split(";");
                    if (cols.length >= 5) {
                        String type = cols[4].toLowerCase();
                        // Add row to the table
                        model.addRow(new Object[] {
                                cols[0], // Name
                                cols[1], // Price
                                cols[2], // Expire Date
                                cols[3], // Company
                                cols[4] // Type
                        });
                    } else {
                        System.out.println("Skipped line (unexpected format): " + line); // Debugging invalid rows
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
        } else if (addOtherBtn == e.getSource()) {
            new AddOthers();
        }
    }
}
