package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import EntityList.*;

public class Homepage extends JFrame implements ActionListener{
	JPanel panel;
	JButton manageteamBtn,manageplayerBtn,managecoachBtn,manageownerBtn;

 	Font bfont = new Font("arial",Font.BOLD,25);
	LogIn logIn;
	TeamList l;
	
	ImageIcon image;
	JLabel background;

	public Homepage(LogIn logIn,TeamList l){
		super("Home Page");
		this.logIn = logIn;
		this.l=l;
		
		image = new ImageIcon("./Assets/ft.jpg");
		panel = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocation(200,100);
		this.setLayout(null);

		this.setIconImage(new ImageIcon("./Assets/football.png").getImage());

		panel.setLayout(null);
		panel.setSize(500,500);
		//panel.setBackground(new Color(200,200,200));
		panel.setOpaque(false);
		
		
		
        background = new JLabel();
        background.setBounds(0,0,500,500);		
		//============================//
		manageteamBtn = createButton(120,50,225,40,"Manage Team");
        manageplayerBtn = createButton(120,100,225,40,"Manage Player");
        managecoachBtn = createButton(120,160,225,40,"Manage Coach");
        manageownerBtn = createButton(120,220,225,40,"Manage Owner");
		//============================//
		this.setTitle("FootBall Club Management System");
		background.setIcon(image);
		
        panel.add(background);
		this.add(panel);
		this.setVisible(true);
	}
	
	public JButton createButton(int x,int y,int w,int h, String text){
		JButton btn = new JButton(text);
		btn.setBounds(x, y, w,h);
		btn.setFont(bfont);
		btn.addActionListener(this);
		btn.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		panel.add(btn);
		return btn;
	}

        public void actionPerformed(ActionEvent e){
            if(manageteamBtn == e.getSource()){
              //  Manageteam mt = new Manageteam();
                this.setVisible(false);
				Manageteam m = new Manageteam(this,l);
            }
			else if(manageplayerBtn==e.getSource()){
				this.setVisible(false);
				ManagePlayer p = new ManagePlayer(this,l);
			}
			else if(managecoachBtn==e.getSource()){
				this.setVisible(false);
				ManageCoach p = new ManageCoach(this,l);
			}
			else if(manageownerBtn==e.getSource()){
				this.setVisible(false);
				ManageOwner p = new ManageOwner(this,l);
			}
        }
	}
