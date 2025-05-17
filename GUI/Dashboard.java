package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
	JPanel panel;
	JButton managemedicinebtn,sellmedicinebtn,logoutBtn;

 	Font bfont = new Font("arial",Font.PLAIN,20);
	
	ImageIcon image;
	JLabel background;

	public Dashboard(){
		
		image = new ImageIcon("./Assets/dashboard.jpg");
		panel = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocation(400,100);
		this.setLayout(null);

		this.setIconImage(new ImageIcon("./Assets/icon.jpg").getImage());

		panel.setLayout(null);
		panel.setSize(500,500);
		panel.setOpaque(false);
		
        background = new JLabel();
        background.setBounds(0,0,500,500);		
		//============================//
		managemedicinebtn = createButton(130,160,225,40,"Manage Medecine ");
        sellmedicinebtn = createButton(130,220,225,40,"sell medicine");
        logoutBtn = createButton(130,280,225,40,"logout");
		//============================//
		this.setTitle("medispere");
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
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		panel.add(btn);
		return btn;
	}

        public void actionPerformed(ActionEvent e){
            if(managemedicinebtn == e.getSource()){
				this.dispose();
				new ManageMedicine();
            }
			else if(sellmedicinebtn==e.getSource()){
				this.dispose();
				new SellMedicine();
			}
			else if(logoutBtn==e.getSource()){
				this.dispose();
				new Login();
			}
        }
	}

