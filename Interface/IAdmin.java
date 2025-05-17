package Interface;

import Entity.Admin;

public interface IAdmin extends IUser{

    // Features

	// Insert Admin
	public void insert(Admin a);

	// Get Info
	public Admin getByUserId(String userId);
    public Admin getByName(String name);
	public Admin getByContactNumber(String contactNumber);
	public Admin getByEmailAddress(String emailAddress);

	// Update Admin Info
    public void updateByUserId(String userId , String newId);
	public void updateByName(String name , String newName);
	public void updateByContactNumber(String contactNumber , String newContactNumber);
	public void updateByEmailAddress(String emailAddress , String newEmailAddress);

	// Delete Admin
	public void deleteByUserId(String userId);
	public void deleteByName(String name);
	public void deleteByContactNumber(String contactNumber);
	public void deleteByEmailAddress(String emailAddress);

	// Show All
	public void showAllAdmins();

	// Show all as string
	public String showAllAsString();

}
