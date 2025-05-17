package Entity;
import java.time.*;

public class Donor extends User{

    //Member Variable
    private String bloodGroup;
    private String rhFactor;
    private boolean medicalCertificate;  // Have fitness certificate? true=yes, false=no
    public static int donorCount=0;

    // Default constructor
    public Donor(){
        // System.out.println("E-Constructor");
        // setDonorCountUp(donorCount);
    }

    // Parameterized constructor
    // public Donor(String userId, String name, String contactNumber, String emailAddress, String bloodGroup, String rhFactor, LocalDate lastDonationDate, boolean medicalCertificate, String areaName, String zipCode){
    public Donor(String userId, String name, String contactNumber, String emailAddress,
                String areaName, String zipCode,String bloodGroup, String rhFactor, String password){
        // System.out.println("P-Constructor");
        super(userId, name, contactNumber, emailAddress, areaName, zipCode, password);
        setBloodGroup(bloodGroup);
        setRhFactor(rhFactor);
        // setMedicalCertificate(medicalCertificate);
        // setDonorCountUp(donorCount);
    }

    // Setter Methods
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }
    public void setMedicalCertificate(boolean medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }
    public void setDonorCountUp(){
        donorCount++;
    }
    public void setDonorCountDown(){
        donorCount--;
    }

    // Getter Methods
    public String getBloodGroup(){
        return bloodGroup;
    }
    public String getRhFactor(){
        return rhFactor;
    }
    public boolean getMedicalCertificate(){
        return medicalCertificate;
    }

    public static int getDonorCount(){
        return donorCount;
    }


    @Override // Override the showAll method from User class

    public void showAll(){
        super.showAll();
        System.out.println("Blood Group: " + getBloodGroup());
        System.out.println("Rh Factor: " + getRhFactor());
        // System.out.println("Medical Certificate: " + medicalCertificate);
    }

    public String getAllAsString(){
		String d = "";
        d+=super.getAllAsString();
		// d+="=======================\n";
        d+="Blood Group: " + getBloodGroup() +"\n";
        d+="Rh Factor: " + getRhFactor() +"\n";
        // d+="Medical Certificate: " + medicalCertificate +"\n";
        d+="Account: Donor\n";
		d+="=======================";
        return d;
	}

}