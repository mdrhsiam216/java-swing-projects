package Entity;

public class Restaurant {
    private String rid;
    private String name;

    public Restaurant (String rid,String name) {
        this.rid= rid;
        this.name = name;
    }
    public Restaurant()
    {
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public String getRid() {
        return rid;
    }
}