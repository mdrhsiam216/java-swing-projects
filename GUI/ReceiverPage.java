package GUI;

import javax.swing.*; // JFrame, JLabel, JTextField, JButton
import java.awt.*; // Font, color
import java.awt.event.*; // Action Listener

import Entity.*;
import EntityList.*;

import File.*;

public class ReceiverPage extends JFrame implements ActionListener{

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    JLabel textLabel;
    JTextField idTextField,numberTextField,bloodGroupTextField,areaTextField,searchBloodGroupTextField;
    JTextArea textArea;
    JButton logoutBtn,updateButton,yesButton,noButton, bloodSearchBtn, areaSearchBtn, donorClearBtn, showDonorBtn;

	LoginPage loginPage;
	DonorList donorList;
	ReceiverList receiverList;
	String userName;

    public ReceiverPage(LoginPage loginPage, DonorList donorList, ReceiverList receiverList, String userName){

        super("Receiver Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 800);
        this.setLocation(30, 15);
        this.setLayout(null);

		this.loginPage=loginPage;
		this.donorList=donorList;
		this.receiverList=receiverList;
		this.userName=userName;

		int top = 100;
		int gap = 40;

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

		textArea = new JTextArea();
        textArea.setFont(textArial20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(350,60,550,560); //x,y,w,h
        // Update area with List
        updateTextArea();
        this.add(scrollPane);

		top = 100;
		gap = 40;

		JLabel idLabel = new JLabel("Update Receiver Phone");
		idLabel.setBounds(995,top,260,40); //X,Y,W,H
		idLabel.setFont(textArial20);
		this.add(idLabel);

		idTextField = new JTextField();
		idTextField.setBounds(1000,top+=gap,200,40); //X,Y,W,H
		idTextField.setFont(textArial20);
		this.add(idTextField);

		updateButton = new JButton("Update");
		updateButton.setBounds(1000,top+=gap+10,200,40); //X,Y,W,H
		updateButton.setBackground(Color.YELLOW);
		updateButton.setFont(textArial20);
		updateButton.addActionListener(this);
		this.add(updateButton);

		logoutBtn=new JButton("Logout");
        logoutBtn.setFont( textArial20);
        logoutBtn.setBackground(new Color(240,240,240));
        logoutBtn.setBounds(80,590,200,32);
        logoutBtn.addActionListener(this);
        this.add(logoutBtn);

		showDonorBtn=new JButton("Show Donor");
        showDonorBtn.setFont( textArial20);
        showDonorBtn.setBackground(new Color(240,240,240));
        showDonorBtn.setBounds(980,550,200,32);
        showDonorBtn.addActionListener(this);
        this.add(showDonorBtn);

        donorClearBtn=new JButton("Clear");
        donorClearBtn.setFont( textArial20);
        donorClearBtn.setBackground(new Color(240,240,240));
        donorClearBtn.setBounds(980,590,200,32);
        donorClearBtn.addActionListener(this);
        this.add(donorClearBtn);

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
        }
        else if(e.getSource()==showDonorBtn){
			textArea.setText(donorList.showAllAsString());
		}
        else if(e.getSource()==donorClearBtn){
			textArea.setText("");
		}

        else if(e.getSource()==updateButton){
            System.out.println("invoked");
			System.out.println(userName);
            if(receiverList.getByUserId(userName)!=null){
                Receiver r=receiverList.getByUserId(userName);
                r.setContactNumber(idTextField.getText());
                ReceiverFileIO.inputReceiverInFile(receiverList);
            }
            else{
                System.out.println("null detected");
            }
		}
	}

	public void updateTextArea(){
		textArea.setText(donorList.showAllAsString());
	}

}
