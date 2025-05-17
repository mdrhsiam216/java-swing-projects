package EntityList;

import java.util.ArrayList;
import Entity.Syrup;
import File.FileIO;

public class SyrupList {
    public static ArrayList<Syrup> syrups = new ArrayList<>();

    // Load syrups from the file
    public static void loadSyrups() {
        try {
            ArrayList<String> lines = FileIO.readFromFile("./File/syrups.txt");
            for (String line : lines) {
                if(line.equals("")){
                    continue;
                }
                String[] temp = line.split(";");
                if (temp.length == 5) { // Ensure correct format: name;price;expireDate;company;quantity
                    String name = temp[0];
                    double price = Double.parseDouble(temp[1]);
                    String expireDate = temp[2];
                    String company = temp[3];
                    int quantity = Integer.parseInt(temp[4]);
                
                    syrups.add(new Syrup(name, expireDate, price, company, quantity));
                }
                 else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println("Loaded " + syrups.size() + " syrups.");
        } catch (Exception e) {
            System.err.println("Error loading syrups: " + e.getMessage());
        }
    }

    // Retrieve Syrup by name
    public static Syrup getSyrupByName(String name) {
        System.out.println("syrup name: " + name);
        for (Syrup syrup : syrups) {
            if (syrup.getName().equals(name)) {
                return syrup;
            }
        }
        return null;
    }

    // Delete Syrup by name
    public static void delSyrupByName(String name) {
        if (syrups.removeIf(syrup -> syrup.getName().equals(name))) {
            System.out.println("Syrup with name '" + name + "' deleted.");
        } else {
            System.out.println("No Syrup found with name '" + name + "'.");
        }
    }

    // Get all Syrups
    public static ArrayList<Syrup> getSyrupList() {
        return new ArrayList<>(syrups); 
    }

    // Add a new Syrup to the list
    public static void addSyrup(Syrup syrup) {
        if (syrup != null) {
            syrups.add(syrup);
            System.out.println("Syrup added: " + syrup.getName());
        } else {
            System.out.println("Cannot add null Syrup.");
        }
    }
}
