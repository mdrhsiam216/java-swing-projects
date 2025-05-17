package GUI;
import javax.swing.*;

import File.FileIO;

import java.awt.*;
import java.awt.event.*;

// import File.*;
public class LogIn extends JFrame implements ActionListener{
    JLabel userNameLable, userPassLabel,textlabel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin,registerBtn;
    JLabel background;
    ImageIcon image;

    
    // TeamList l= new TeamList();
    Font font = new Font("cambria", Font.BOLD, 20);
    Font font2 = new Font("cambria", Font.PLAIN, 20);

    public LogIn() {
        super("Login");
        System.out.println("login.java");
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon("./Assets/logo.jpg").getImage());

        // loadTeams();

		//USER NAME Lable
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(260, 130, 130, 40);
        userNameLable.setFont(font);
        userNameLable.setForeground(Color.WHITE);
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
        userPassLabel.setForeground(Color.WHITE);
        this.add(userPassLabel);

        textlabel = new JLabel("Don't have account?");
        textlabel.setBounds(220, 390, 200, 40);
        textlabel.setFont(font);
        textlabel.setForeground(Color.WHITE);
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
        btnLogin.setBackground(new Color(92, 101, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(430, 390, 120, 43);
        registerBtn.setFont(font2);
        registerBtn.setBackground(new Color(92, 101, 204));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.addActionListener(this);
        this.add(registerBtn);

        image = new ImageIcon("./Assets/log.png");
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
                m.setVisible(true);
                this.dispose();
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
    }
}



