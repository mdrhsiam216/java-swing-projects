package EntityList;

import Entity.*;
import Interface.IReceiver;

public class ReceiverList extends List implements IReceiver{

    // Member variable
    private Receiver[] receivers;

    // Default Constructor
    public ReceiverList(){
		// System.out.println("E-Constructor");
        receivers = new Receiver[100];
    }

    // Parameterized Constructor
    public ReceiverList(int size){
		// System.out.println("P-Constructor");
        receivers = new Receiver[size];
    }

    // Features

    // Insert Receiver

    public void insert(Receiver r) {
        boolean flag=false;
        for (int i=0; i<receivers.length; i++) {
            if (receivers[i] == null) {
                receivers[i] = r;
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Receiver Saved Successfully");
        }else{
            System.out.println("Receiver List Full!");
        }
    }

    // Get Info

	// @Override // Override the methods from List class

    public Receiver getByUserId(String userId) {
        Receiver r = null;
        for (int i=0; i<receivers.length; i++) {
        // if (receivers[i] != null && receivers[i].getUserId().equals(userId)) {
            if(receivers[i] != null){
				if(receivers[i].getUserId()==userId ){
					r = receivers[i];
					break;
				}
			}
        }
        return r;
    }

    public Receiver getByContactNumber(String contactNumber){
		Receiver r = null;
		for(int i=0;i<receivers.length;i++){
			if(receivers[i] != null){
				if(receivers[i].getContactNumber().equals(contactNumber)){
					r = receivers[i];
					break;
				}
			}
		}
		return r;
	}

    public String getByAreaNameAsString(String areaName){
		String s="";
		Receiver r = null;
		for(int i=0;i<receivers.length;i++){
        	if(receivers[i] != null){
				if(receivers[i].getAreaName().equals(areaName) ){
					r = receivers[i];
				    s+=r.getAllAsString()+"\n";
				}
			}
		}
		return s;
	}

    public Receiver getByAreaName(String areaName){
		Receiver r = null;
		for(int i=0;i<receivers.length;i++){
        	if(receivers[i] != null){
				if(receivers[i].getAreaName().equals(areaName) ){
					r = receivers[i];
				    break;
				}
			}
		}
		return r;
	}

    public Receiver getByBloodType(String bloodType){
        Receiver r = null;
        for (int i = 0; i < receivers.length; i++){
            if(receivers[i] != null){
                if(receivers[i].getBloodType()==bloodType ){
                    r = receivers[i];
                    break;
                }
            }
        }
        return r;
    }

    // Update Donor Info

    public void updateByBloodType(String userId, String newbloodType){
        Receiver receivers = getByUserId(userId);
        if(receivers != null){
            receivers.setBloodType(newbloodType);
            System.out.println("Blood Group updated successfully.");
        }else{
            System.out.println("Blood Group not found.");
        }
    }

    public String getByBloodTypeAsString(String bloodType){
		String s="";
		Receiver r = null;
		for(int i=0;i<receivers.length;i++){
        	if(receivers[i] != null){
				if(receivers[i].getBloodType().equals(bloodType) ){
					r = receivers[i];
				    s+=r.getAllAsString()+"\n";
				}
			}
		}
		return s;
	}

    // Delete Receiver

    public void deleteByUserId(String userId) {
        boolean flag = false;
        for (int i = 0; i < receivers.length; i++) {
            if(receivers[i] != null){
                if(receivers[i].getUserId()==userId ){
                    receivers[i]=null;
                    flag=true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Receiver Deleted Successfully");
        }else{
            System.out.println("Receiver with User ID " + userId + " Not Found!");
        }
    }

    public void deleteByContactNumber(String contactNUmber) {
        boolean flag = false;
        for (int i = 0; i < receivers.length; i++) {
            if(receivers[i] != null){
                if(receivers[i].getContactNumber()==contactNUmber ){
                    receivers[i]=null;
                    flag=true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Receiver Deleted Successfully");
        }else{
            System.out.println("Receiver with User ID " + contactNUmber + " Not Found!");
        }
    }

    public void deleteByBloodType(String bloodType) {
        boolean flag = false;
        for (int i = 0; i < receivers.length; i++) {
            if(receivers[i] != null){
                if(receivers[i].getBloodType()==bloodType ){
                    receivers[i]=null;
                    flag=true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Receiver with Blood Type " + bloodType + " Deleted Successfully");
        }else{
            System.out.println("No Receiver with Blood Type " + bloodType + " Found!");
        }
    }

    // Show All

    public void showAllReceivers() {
        for (int i = 0; i < receivers.length; i++) {
            if (receivers[i] != null) {
                receivers[i].showAll();
            }
        }
    }

    // Show all as string

    public String showAllAsString() {
        String r="";
        r+=super.showAllAsString();
        for (int i=0; i<receivers.length; i++) {
            if (receivers[i] != null) {
                r+=receivers[i].getAllAsString() + "\n";
            }
        }
        return r;
    }

    public Receiver[] getAllReceivers(){
        return receivers;
    }

}
