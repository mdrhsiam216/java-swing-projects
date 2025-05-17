package EntityList;

import java.util.ArrayList;

import Entity.Patient;
import Entity.Person;
import File.FileIO;

public class PatientList {
    public static ArrayList <Person> patientList = new ArrayList<>();

    public static void loadPatient(){
        ArrayList line = FileIO.readFIle("./File/patient.txt");

        for(int i= 0; i< line.size();i++){
            String s= line.get(i).toString();
            String[] temp = s.split(";");
            //int id,String name,String fName,String mName,int age,String gender,String contact,String email

            //1;ratul;salam;mina;23;male;01755555555;bugichugi668@gmail.com;fakibaji;0.00
            int id = 1;
            String name = temp[0];
            String fName = temp[1];
            String mName = temp[2];
            int age = Integer.parseInt(temp[3]);
            String gender = temp[4];
            String email = temp[6];
            String contact = temp[7];
            patientList.add(new Patient(id, name, fName, mName, age, gender, contact, email));
        }
    }

    public static ArrayList getPatients(){
        return  patientList;
    }

    public static void delPatByName(String name){
        for(Person p : patientList){
            if(p.getName().equals(name)){
                patientList.remove(p);
                break;
            }
        }
    }
}