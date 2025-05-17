package Entity;

public class Syrup extends Medicine {
    private int quantity;

    // Parameterized constructor
    public Syrup(String name, String expireDate, double price, String company, int quantity) {
        super(name, price, expireDate, company); // Call to parent class constructor
        this.quantity = quantity;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
