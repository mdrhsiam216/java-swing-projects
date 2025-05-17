package Entity;

public class Others extends Medicine{
    private String type;

    public Others() {}

    public Others(String name, double price, String expireDate, String company, String type) {
        super(name, price, expireDate, company);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
