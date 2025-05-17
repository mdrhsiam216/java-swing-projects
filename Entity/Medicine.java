package Entity;

import Interface.MedicineInterface;

public abstract class Medicine implements MedicineInterface {
    private String name;
    private double price;
    private String expireDate;
    private String company;

    //default const
    public Medicine() {
        System.out.println("parent class");
    }

    //parameterized const
    public Medicine(String name, double price, String expireDate, String company) {
        this.name = name;
        this.price = price;
        this.expireDate = expireDate;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
