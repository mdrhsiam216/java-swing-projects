package Pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Admindashboard extends JFrame {
    private JPanel panel;
    private JTextField searchField;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private JButton searchButton, deleteButton, logoutButton;

    public Admindashboard() {
        setTitle("Admin Dashboard");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUsers(searchField.getText());
            }
        });
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel();
        userTable = new JTable(tableModel);
        tableModel.setColumnIdentifiers(new String[]{"Username", "Phone Number", "Student ID", "Vehicle Info", "Payment Method", "Parking Lot Number"});
        
       
        userTable.setRowHeight(40);
        
        JTableHeader header = userTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(userTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        
        deleteButton = new JButton("Delete User");
        deleteButton.setPreferredSize(new Dimension(150, 40));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow != -1) {
                    String studentID = (String) tableModel.getValueAt(selectedRow, 2);
                    deleteSelectedUser(studentID);
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        logoutButton = new JButton("Logout");
        logoutButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(deleteButton);
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        loadUserTable(); 

        getContentPane().add(panel);
    }

    private void loadUserTable() {
        String filePath = "Users/user.txt";
        tableModel.setRowCount(0); 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length >= 7) {
                    tableModel.addRow(new String[]{
                            userInfo[0], 
                            userInfo[1], 
                            userInfo[2], 
                            userInfo[3], 
                            userInfo[4],
                            userInfo[6]  
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

    private void searchUsers(String searchText) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        userTable.setRowSorter(sorter);
        if (searchText.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); 
        }
    }
	

    private void deleteSelectedUser(String studentID) {
        String filePath = "Users/user.txt";
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length >= 7 && !userInfo[2].equals(studentID)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        loadUserTable();
    }

    private void logout() {
        
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Admindashboard adminDashboard = new Admindashboard();
            adminDashboard.setVisible(true);
        });
    }
}
