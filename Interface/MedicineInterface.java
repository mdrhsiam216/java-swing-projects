package Interface;

public interface MedicineInterface {
    public void setName(String name);
    public void setExpireDate(String expireDate);
    public void setPrice(double price);
    public void setCompany(String company);

    public String getName();
    public String getExpireDate();
    public double getPrice();
    public String getCompany();
}