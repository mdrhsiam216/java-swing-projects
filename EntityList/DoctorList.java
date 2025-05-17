package EntityList;
import java.util.ArrayList;
import Entity.Doctor;
import Entity.Person;
import File.FileIO;

public class DoctorList {
    //i'm gonna store all doctor objects here. it's static
    public static ArrayList <Person> doctors = new ArrayList<>();

    //automatically add doctor objects from the data stored
    public static void loadDoctor(){
        ArrayList line = FileIO.readFIle("./File/doctors.txt");

        for(int i= 0; i< line.size();i++){
            String s= line.get(i).toString();
            String[] temp = s.split(";");
            //int id,String name,String fName,String mName,int age,String gender,String contact,String email, String specialty, int fee

            //1;ratul;salam;mina;23;male;01755555555;bugichugi668@gmail.com;fakibaji;0.00
            int id = Integer.parseInt(temp[0]);
            System.out.println("getting "+id);
            String name = temp[1];
            String fName = temp[2];
            String mName = temp[3];
            int age = Integer.parseInt(temp[4]);
            String gender = temp[5];
            String contact = temp[6];
            String email = temp[7];
            String speciality = temp[8];
            int fee = Integer.parseInt(temp[9]);
            doctors.add(new Doctor(id, name, fName, mName, age, gender, contact, email, speciality, fee));
        }
    }

    public static Doctor getDocByname(String name){
        for (Person d : doctors) {
            if(d.getName().equals(name)){
                return (Doctor) d;
            }
        }
        return null;
    }

    public static void delDocByName(String name){
        for (Person d : doctors) {
            if(d.getName().equals(name)){
                doctors.remove(d);
                break;
            }
        }
    }
    
    public static ArrayList getDocList(){
        System.out.println("returning with "+ doctors.size());
        return doctors;
    }

    public static void addDoctor(Doctor a){
        doctors.add(a);
    }
}
