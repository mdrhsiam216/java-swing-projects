package EntityList;

import Entity.User;
import Interface.IUser;

public class List implements IUser{

    //Member variable
    private User users[];

    //Default Constructor
    public List(){
        // System.out.println("E-Constructor");
        users=new User[100]; // Create list of 100 users
    }

    //Paramiterized Constructor
    public List(int size){
		// System.out.println("P-Constructor");
        users=new User[size];
    }

    //Features

	// Insert User

	public void insert(User u){
        boolean flag=false;
        for(int i=0; i<users.length; i++){
            if(users[i]==null){
                users[i]=u;
                flag=true;
                break;
            }
        }
        if(flag){System.out.println("User Added Successfully ");}
		else{System.out.println("User is not Added !!");}
    }

	// Get Info

	public User getByUserId(String userId){
		User u = null;
		for(int i=0; i<users.length; i++){
			if(users[i] != null){
				if(users[i].getUserId()==userId){
					u = users[i];
					break;
				}
			}
		}
		return u;
	}

    public User getByName(String name){
		User u = null;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getName().equals(name)){
					u = users[i];
					break;
				}
			}
		}
		return u;
	}

    public User getByContactNumber(String contactNumber){
		User u = null;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getContactNumber().equals(contactNumber)){
					u = users[i];
					break;
				}
			}
		}
		return u;
	}

    public User getByEmailAddress(String emailAddress){
		User u = null;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getEmailAddress().equals(emailAddress)){
					u = users[i];
					break;
				}
			}
		}
		return u;
	}

	// Update User Info

    public void updateByUserId(String userId, String newId) {
        User user = getByUserId(userId);
        if (user != null) {
            user.setUserId(newId);
            System.out.println("User id updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

	public void updateByName(String name , String newName) {
        User user = getByName(name);
        if (user != null) {
            user.setName(newName);
            System.out.println("User name updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

	public void updateByContactNumber(String contactNumber , String newContactNumber) {
        User user = getByContactNumber(contactNumber);
        if (user != null) {
            user.setContactNumber(newContactNumber);
            System.out.println("User contactNumber updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

	public void updateByEmailAddress(String emailAddress , String newEmailAddress) {
        User user = getByEmailAddress(emailAddress);
        if (user != null) {
            user.setEmailAddress(newEmailAddress);
            System.out.println("User emailAddress updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

	// Delete User

	public void deleteByUserId(String userId){
		boolean flag = false;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getUserId()==userId){
					users[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("User Deleted Successfully ");}
		else{System.out.println("No User with this Id!");}
	}

	public void deleteByName(String name){
		boolean flag = false;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getName().equals(name) ){
					users[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("User Deleted Successfully ");}
		else{System.out.println("No User with this Name!");}
	}

	public void deleteByContactNumber(String contactNumber){
		boolean flag = false;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getContactNumber().equals(contactNumber) ){
					users[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("User Deleted Successfully ");}
		else{System.out.println("No User with this ContactNumber!");}
	}

	public void deleteByEmailAddress(String emailAddress){
		boolean flag = false;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if(users[i].getEmailAddress().equals(emailAddress) ){
					users[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("User Deleted Successfully ");}
		else{System.out.println("No User with this EmailAddress!");}
	}

	// Show All

	public void showAllUsers(){
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				users[i].showAll();
			}
		}
	}

	// Show all as string

	public String showAllAsString(){
		String s="";
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				s+=users[i].getAllAsString()+"\n";
			}
		}
		return s;
	}

}
