package File;

import java.util.*;

import Entity.*;
import EntityList.*;

import java.io.*;

public class ReceiverFileIO{

    // Password Check
    public static boolean checkReceiverUser(String cuser, String cpass){ // cuser = current user
        boolean valid=false;
        try{
            Scanner sc=new Scanner(new File("./File/Data/ReceiverInformation.txt"));
            while(sc.hasNextLine()){
                String data[] = sc.nextLine().split(";");
                if(cuser.equals(data[0]) && cpass.equals(data[7])){
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
    public static void loadDonor(DonorList donorList){
        try{
            Scanner sc=new Scanner(new File("./File/Data/DonorInformation.txt"));
            while(sc.hasNextLine()){
                String data[] = sc.nextLine().split(";");
                Donor donor=new Donor(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                donorList.insert(new Donor(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
                // System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]);
            }
            sc.close();
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

    // Register Receiver
    public static void registerReceiver(Receiver r){
        try{
            FileWriter fw=new FileWriter(new File("./File/Data/ReceiverInformation.txt"), true); // appended
            fw.write(r.getUserId()+";"+r.getName()+";"+r.getContactNumber()+";"+r.getEmailAddress()+";"+r.getAreaName()+";"+r.getZipCode()+";"+r.getBloodType()+";"+r.getPassword()+"\n");
            fw.flush();
            fw.close();
            System.out.println("Receiver Information added.");
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

    public static void inputReceiverInFile(ReceiverList receiverList){
		try{
            FileWriter fw = new FileWriter("./File/Data/ReceiverInformation.txt");
            Receiver receiver[] = receiverList.getAllReceivers();
            String s="";
            for(int i=0;i<receiver.length;i++){
                if(receiver[i]!=null){
                    String tmp = receiver[i].getUserId()+";";
                    tmp+=receiver[i].getName()+";";
                    tmp+=receiver[i].getContactNumber()+";";
                    tmp+=receiver[i].getEmailAddress()+";";
                    tmp+=receiver[i].getAreaName()+";";
                    tmp+=receiver[i].getZipCode()+";";
                    tmp+=receiver[i].getBloodType()+";";
                    tmp+=receiver[i].getPassword();
                    fw.write(tmp+"\n");
                }
            }
            fw.close();
		}catch(Exception e){
			System.out.println("Cannot Write in File");
		}
	}

}
