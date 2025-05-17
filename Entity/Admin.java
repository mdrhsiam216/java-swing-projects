package Entity;

public class Admin extends User{

    //Member Variable
    private static int adminCount=0;

    // Default constructor
    public Admin(){
        // System.out.println("E-Constructor");
        // adminCount++;
    }
    

    // Parameterized constructor
    public Admin(String userId, String name, String contactNumber, String emailAddress, String areaName, String zipCode, String password){
        // System.out.println("P-Constructor");
        super(userId, name, contactNumber, emailAddress, areaName, zipCode, password);
        // adminCount++;
    }

    @Override // Override the showAll method from User class
    public void showAll(){
        super.showAll();
    }

    public String getAllAsString(){
        String a="";
        a+=super.getAllAsString();
        return a;
	}

}
