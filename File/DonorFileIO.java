package File;

import java.util.*;

import Entity.*;
import EntityList.*;

import java.io.*;

public class DonorFileIO{

    // Password Check
    public static boolean checkDonorUser(String cuser, String cpass){ // cuser = current user
        boolean valid=false;
        try{
            Scanner sc=new Scanner(new File("./File/Data/DonorInformation.txt"));
            while(sc.hasNextLine()){
                String data[] = sc.nextLine().split(";");
                if(cuser.equals(data[0]) && cpass.equals(data[8])){
                    valid=true;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("File not found.");
        }
        return valid;
    }

    // Load Donor
    public static void loadReceiver(ReceiverList receiverList){
        try{
            Scanner sc=new Scanner(new File("./File/Data/ReceiverInformation.txt"));
            while(sc.hasNextLine()){
                String data[] = sc.nextLine().split(";");
                // Receiver receiver=new Receiver(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                receiverList.insert(new Receiver(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
            }
            sc.close();
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

    // Register Donor
    public static void registerDonor(Donor d){
        try{
            FileWriter fw=new FileWriter(new File("./File/Data/DonorInformation.txt"), true); // appended
            fw.write(d.getUserId()+";"+d.getName()+";"+d.getContactNumber()+";"+d.getEmailAddress()+";"+d.getAreaName()+";"+
                        d.getZipCode()+";"+d.getBloodGroup()+";"+d.getRhFactor()+";"+d.getPassword()+"\n");
            // fw.flush();
            fw.close();
            System.out.println("Donor Information added.");
            // fw=new FileWriter(new File("./File/Data/DonorLogin.txt"), true); // appended
            // fw.write(d.getUserId()+":"+pass+"\n");
            // fw.close();
            // System.out.println("Donor Login added.");
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

    public static void inputDonorInFile(DonorList donorList){
		try {
            FileWriter fw = new FileWriter("./File/Data/DonorInformation.txt");
            Donor donor[] = donorList.getAllDonors();
            String s="";
            for(int i=0;i<donor.length;i++){
                if(donor[i]!=null){
                    String tmp = donor[i].getUserId()+";";
                    tmp+=donor[i].getName()+";";
                    tmp+=donor[i].getContactNumber()+";";
                    tmp+=donor[i].getEmailAddress()+";";
                    tmp+=donor[i].getAreaName()+";";
                    tmp+=donor[i].getZipCode()+";";
                    tmp+=donor[i].getBloodGroup()+";";
                    tmp+=donor[i].getRhFactor()+";";
                    tmp+=donor[i].getPassword();
                    fw.write(tmp+"\n");
                }
            }
            fw.close();
		}catch(Exception e){
			System.out.println("Cannot Write in File");
		}
	}

}