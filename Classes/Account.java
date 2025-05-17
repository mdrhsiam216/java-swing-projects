package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Account {

    private String username;
    private String phoneNumber;
    private String studentID;
    private String vehicleInfo;
    private String paymentMethod;
    private String password;
	private String parkingLot;

    public Account() {
      
    }

    public Account(String username, String phoneNumber, String studentID, String vehicleInfo, String paymentMethod, String password, String parkingLot) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.studentID = studentID;
        this.vehicleInfo = vehicleInfo;
        this.paymentMethod = paymentMethod;
        this.password = password;
		this.parkingLot = parkingLot;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void addAccount() {
        try {
            File file = new File(".\\Users\\user.txt");
            file.createNewFile();

            FileWriter writer = new FileWriter(file, true);
            writer.write(getUsername() + "\t");
            writer.write(getPhoneNumber() + "\t");
            writer.write(getStudentID() + "\t");
            writer.write(getVehicleInfo() + "\t");
            writer.write(getPaymentMethod() + "\t");
            writer.write(getPassword() + "\t");
			writer.write(parkingLot + "\n");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public boolean checkAccount(String studentID, String password) {
    boolean isValid = false;
    File file = new File(".\\Users\\User.txt");

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split("\t");

            

            if (values.length >= 4 && values[2].equals(studentID) && values[5].equals(password)) {
                isValid = true;
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

   

    return isValid;
}


}
