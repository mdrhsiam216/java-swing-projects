package Entity;

public class User{ // Guest 

    //Member Variable
    private String userId;
    private String name;
    private String contactNumber;
    private String emailAddress;
    private String areaName;
    private String zipCode;
    private String password;
	public static int userCount=0;

    // Default constructor
    public User(){
        // System.out.println("E-Constructor");
        userCount++;
    }

    // Parameterized constructor
    public User(String userId, String name, String contactNumber, String emailAddress, String areaName, String zipCode, String password){
        // System.out.println("P-Constructor");
        setUserId(userId);
        setName(name);
        setContactNumber(contactNumber);
        setEmailAddress(emailAddress);
        setAreaName(areaName);
        setZipCode(zipCode);
        setPassword(password);
        userCount++;
    }

    // Setter Methods
    public void setUserId(String userId) {
        this.userId=userId;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber=contactNumber;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress=emailAddress;
    }
    public void setAreaName(String areaName) {
        this.areaName=areaName;
    }
    public void setZipCode(String zipCode) {
        this.zipCode=zipCode;
    }
    public void setPassword(String password){
        this.password=password;
    }

     // Getter Methods
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getAreaName() {
        return areaName;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getPassword(){
        return password;
    }

    public static int getUserCount(){
        return userCount;
    }

    // Show All Information Method

    public void showAll(){
        System.out.println("=======================");
        System.out.println("User ID: "+getUserId());
        System.out.println("Name: "+getName());
        System.out.println("Contact Number: "+getContactNumber());
        if(emailAddress!=null){ // Check if emailAddress has a value
            System.out.println("Email Address: "+getEmailAddress());
        }
        System.out.println("Area: " + getAreaName() +"\n");
		System.out.println("Zip Code: " + getZipCode() +"\n");
        // System.out.println("=======================");
    }

    public String getAllAsString(){
		String s = "";
		s+="=======================\n";
        s+="Username: " +getUserId()+"\n";
        s+="Name: " + getName()+"\n";
        s+="Contact Number: " + getContactNumber()+"\n";
        if(emailAddress!=null){
            s+="Email: " + getEmailAddress()+"\n";
        }
        s+="Area: " + getAreaName() +"\n";
		s+="Zip Code: " + getZipCode() +"\n";
        // s+="=======================";
        return s;
	}

}