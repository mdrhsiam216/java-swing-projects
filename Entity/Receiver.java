package Entity;

public class Receiver extends User{

    //Member Variable
    private String bloodType;
    public static int receiverCount=0;

    // Default constructor
    public Receiver(){
        // System.out.println("E-Constructor");
        // receiverCount++;
    }

    // Parameterized constructor
    public Receiver(String userId, String name, String contactNumber, String emailAddress, String areaName, String zipCode, String bloodType, String password){
        // System.out.println("P-Constructor");
        super(userId, name, contactNumber, emailAddress, areaName, zipCode, password);
        setBloodType(bloodType);
        // receiverCount++;
    }

    // Setter Methods

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    // Getter Methods
    public String getBloodType() {
        return bloodType;
    }

    public static int getReceiverCount(){
        return receiverCount;
    }

    public String getAllAsString(){
		String r = "";
        r+=super.getAllAsString();
		// d+="=======================\n";
        r+="Blood Needed: " + getBloodType() +"\n";
        // d+="Medical Certificate: " + medicalCertificate +"\n";
        r+="Account: Receiver\n";
		r+="=======================";
        return r;
	}
}
