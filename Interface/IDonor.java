package Interface;

import Entity.Donor;

public interface IDonor extends IUser{

    //Features

	// Insert Donor
	public void insert(Donor d);

	//Get Info
	public Donor getByUserId(String userId);
	public Donor getByBloodGroup(String bloodGroup);
	public Donor getByRhFactor(String rhFactor);
	public Donor getByMedicalCertificate(boolean medicalCertificate);
	public Donor getByAreaName(String areaName);
	public Donor getByZipCode(String zipCode);

	// Update Donor Info
	public void updateByBloodGroup(String userId, String newbloodGroup);
	public void updateByRhFactor(String userId, String newrhFactor);
	public void updateByMedicalCertificate(String userId, boolean newmedicalCertificate);
	public void updateByAreaName(String userId, String newareaName);
	public void updateByZipCode(String userId, String newzipCode);

	// Delete Donor
	public void deleteByBloodGroup(String bloodGroup);
	public void deleteByRhFactor(String rhFactor);
	public void deleteByMedicalCertificate(boolean medicalCertificate);
	public void deleteByAreaName(String areaName);
	public void deleteByZipCode(String zipCode);

	// Show All
	public void showAllDonors();

	// Show all as string
	public String showAllAsString();

}