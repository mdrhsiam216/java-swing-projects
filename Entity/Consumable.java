package Entity;

public class Consumable extends Medicine {
    private String type;

    public Consumable() {}

    public Consumable(String name, double price, String expireDate, String company, String type) {
        super(name, price, expireDate, company);
        this.type = type;
    }

    // Getter and Setter for the `type` field
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
