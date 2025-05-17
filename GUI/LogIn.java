package GUI;
import javax.swing.*;

import Entity.Employee;
import Entity.Restaurant;
import EntityList.EmployeeList;
import EntityList.RestaurantList;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Entity.*;
import EntityList.*;
import File.*;

import File.*;

public class LogIn extends JFrame implements ActionListener{
    JLabel userNameLable, userPassLabel,textlabel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin,registerBtn,creditBtn;
    JLabel background;
    ImageIcon image;


    Font font = new Font("cambria", Font.BOLD, 20);
    Font font2 = new Font("cambria", Font.PLAIN, 20);

    public LogIn() {
        super("Login");
        System.out.println("login");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo-removebg-preview.png").getImage());

        

		//USER NAME Lable
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(260, 130, 130, 40);
        userNameLable.setFont(font);
        userNameLable.setForeground(Color.BLACK);
        this.add(userNameLable);

		//USER NAME TextField
        userName = new JTextField("");
        userName.setBounds(430, 130, 210, 50);
        userName.setFont(font2);
        this.add(userName);
		
		//User Password Label 
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(260, 220, 130, 40);
        userPassLabel.setFont(font);
        userPassLabel.setForeground(Color.BLACK);
        this.add(userPassLabel);

        textlabel = new JLabel("Don't have account?");
        textlabel.setBounds(220, 390, 200, 40);
        textlabel.setFont(font);
        textlabel.setForeground(Color.BLACK);
        this.add(textlabel);

		//User Password Password Field
        password = new JPasswordField("");
        password.setBounds(430, 210, 210, 50);
		password.setEchoChar('*');
        password.setFont(font2);
        this.add(password);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(430, 300, 120, 43);
        btnLogin.setFont(font2);
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(430, 390, 120, 43);
        registerBtn.setFont(font2);
        registerBtn.setBackground(Color.WHITE);
        registerBtn.setForeground(Color.BLACK);
        registerBtn.addActionListener(this);
        this.add(registerBtn);

        creditBtn = new JButton("Credit");
        creditBtn.setBounds(430, 470, 120, 43);
        creditBtn.setFont(font2);
        creditBtn.setBackground(Color.WHITE);
        creditBtn.setForeground(Color.BLACK);
        creditBtn.addActionListener(this);
        this.add(creditBtn);

        image = new ImageIcon("./Assets/5592854.jpg");
		background = new JLabel();
		background.setBounds(0,0,900,600);
		background.setIcon(image);
		this.add(background);
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (btnLogin == e.getSource()) {
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
			int status = FileIO.checkUser(name,pass,"./File/users.txt");
            if (status == 1) {
				
				JOptionPane.showMessageDialog(this, "Login Successfull");
				
				Management m= new Management();
                this.setVisible(false);
            }
			else if(status == 2){
                JOptionPane.showMessageDialog(this, "Invalid Password", 
											  "Error",JOptionPane.WARNING_MESSAGE);
            }

			else{
                JOptionPane.showMessageDialog(this, "USER NOT REGISTERED", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(registerBtn == e.getSource()){
            Registration rs = new Registration(this);
        }
        else if(e.getSource()== creditBtn){
            this.dispose();
            Credit c = new Credit();
        }
    }

    // public void loadCorporate(){
    //     ArrayList <String> f = FileIO.readFromFile("./File/corporate.txt");
    //     for(int i=0;i<f.size();i++){
    //         String rows[]= f.get(i).split(";");

    //         //int eventId,String venue, Date date, String theme

    //         int id = Integer.parseInt(rows[0]);
    //         String venue= rows[1];
    //         Date date= new Date(Integer.parseInt(rows[2]), Integer.parseInt(rows[3]), Integer.parseInt(rows[4]));
    //         String theme = rows[5];
            
    //         CorporateList.CorporateList.add(new Corporate(id, venue, date, theme));
    //     }
    // }

    public static void main(String[] args) {
        LogIn frame = new LogIn();
        frame.setVisible(true);
    }
    }



