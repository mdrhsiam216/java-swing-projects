package EntityList;

import java.util.ArrayList;

import Entity.Disease;
import File.FileIO;

public class DiseaseList {
    private static ArrayList <Disease>  diseases = new ArrayList<Disease>();

    public static void loadDisease(){
        ArrayList line = FileIO.readFIle("./File/disease.txt");

        for(int i= 0; i< line.size();i++){
            String s= line.get(i).toString();
            String[] temp = s.split(";");
            //int id, String name
            int id = Integer.parseInt(temp[0]);
            String name = temp[1];
            diseases.add(new Disease(id, name));
        }
    }

    public static Disease getDiseaseByname(String name){
        for (Disease d : diseases) {
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }
    public static ArrayList getDiseaseList(){
        return diseases;
    }
}
