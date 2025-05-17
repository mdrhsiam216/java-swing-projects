import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import Data.FileIO;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class UserData extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5, nBtn;
    private Cursor cursor;

    private String[] column = { "User Name", "Password"};
    private String[] rows = new String[7];

    UserData() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("User Data");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(54, 418, 184, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(248, 418, 184, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Add");
        btn3.setBounds(442, 418, 184, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

        btn4 = new JButton("Exit");
        btn4.setBounds(54, 480, 278, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#C00000"));
        c.add(btn4);

        btn5 = new JButton("Back");
        btn5.setBounds(342, 480, 284, 50);
        btn5.setFont(f2);
        btn5.setCursor(cursor);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#2E75B6"));
        c.add(btn5);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        createTable();

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
                dispose();
            }
        });

        // Delete Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int rows[] = table.getSelectedRows();
                if (rows != null) {
                    Arrays.sort(rows);
                    for (int i = rows.length - 1; i >= 0; i--) {
                        model.removeRow(rows[i]);
                        updateFile();
                    }
                } else {

                }
            }
        });

        // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

        // Exit Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin frame = new Admin();
                frame.setVisible(true);
            }
        });
    }

    public void updateFile() {
        int rows = model.getRowCount();
        String allLines = "";
        for (int i = 0; i < rows; i++) {
            String name = table.getModel().getValueAt(i, 1).toString();
            int pass = Integer.parseInt(table.getModel().getValueAt(i, 0).toString());
            String line;
            if (i < rows - 1) {
                line = pass + ";" + name + "\n";
            } else {
                line = pass + ";" + name;
            }
            allLines += line;
        }
        System.out.println(allLines);
        FileIO.writeInFile(allLines, "./Data/user.txt", false);
    }

    
    public void createTable() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        
        table = new JTable(model);
		table.setFont(f3);
		table.getTableHeader().setFont(f3);
		table.setBounds(0, 0, 400, 300);
		table.setRowHeight(30);
		table.setBackground(new Color(174,247,255));
		table.setSelectionBackground(new Color(200, 200, 230));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(50, 130, 600, 250);
        
        ArrayList f= new ArrayList<>();
        f= FileIO.readFromFile("./Data/user.txt");
        ArrayList <String> n = new ArrayList<>();
		ArrayList <String> p = new ArrayList<>();
        n=(ArrayList)f.get(0);
        p=(ArrayList) f.get(1);
        for(int i =0; i<n.size()-1;i++){
            model.addRow(new Object[]{n.get(i),p.get(i)});
        }
        c.setLayout(null);
        c.add(scrollpane);
        
        this.setContentPane(c);
    }

    public static void main(String[] args) {
    
        UserData frame = new UserData();
        frame.setVisible(true);
    }
}
