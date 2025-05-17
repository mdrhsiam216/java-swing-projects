package EntityList;

import Entity.*;
import Interface.IDonor;

public class DonorList extends List implements IDonor{

    //Member variable
    private Donor donors[];

	//Default Constructor
	public DonorList(){
		// System.out.println("E-Constructor");
		donors = new Donor[100];
	}

    //Paramiterized Constructor
	public DonorList(int size){
		// System.out.println("P-Constructor");
		donors = new Donor[size];
	}

	//Features

	// Insert Donor

	public void insert(Donor d){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] == null){
				donors[i] = d;
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Donor Saved Successfully ");
		}else{
			System.out.println("Donor is Not Saved !!!");
		}
	}

	//Get Info

	@Override // Override the methods from List class

	public Donor getByUserId(String userId){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getUserId()==userId ){
					d = donors[i];
					break;
				}
			}
		}
		return d;
	}

	public Donor getByContactNumber(String contactNumber){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getContactNumber().equals(contactNumber)){
					d = donors[i];
					break;
				}
			}
		}
		return d;
	}

	public Donor getByBloodGroup(String bloodGroup){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getBloodGroup().equals(bloodGroup) ){
					d = donors[i];
					break;
				}
			}
		}
		return d;
	}

	public Donor getByRhFactor(String rhFactor){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
			    if(donors[i].getRhFactor().equals(rhFactor) ){
				    d = donors[i];
					break;
				}
			}
		}
		return d;
	}

	public Donor getByMedicalCertificate(boolean medicalCertificate){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
		    if(donors[i] != null){
				if(donors[i].getMedicalCertificate()==medicalCertificate){
					d = donors[i];
					break;
				}
			}
		}
		return d;
	}

	public Donor getByAreaName(String areaName){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
        	if(donors[i] != null){
				if(donors[i].getAreaName().equals(areaName) ){
					d = donors[i];
				    
				}
			}
		}
		return d;
	}

	public String getByAreaNameAsString(String areaName){
		String s="";
		Donor d = null;
		for(int i=0;i<donors.length;i++){
        	if(donors[i] != null){
				if(donors[i].getAreaName().equals(areaName) ){
					d = donors[i];
				    s+=d.getAllAsString()+"\n";
				}
			}
		}
		return s;
	}

	public Donor getByZipCode(String zipCode){
		Donor d = null;
		for(int i=0;i<donors.length;i++){
        	if(donors[i] != null){
				if(donors[i].getZipCode().equals(zipCode) ){
					d = donors[i];
				    break;
				}
			}
		}
		return d;
	}

	// Update Donor Info

	public void updateByContactNumber(String contactNumber , String newContactNumber) {
        Donor donor = getByContactNumber(contactNumber);
        if (donor != null) {
            donor.setContactNumber(newContactNumber);
            System.out.println("Donor contactNumber updated successfully.");
        } else {
            System.out.println("Donor not found.");
        }
    }

	public void updateByBloodGroup(String userId, String newbloodGroup) {
		Donor donors = getByUserId(userId);
		if (donors != null) {
			donors.setBloodGroup(newbloodGroup);
			System.out.println("Blood Group updated successfully.");
		}else{
			System.out.println("Blood Group not found.");
		}
	}

	public void updateByRhFactor(String userId, String newrhFactor) {
		Donor donors = getByUserId(userId);
		if (donors != null) {
			donors.setRhFactor(newrhFactor);
			System.out.println("Rh Factor updated successfully.");
		}else{
			System.out.println("Rh Factor not found.");
		}
	}

	public void updateByMedicalCertificate(String userId, boolean newmedicalCertificate) {
		Donor donors = getByUserId(userId);
		if (donors != null) {
			donors.setMedicalCertificate(newmedicalCertificate);
			System.out.println("Medical Certificate updated successfully.");
		}else{
			System.out.println("Medical Certificate not found.");
		}
	}

	public void updateByAreaName(String userId, String newareaName) {
		Donor donors = getByUserId(userId);
		if (donors != null) {
			donors.setAreaName(newareaName);
			System.out.println("Area Name updated successfully.");
		}else{
			System.out.println("Area Name not found.");
		}
	}

	public void updateByZipCode(String userId, String newzipCode) {
		Donor donors = getByUserId(userId);
		if (donors != null) {
			donors.setZipCode(newzipCode);
			System.out.println("Zip Code updated successfully.");
		}else{
			System.out.println("Zip Code not found.");
		}
	}

	// Delete Donor

	public void deleteByBloodGroup(String bloodGroup){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getBloodGroup().equals(bloodGroup) ){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Donor Deleted Successfully ");
		}else{
			System.out.println("No Donor with this Blood Group !!!");
		}
	}

	public void deleteByRhFactor(String rhFactor){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getRhFactor().equals(rhFactor) ){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Donor Deleted Successfully ");
		}else{
			System.out.println("No Donor with this Rh Factor !!!");
		}
	}

	public void deleteByMedicalCertificate(boolean medicalCertificate){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getMedicalCertificate()==medicalCertificate){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Donor Deleted Successfully ");
		}else{
			System.out.println("No Donor with this Medical Certificate !!!");
		}
	}

	public void deleteByAreaName(String areaName){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getAreaName().equals(areaName) ){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Donor Deleted Successfully ");
		}else{
			System.out.println("No Donor with this Area Name !!!");
		}
	}

	public void deleteByZipCode(String zipCode){
		boolean flag = false;
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				if(donors[i].getZipCode().equals(zipCode) ){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Donor Deleted Successfully ");
		}else{
			System.out.println("No Donor with this Zip Code !!!");
		}
	}

	
	// Show All
	
	public void showAllDonors(){
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				donors[i].showAll();
			}
		}
	}

	// Show all as string

	public String showAllAsString(){
		String d="";
		d+=super.showAllAsString();
		for(int i=0;i<donors.length;i++){
			if(donors[i] != null){
				d+=donors[i].getAllAsString()+"\n";
			}
		}
		return d;
	}

	public Donor[] getAllDonors(){
		return donors;
	}

}