package File;

import java.util.*;

import Entity.*;
import EntityList.*;

import java.io.*;

public class AdminFileIO {

    public static boolean checkAdminUser(String cuser, String cpass){ // cuser = current user, cpass=current password
        boolean valid=false;
        try{
            Scanner sc=new Scanner(new File("./File/Data/AdminInformation.txt"));
            while(sc.hasNextLine()){
                // String line = sc.nextLine();
                // String data[]= line.split(";");
                // System.out.println(sc.nextLine());
                String data[] = sc.nextLine().split(";");
                if(cuser.equals(data[0]) && cpass.equals(data[1])){ // admin:admin = data[0]:data[1] = cuser:cpass
                    valid=true;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("File not found.");
        }
        return valid;
    }

    //Update Admin
    public static void updateProfile(String userName){
        try{
            
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

    public static void inputAdminInFile(AdminList adminList){
		try{
            FileWriter fw = new FileWriter("./File/Data/AdminInformation.txt");
            Admin admin[] = adminList.getAllAdmins();
            String s="";
            for(int i=0;i<admin.length;i++){
                if(admin[i]!=null){
                    String tmp = admin[i].getUserId()+";";
                    tmp+=admin[i].getName()+";";
                    tmp+=admin[i].getContactNumber()+";";
                    tmp+=admin[i].getEmailAddress()+";";
                    tmp+=admin[i].getAreaName()+";";
                    tmp+=admin[i].getZipCode()+";";
                    tmp+=admin[i].getPassword();
                    fw.write(tmp+"\n");
                }
            }
            fw.close();
		}catch(Exception e){
			System.out.println("Cannot Write in File");
		}
	}

}
