package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private ImageIcon logo;
    private JButton btn1, nBtn;
    private Cursor cursor;

    PaySuccess() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Payment successful");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/logo.jpg"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("/Assets/concept-credit-card-payment-landing-page_52683-24923-removebg-preview.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(-20, -50, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Your Payment Has");
        label1.setBounds(430, 80, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Successfully Completed.");
        label1.setBounds(430, 130, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("See you on the event day :)");
        label1.setBounds(430, 180, 500, 50);
        label1.setFont(f1);
        c.add(label1);
        
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        btn1 = new JButton("Finish");
        btn1.setBounds(475, 310, 300, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Management m= new Management();
                m.setVisible(true);
                dispose();
            }
        });
    }
    
    public static void main(String[] args) {

        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
