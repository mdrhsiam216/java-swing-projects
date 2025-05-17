package Interface;

import Entity.Receiver;

public interface IReceiver extends IUser{
    // Features

    // Insert Receiver
    public void insert(Receiver r);

    // Get Info
    public Receiver getByUserId(String userId);
    public Receiver getByBloodType(String bloodType);

    // Update Donor Info
    public void updateByBloodType(String userId, String newbloodType);

    // Delete Receiver
    public void deleteByUserId(String userId);
    public void deleteByBloodType(String bloodType);

    // Show All
    public void showAllReceivers();

    // Show all as string
    public String showAllAsString();

}
