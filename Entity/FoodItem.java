package Entity;
import interfaces.*;

public abstract class FoodItem implements IQuantity
{
    protected String fid;
    protected String name;
    protected int availableQuantity;
    protected double price;

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableQuantity(int quantity) {
        this.availableQuantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFid() {
        return fid;
    }

    public String getName() {
        return name;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public abstract void showInfo();

}