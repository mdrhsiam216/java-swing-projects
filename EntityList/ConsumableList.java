package EntityList;

import java.util.ArrayList;
import Entity.Consumable;
import File.FileIO;

public class ConsumableList {
    public static ArrayList<Consumable> consumables = new ArrayList<>();

    // Load consumables from a file
    public static void loadConsumables() {
        if (consumables!=null) {
            consumables.clear();
        }
        try {
            ArrayList<String> lines = FileIO.readFromFile("./File/consumables.txt");
            for (String line : lines) {
                if(line.equals("")){
                    continue;
                }
                String[] temp = line.split(";");
                if (temp.length == 5) { 
                    String name = temp[0];
                    double price = Double.parseDouble(temp[1]);
                    String expireDate = temp[2];
                    String company = temp[3];
                    String type = temp[4];
    
                    consumables.add(new Consumable(name, price, expireDate, company, type));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println("Loaded " + consumables.size() + " consumables.");
        } catch (Exception e) {
            System.err.println("Error loading consumables: " + e.getMessage());
        }
    }    

    // Add a new consumable to the list
    public static void addConsumable(Consumable consumable) {
        if (consumable != null) {
            consumables.add(consumable);
            System.out.println("Consumable added: " + consumable.getName());
        } else {
            System.out.println("Cannot add null consumable.");
        }
    }

    // Remove a consumable by name
    public static void removeConsumableByName(String name) {
        if (consumables.removeIf(consumable -> consumable.getName().equalsIgnoreCase(name))) {
            System.out.println("Consumable with name '" + name + "' removed.");
        } else {
            System.out.println("No consumable found with name '" + name + "'.");
        }
    }

    // Retrieve a consumable by name
    public static Consumable getConsumableByName(String name) {
        for (Consumable consumable : consumables) {
            if (consumable.getName().equalsIgnoreCase(name)) {
                return consumable;
            }
        }
        return null;
    }
}
