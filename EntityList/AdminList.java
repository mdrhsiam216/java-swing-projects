package EntityList;

import Entity.*;
import Interface.IAdmin;

public class AdminList extends List implements IAdmin{

    // Member variable
	private Admin admins[];

    // Default Constructor
	public AdminList(){
		// System.out.println("E-Constructor");
		admins=new Admin[100];
	}

    // Paramiterized Constructor
	public AdminList(int size){
		// System.out.println("P-Constructor");
        admins=new Admin[size];
    }

	// Features

	// Insert Admin

	public void insert(Admin a){
        boolean flag=false;
        for(int i=0; i<admins.length; i++){
            if(admins[i]==null){
                admins[i]=a;
                flag=true;
                break;
            }
        }
        if(flag){System.out.println("Admin Added Successfully ");}
		else{System.out.println("Admin is not Added !!");}
    }

	// Get Info

	@Override // Override the methods from List class

	public Admin getByUserId(String userId){
		Admin a=null;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getUserId()==(userId)){
					a = admins[i];
					break;
				}
			}
		}
		return a;
	}

	@Override // Override the methods from List class

    public Admin getByName(String name){
		Admin a=null;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getName().equals(name) ){
					a = admins[i];
					break;
				}
			}
		}
		return a;
	}

	@Override // Override the methods from List class

	public Admin getByContactNumber(String contactNumber){
		Admin a=null;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getContactNumber().equals(contactNumber)){
					a=admins[i];
					break;
				}
			}
		}
		return a;
	}

	@Override // Override the methods from List class

	public Admin getByEmailAddress(String emailAddress){
		Admin a=null;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getEmailAddress().equals(emailAddress) ){
					a = admins[i];
					break;
				}
			}
		}
		return a;
	}

	// Update Admin Info

	@Override // Override the methods from List class

    public void updateByUserId(String userId , String newId) {
        Admin admin = getByUserId(userId);
        if (admin != null) {
            admin.setUserId(newId);
            System.out.println("Admin id updated successfully.");
        } else {
            System.out.println("Admin not found.");
        }
    }

	@Override // Override the methods from List class

	public void updateByName(String name , String newName) {
        Admin admin = getByName(name);
        if (admin != null) {
            admin.setName(newName);
            System.out.println("Admin name updated successfully.");
        } else {
            System.out.println("Admin not found.");
        }
    }

	@Override // Override the methods from List class

	public void updateByContactNumber(String contactNumber , String newContactNumber) {
        Admin admin = getByContactNumber(contactNumber);
        if (admin != null) {
            admin.setContactNumber(newContactNumber);
            System.out.println("Admin contactNumber updated successfully.");
        } else {
            System.out.println("Admin not found.");
        }
    }

	@Override // Override the methods from List class

	public void updateByEmailAddress(String emailAddress , String newEmailAddress) {
        Admin admin = getByEmailAddress(emailAddress);
        if (admin != null) {
            admin.setEmailAddress(newEmailAddress);
            System.out.println("Admin emailAddress updated successfully.");
        } else {
            System.out.println("Admin not found.");
        }
    }

	// Delete Admin

	@Override // Override the methods from List class

	public void deleteByUserId(String userId){
		boolean flag = false;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getUserId()==userId){
					admins[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("Admin Deleted Successfully ");}
		else{System.out.println("No Admin with this Id!");}
	}

	@Override // Override the methods from List class

	public void deleteByName(String name){
		boolean flag = false;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getName().equals(name) ){
					admins[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("Admin Deleted Successfully ");}
		else{System.out.println("No Admin with this Name!");}
	}

	@Override // Override the methods from List class

	public void deleteByContactNumber(String contactNumber){
		boolean flag = false;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getContactNumber().equals(contactNumber) ){
					admins[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("Admin Deleted Successfully ");}
		else{System.out.println("No Admin with this ContactNumber!");}
	}

	@Override // Override the methods from List class

	public void deleteByEmailAddress(String emailAddress){
		boolean flag = false;
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				if(admins[i].getEmailAddress().equals(emailAddress) ){
					admins[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("Admin Deleted Successfully ");}
		else{System.out.println("No Admin with this EmailAddress!");}
	}

	// Show All

	public void showAllAdmins(){
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				admins[i].showAll();
			}
		}
	}

	// Show all as string

	public String showAllAsString(){
		String a="";
		a+=super.showAllAsString();
		for(int i=0;i<admins.length;i++){
			if(admins[i] != null){
				a+=admins[i].getAllAsString()+"\n";
			}
		}
		return a;
	}

	public Admin[] getAllAdmins(){
		return admins;
	}

}