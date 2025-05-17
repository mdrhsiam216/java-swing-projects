package GUI;

import javax.swing.*; // JFrame, JLabel, JTextField, JButton
import java.awt.*; // Font, color
import java.awt.event.*; // Action Listener

import Entity.*;
import EntityList.*;

import File.*;

public class DonorPage extends JFrame implements ActionListener{

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    JLabel textLabel;
    JTextField searchBloodGroupTextField, areaTextField;
    JTextArea textArea;
	JButton logoutBtn, bloodSearchBtn, areaSearchBtn, receiverClearBtn, showReceiverBtn, contactUpdateBtn, contactClearBtn, statusUpdateBtn, statusClearBtn;

    LoginPage loginPage;
    ReceiverList receiverList;

    public DonorPage(LoginPage loginPage, ReceiverList receiverList){

		super("Donor Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.loginPage=loginPage;
        this.receiverList=receiverList;

        textArea = new JTextArea();
        textArea.setFont(textArial20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(350,60,550,560); //x,y,w,h
        // Update area with List
        updateTextArea();
        this.add(scrollPane);

        /*textLabel=new JLabel("Update Information:");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(980,30,500,100);
        this.add(textLabel);*/
		

        // contactUpdateBtn=new JButton("Update Information");
        // contactUpdateBtn.setFont( textArial20);
        // contactUpdateBtn.setBackground(new Color(240,240,240));
        // contactUpdateBtn.setBounds(970,100,220,40);
        // contactUpdateBtn.addActionListener(this);
        // this.add(contactUpdateBtn);
        
        /*contactClearBtn=new JButton("Clear");
        contactClearBtn.setFont( textArial20);
        contactClearBtn.setBackground(new Color(240,240,240));
        contactClearBtn.setBounds(1090,150,100,30);
        contactClearBtn.addActionListener(this);
        this.add(contactClearBtn);*/

        logoutBtn=new JButton("Logout");
        logoutBtn.setFont( textArial20);
        logoutBtn.setBackground(new Color(240,240,240));
        logoutBtn.setBounds(80,590,200,32);
        logoutBtn.addActionListener(this);
        this.add(logoutBtn);

        textLabel=new JLabel("Search by Blood Group");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(80,30,500,100);
        this.add(textLabel);
		
		searchBloodGroupTextField=new JTextField();
        searchBloodGroupTextField.setFont(textArial20);
        searchBloodGroupTextField.setBounds(80,100,230,40);
        this.add(searchBloodGroupTextField);

        bloodSearchBtn=new JButton("Search");
        bloodSearchBtn.setFont( textArial20);
        bloodSearchBtn.setBackground(new Color(240,240,240));
        bloodSearchBtn.setBounds(90,150,200,32);
        bloodSearchBtn.addActionListener(this);
        this.add(bloodSearchBtn);

        /*bloodGroupTextField=new JTextField();
        bloodGroupTextField.setFont(textArial20);
        bloodGroupTextField.setBounds(980,100,220,40);
        this.add(bloodGroupTextField);*/
		
		textLabel=new JLabel("Search by Area");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(100,180,500,100);
        this.add(textLabel);

        areaTextField=new JTextField();
        areaTextField.setFont(textArial20);
        areaTextField.setBounds(80,250,230,40);
        this.add(areaTextField);

        areaSearchBtn=new JButton("Search");
        areaSearchBtn.setFont( textArial20);
        areaSearchBtn.setBackground(new Color(240,240,240));
        areaSearchBtn.setBounds(90,300,200,32);
        areaSearchBtn.addActionListener(this);
        this.add(areaSearchBtn);

        textLabel=new JLabel("Status:");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(80,370,300,40);
        this.add(textLabel);
		
		statusUpdateBtn=new JButton("Online");
        statusUpdateBtn.setFont( textArial20);
        statusUpdateBtn.setBackground(new Color(240,240,240));
        statusUpdateBtn.setBounds(80,410,100,30);
        statusUpdateBtn.addActionListener(this);
        this.add(statusUpdateBtn);

        statusClearBtn=new JButton("Offline");
        statusClearBtn.setFont( textArial20);
        statusClearBtn.setBackground(new Color(240,240,240));
        statusClearBtn.setBounds(190,410,100,30);
        statusClearBtn.addActionListener(this);
        this.add(statusClearBtn);


        textLabel=new JLabel("Update Contact Number");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(980,30,500,100);
        this.add(textLabel);
		

        contactUpdateBtn=new JButton("Update");
        contactUpdateBtn.setFont( textArial20);
        contactUpdateBtn.setBackground(new Color(240,240,240));
        contactUpdateBtn.setBounds(980,100,100,30);
        contactUpdateBtn.addActionListener(this);
        this.add(contactUpdateBtn);
        
        contactClearBtn=new JButton("Clear");
        contactClearBtn.setFont( textArial20);
        contactClearBtn.setBackground(new Color(240,240,240));
        contactClearBtn.setBounds(1100,100,100,30);
        contactClearBtn.addActionListener(this);
        this.add(contactClearBtn);

        showReceiverBtn=new JButton("Show Receiver");
        showReceiverBtn.setFont( textArial20);
        showReceiverBtn.setBackground(new Color(240,240,240));
        showReceiverBtn.setBounds(980,550,200,32);
        showReceiverBtn.addActionListener(this);
        this.add(showReceiverBtn);

        receiverClearBtn=new JButton("Clear");
        receiverClearBtn.setFont( textArial20);
        receiverClearBtn.setBackground(new Color(240,240,240));
        receiverClearBtn.setBounds(980,590,200,32);
        receiverClearBtn.addActionListener(this);
        this.add(receiverClearBtn);

        //Load Frame Icon
        ImageIcon frameIcon = new ImageIcon("./GUI/Resources/icon.jpg");
        this.setIconImage(frameIcon.getImage());

        this.setVisible(true);
	}

    public void actionPerformed(ActionEvent e){
		if(logoutBtn==e.getSource()){
			System.out.println("logout");
			int response = JOptionPane.showConfirmDialog(this, "Are you Sure to logout.",
                            "Do you want to logout?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION){
			    loginPage.setVisible(true);
                this.dispose();
			}
		}else if(e.getSource()==showReceiverBtn){
            textArea.setText(receiverList.showAllAsString());
        }else if(e.getSource()==receiverClearBtn){
            textArea.setText("");
        }else if(e.getSource()==bloodSearchBtn){
            if(!searchBloodGroupTextField.getText().isEmpty()){
                String bloodReceiver=receiverList.getByBloodTypeAsString(searchBloodGroupTextField.getText());
                if(!bloodReceiver.isEmpty()){
                    textArea.setText(bloodReceiver);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Unavailable.");
            }
        }else if(e.getSource()==areaSearchBtn){
            if(!areaTextField.getText().isEmpty()){
                String areaReceiver=receiverList.getByAreaNameAsString(areaTextField.getText());
                if(!areaReceiver.isEmpty()){
                    textArea.setText(areaReceiver);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Area not found.");
            }
        }
	}

    public void updateTextArea(){
		textArea.setText(receiverList.showAllAsString());
	}

}