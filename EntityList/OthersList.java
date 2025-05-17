package EntityList;

import java.util.ArrayList;
import Entity.Others;  // Use Others instead of Consumable
import File.FileIO;

public class OthersList {
    public static ArrayList<Others> others = new ArrayList<>();

    // Load others from a file
    public static void loadOthers() {
        others.clear(); // Clear existing data before loading new data
        try {
            ArrayList<String> lines = FileIO.readFromFile("./File/others.txt");

            if (lines == null || lines.isEmpty()) {
                System.err.println("No data found in others.txt.");
                return;
            }

            for (String line : lines) {
                if(line.equals("")){
                    continue;
                }
                String[] temp = line.split(";");
                if (temp.length == 5) { // Ensure correct format: name;price;expireDate;company;type
                    try {
                        String name = temp[0];
                        double price = Double.parseDouble(temp[1]);
                        String expireDate = temp[2];
                        String company = temp[3];
                        String type = temp[4];

                        Others other = new Others(name, price, expireDate, company, type);
                        others.add(other);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid price format in line: " + line);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            System.out.println("Loaded " + others.size() + " others.");
        } catch (Exception e) {
            System.err.println("Error loading others: " + e.getMessage());
        }
    }

    // Add a new other to the list
    public static void addOther(Others other) {
        if (other != null) {
            others.add(other);
            System.out.println("Product added: " + other.getName());
        } else {
            System.err.println("Cannot add null product.");
        }
    }

    // Remove a product by name
    public static void removeOtherByName(String name) {
        if (others.removeIf(other -> other.getName().equalsIgnoreCase(name))) 
            System.out.println("Product with name '" + name + "' removed.");
        else System.err.println("No product found with name '" + name + "'.");
    }
    
    // Retrieve a product by name
    public static Others getOtherByName(String name) {
        for (Others other : others) {
            if (other.getName().equals(name)) {
                System.out.println("Product found with name '" + name + "'."); 
                return other;
            }
        }
        System.err.println("No product found with name '" + name + "'.");
        return null;
    }
}
