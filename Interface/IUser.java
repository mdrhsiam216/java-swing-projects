package Interface;

import Entity.User;

public interface IUser{
    //Features

	// Insert User

	public void insert(User u);

	// Get Info
	public User getByUserId(String userId);
    public User getByName(String name);
    public User getByContactNumber(String contactNumber);
    public User getByEmailAddress(String emailAddress);

	// Update User Info
    public void updateByUserId(String userId, String newId);
	public void updateByName(String name , String newName);
	public void updateByContactNumber(String contactNumber , String newContactNumber);
	public void updateByEmailAddress(String emailAddress , String newEmailAddress);

	// Delete User
	public void deleteByUserId(String userId);
	public void deleteByName(String name);
	public void deleteByContactNumber(String contactNumber);
	public void deleteByEmailAddress(String emailAddress);

	// Show All
	public void showAllUsers();

	// Show all as string
	public String showAllAsString();

}
