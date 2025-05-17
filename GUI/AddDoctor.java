package GUI;

import javax.swing.*;

import Entity.Doctor;
import EntityList.DoctorList;
import File.FileIO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDoctor extends JFrame implements ActionListener{
    private JLabel addDocLabel;
    private JLabel nameLabel;
    private JLabel fatherLabel;
    private JLabel motherLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel numberLabel;
    private JLabel emailLabel;
    private JLabel idLabel;
    private JTextField nameField;
    private JTextField fNameField;
    private JTextField mNameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField contField;
    private JTextField emaiField;
    private JTextField idField;
    private JButton addBtn;
    private JButton backBtn;
    private JLabel SpeciaLabel;
    private JTextField speciField;
    private JLabel feeLabel;
    private JTextField feeField;
    private ImageIcon icon,image;
    private JLabel background;
    private Font f1,f2;
    private String username;

    public AddDoctor(String username){
        this.username=username;
        addDocLabel = new JLabel();
        nameLabel = new JLabel();
        fatherLabel = new JLabel();
        motherLabel = new JLabel();
        ageLabel = new JLabel();
        genderLabel = new JLabel();
        numberLabel = new JLabel();
        emailLabel = new JLabel();
        idLabel = new JLabel();
        nameField = new JTextField();
        fNameField = new JTextField();
        mNameField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();
        contField = new JTextField();
        emaiField = new JTextField();
        idField = new JTextField();
        addBtn = new JButton();
        backBtn = new JButton();
        SpeciaLabel = new JLabel();
        speciField = new JTextField();
        feeLabel = new JLabel();
        feeField = new JTextField();
        
        this.setSize( 808, 695);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        f1 = new Font("Segoe UI Black", Font.BOLD, 18);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 14);

        // Icon
        icon = new ImageIcon(getClass().getResource("/Assets/13910992 (1).jpg"));
        this.setIconImage(icon.getImage());

        setTitle("Add doctor");
        this.setLayout(null);
        
        addDocLabel.setText("Add Doctor");
        SpeciaLabel.setText("speciallity");
        nameLabel.setText("Name");
        fatherLabel.setText("Father's Name");
        addBtn.setText("Add");
        motherLabel.setText("Mother's Name");
        feeLabel.setText("Fee");
        ageLabel.setText("Age");
        genderLabel.setText("Gender");
        numberLabel.setText("Contact Number");
        emailLabel.setText("Email Id");
        idLabel.setText("Id");
        
        backBtn.setText("Back");
        backBtn.setBackground(Color.RED);
        addBtn.setBackground(Color.ORANGE);
        
        ageLabel.setBounds(290, 230, 40, 20);
        addDocLabel.setBounds(330, 10, 120, 40);
        contField.setBounds(330, 320, 190, 40);
        emaiField.setBounds(330, 370, 190, 40);
        addBtn.setBounds(420, 600, 100, 40);
        idField.setBounds(330, 420, 190, 40);
        backBtn.setBounds(230, 600, 100, 40);
        SpeciaLabel.setBounds(240, 470, 80, 30);
        feeField.setBounds(330, 520, 190, 40);
        speciField.setBounds(330, 470, 190, 40);
        feeLabel.setBounds(278, 530, 30, 16);
        genderLabel.setBounds(270, 280, 60, 30);
        fatherLabel.setBounds(220, 130, 120, 20);
        emailLabel.setBounds(260, 370, 60, 40);
        numberLabel.setBounds(200, 330, 120, 30);
        idLabel.setBounds(300, 430, 30, 20);
        mNameField.setBounds(330, 170, 190, 40);
        nameLabel.setBounds(280, 80, 60, 20);
        nameField.setBounds(330, 70, 190, 40);
        ageField.setBounds(330, 220, 190, 40);
        motherLabel.setBounds(210, 170, 110, 30);
        genderField.setBounds(330, 270, 190, 40);
        fNameField.setBounds(330, 120, 190, 40);
        addDocLabel.setFont(f1);
        fatherLabel.setFont(f2);
        numberLabel.setFont(f2);
        addBtn.setFont(f2);
        ageLabel.setFont(f2);
        emailLabel.setFont(f2); 
        backBtn.setFont(f2);
        genderLabel.setFont(f2);
        motherLabel.setFont(f2);
        idLabel.setFont(f2);
        nameLabel.setFont(f2);
        feeLabel.setFont(f2); 
        SpeciaLabel.setFont(f2);
        
        
        contField.addActionListener(this);
        emaiField.addActionListener(this);
        ageField.addActionListener(this);
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);


        this.add(addDocLabel);
        this.add(nameLabel);
        this.add(fatherLabel);
        this.add(contField);
        this.add(motherLabel);
        this.add(ageLabel);
        this.add(genderLabel);
        this.add(numberLabel);
        this.add(emailLabel);
        this.add(idLabel);
        this.add(idField);
        this.add(nameField);
        this.add(fNameField);
        this.add(addBtn);
        this.add(mNameField);
        this.add(ageField);
        this.add(genderField);
        this.add(emaiField);
        this.add(SpeciaLabel);
        this.add(backBtn);
        this.add(feeField);
        this.add(speciField);
        this.add(feeLabel);

        //image
        image = new ImageIcon("./Assets/26760542 (1).jpg");
		background = new JLabel();
		background.setBounds(0,0,808,695);
		background.setIcon(image);
		this.add(background);
        
        this.setVisible(true);
        }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBtn){
            this.dispose();
            DoctMangement d= new DoctMangement(this.username);
        }
        else if (e.getSource() == addBtn) { 
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText().toString();
            String fName = fNameField.getText().toString();
            String mName = mNameField.getText();
            int age = Integer.parseInt(ageField.getText().toString());
            String gender = genderField.getText().toString();
            String cont =contField.getText().toString();
            String email = emaiField.getText().toString();
            String speciality = speciField.getText().toString();
            int fee = Integer.parseInt(feeField.getText().toString());


            if (name.isEmpty() || fName.isEmpty() || mName.isEmpty()|| ageField.getText().isEmpty() ||gender.isEmpty() || contField.getText().isEmpty() || email.isEmpty() || speciality.isEmpty() || feeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Fill all the data");
            }
            else{
                DoctorList.addDoctor(new Doctor(id, name, fName, mName, age, gender, cont,email, speciality, fee));
                String line= id+ ";"+name+";"+fName+";"+mName+";"+age+";"+gender+";"+cont+";"+email+";"+speciality+";"+fee;
                FileIO.writeInFile(line,"./File/doctors.txt",true);
                JOptionPane.showMessageDialog(null,"Doctor Added Successfully");
                this.dispose();
                DoctMangement d= new DoctMangement(this.username);
            }
        }
    }
}

