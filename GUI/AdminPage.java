package GUI;

import javax.swing.*; // JFrame, JLabel, JTextField, JButton
import java.awt.*; // Font, color
import java.awt.event.*; // Action Listener

import Entity.*;
import EntityList.*;

import File.*;

public class AdminPage extends JFrame implements ActionListener{

    Font titleCambria30=new Font("Cambria", Font.BOLD, 30);
    Font titleArial30=new Font("Arial", Font.BOLD, 30);
    Font textCambria30=new Font("Cambria", Font.PLAIN, 30);
    Font textCambria25=new Font("Cambria", Font.PLAIN, 25);
    Font textArial30=new Font("Arial", Font.PLAIN, 30);
    Font textArial25=new Font("Arial", Font.PLAIN, 25);
    Font textArial20=new Font("Arial", Font.PLAIN, 20);

    JLabel textLabel;
    JTextField searchTextField, userTextField;
    JTextArea textArea;
    JButton logoutBtn, updateDonorBtn, updateReceiverBtn, showDonorBtn, showReceiverBtn, showAllBtn, clearScreenBtn, userUpdateBtn, userClearBtn, searchBtn;

    LoginPage loginPage;
    DonorList donorList;
    ReceiverList receiverList;

    public AdminPage(LoginPage loginPage, DonorList donorList, ReceiverList receiverList){

        super("Admin Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocation(30, 15);
        this.setLayout(null);

        this.loginPage=loginPage;
        this.donorList=donorList;
        this.receiverList=receiverList;

        textLabel=new JLabel("Update username");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(100,30,500,100);
        this.add(textLabel);

        textArea = new JTextArea();
        textArea.setFont(textArial20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(350,60,550,560); //x,y,w,h
        // Update area with List
        updateTextArea();
        this.add(scrollPane);

        userTextField=new JTextField();
        userTextField.setFont(textArial20);
        userTextField.setBounds(80,100,200,40);
        this.add(userTextField);

        userUpdateBtn=new JButton("Update");
        userUpdateBtn.setFont( textArial20);
        userUpdateBtn.setBackground(Color.GRAY);
        userUpdateBtn.setForeground(Color.WHITE);
        userUpdateBtn.setBounds(80,150,100,30);
        userUpdateBtn.addActionListener(this);
        this.add(userUpdateBtn);

        userClearBtn=new JButton("Clear");
        userClearBtn.setFont( textArial20);
        userClearBtn.setBackground(Color.GRAY);
        userClearBtn.setForeground(Color.WHITE);
        userClearBtn.setBounds(190,150,90,30);
        userClearBtn.addActionListener(this);
        this.add(userClearBtn);

        updateDonorBtn=new JButton("Update Donor");
        updateDonorBtn.setFont( textArial20);
        updateDonorBtn.setBackground(Color.GRAY);
        updateDonorBtn.setForeground(Color.WHITE);
        updateDonorBtn.setBounds(85,210,190,40);
        updateDonorBtn.addActionListener(this);
        this.add(updateDonorBtn);

        updateReceiverBtn=new JButton("Update Receiver");
        updateReceiverBtn.setFont( textArial20);
        updateReceiverBtn.setBackground(Color.GRAY);
        updateReceiverBtn.setForeground(Color.WHITE);
        updateReceiverBtn.setBounds(85,260,190,40);
        updateReceiverBtn.addActionListener(this);
        this.add(updateReceiverBtn);

        logoutBtn=new JButton("Logout");
        logoutBtn.setFont( textArial20);
        logoutBtn.setBackground(Color.GRAY);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBounds(85,580,190,40);
        logoutBtn.addActionListener(this);
        this.add(logoutBtn);

        textLabel=new JLabel("Search by Phone or Area");
        textLabel.setFont(new Font("Arial",Font.BOLD,20));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(970,30,500,100);
        this.add(textLabel);

        searchTextField=new JTextField();
        searchTextField.setFont(textArial20);
        searchTextField.setBounds(965,100,270,40);
        this.add(searchTextField);

        searchBtn=new JButton("Search");
        searchBtn.setFont(textArial20);
        searchBtn.setBackground(Color.GRAY);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setBounds(1000,160,200,40);
        searchBtn.addActionListener(this);
        this.add(searchBtn);

        showDonorBtn=new JButton("Show Donor");
        showDonorBtn.setFont( textArial20);
        showDonorBtn.setBackground(Color.GRAY);
        showDonorBtn.setForeground(Color.WHITE);
        showDonorBtn.setBounds(1000,425,200,40);
        showDonorBtn.addActionListener(this);
        this.add(showDonorBtn);

        showReceiverBtn=new JButton("Show Receiver");
        showReceiverBtn.setFont( textArial20);
        showReceiverBtn.setBackground(Color.GRAY);
        showReceiverBtn.setForeground(Color.WHITE);
        showReceiverBtn.setBounds(1000,475,200,40);
        showReceiverBtn.addActionListener(this);
        this.add(showReceiverBtn);

        showAllBtn=new JButton("Show All");
        showAllBtn.setFont( textArial20);
        showAllBtn.setBackground(Color.GRAY);
        showAllBtn.setForeground(Color.WHITE);
        showAllBtn.setBounds(1000,525,200,40);
        showAllBtn.addActionListener(this);
        this.add(showAllBtn);

        clearScreenBtn=new JButton("Clear Screen");
        clearScreenBtn.setFont( textArial20);
        clearScreenBtn.setBackground(Color.GRAY);
        clearScreenBtn.setForeground(Color.WHITE);
        clearScreenBtn.setBounds(1000,575,200,40);
        clearScreenBtn.addActionListener(this);
        this.add(clearScreenBtn);

        //Load Frame Icon
        ImageIcon frameIcon = new ImageIcon("./GUI/Resources/icon.jpg");
        this.setIconImage(frameIcon.getImage());

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logoutBtn){
			System.out.println("logout");
			int response = JOptionPane.showConfirmDialog(this, "Are you Sure to logout.",
                            "Do you want to logout?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION){
                loginPage.setVisible(true);
                this.dispose();
			}
		}else if(e.getSource()==showDonorBtn){
            textArea.setText(donorList.showAllAsString());
        }else if(e.getSource()==showReceiverBtn){
            textArea.setText(receiverList.showAllAsString());
        }else if(e.getSource()==showAllBtn){
            textArea.setText(donorList.showAllAsString()+receiverList.showAllAsString());
        }else if(e.getSource()==clearScreenBtn){
            textArea.setText("");
        }else if(e.getSource()==searchBtn){
            if(!searchTextField.getText().isEmpty()){
				Donor d=donorList.getByContactNumber(searchTextField.getText());
                Receiver r=receiverList.getByContactNumber(searchTextField.getText());
                String areaDonor=donorList.getByAreaNameAsString(searchTextField.getText());
                String areaReceiver=receiverList.getByAreaNameAsString(searchTextField.getText());
				if(d!=null && r!=null){
					textArea.setText(d.getAllAsString()+"\n"+r.getAllAsString());
                    if(d.getContactNumber().equals(r.getContactNumber())){
                    }
                    // System.out.println("d+r");
				}else if(d!=null){
					textArea.setText(d.getAllAsString());
                    // System.out.println("d");
				}else if(r!=null){
                    textArea.setText(r.getAllAsString());
                    // System.out.println("r");
                }else if(!areaDonor.isEmpty() && !areaReceiver.isEmpty()){
                    textArea.setText(areaDonor+areaReceiver);
                }else if(!areaDonor.isEmpty()){
                    textArea.setText(areaDonor);
                }else if(!areaReceiver.isEmpty()){
                    textArea.setText(areaReceiver);
                }else{
                    JOptionPane.showMessageDialog(this,"None Found.");
                }
			}else{
                JOptionPane.showMessageDialog(this,"Please enter something to search.");
            }
        }else if(e.getSource()==userUpdateBtn){
            Donor d=donorList.getByContactNumber(searchTextField.getText());
            Receiver r=receiverList.getByContactNumber(searchTextField.getText());
            if(d!=null && r!=null){
                d.setUserId(userTextField.getText());
                DonorFileIO.inputDonorInFile(donorList);
                r.setUserId(userTextField.getText());
                ReceiverFileIO.inputReceiverInFile(receiverList);
                updateTextArea();
            }else if(d!=null){
                d.setUserId(userTextField.getText());
                DonorFileIO.inputDonorInFile(donorList);
                updateTextArea();
            }else if(r!=null){
                r.setUserId(userTextField.getText());
                ReceiverFileIO.inputReceiverInFile(receiverList);
                updateTextArea();
            }
        }
    }

    public void updateTextArea(){
		textArea.setText(donorList.showAllAsString()+receiverList.showAllAsString());
	}

    // public static void main(String[] args){
    //     AdminPage admin=new AdminPage();
    //     // admin.setVisible(true);
    // }

}
