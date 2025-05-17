package GUI;

import javax.swing.*; // JFrame, JLabel, JTextField, JButton
import java.awt.*; // Font, color
import java.awt.event.*; // Action Listener

public class AboutUsPage extends JFrame implements ActionListener{

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    JLabel textLabel;
    JTextArea textArea;
    JButton  BackBtn;

    HomePage homePage;

    public AboutUsPage(HomePage homePage){

        super("About Us Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.homePage=homePage;

        textLabel=new JLabel("About Us");
        textLabel.setFont(new Font("Cambria",Font.BOLD,30));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(550,70,500,100);
        this.add(textLabel);

        textLabel=new JLabel("Md. Minhaj Rowfun Rabbi Anik  (23-54110-3@student.aiub.edu)");
        textLabel.setFont(new Font("Arial",Font.PLAIN,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(300,170,1000,100);
        this.add(textLabel);

        textLabel=new JLabel("Tasnuva Rahannum  (23-52388-2@student.aiub.edu)");
        textLabel.setFont(new Font("Arial",Font.PLAIN,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(300,240,1000,100);
        this.add(textLabel);

        textLabel=new JLabel("Sadia Islam Mim  (23-50562-1@student.aiub.edu)");
        textLabel.setFont(new Font("Arial",Font.PLAIN,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(300,310,1000,100);
        this.add(textLabel);

        textLabel=new JLabel("Adiba Hossain (23-552389-2@student.aiub.edu)");
        textLabel.setFont(new Font("Arial",Font.PLAIN,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(300,380,1000,100);
        this.add(textLabel);

        BackBtn = new JButton("Back");
        BackBtn.setBounds(1050, 580, 140, 35);
        BackBtn.setFont(textArial25);
        BackBtn.setBackground(Color.GRAY);
        BackBtn.setForeground(Color.WHITE);
        BackBtn.addActionListener(this);
        this.add(BackBtn);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
		if(e.getSource()==BackBtn){
            homePage.setVisible(true);
            this.dispose();
        }
	}

    // public static void main(String[] args){
	// 	AboutUsPage us=new AboutUsPage();
    //     us.setVisible(true);
	// }

}