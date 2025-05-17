package Entity;

public class Catering {
    private int orderId;
    private String starter;
    private String mainCourse;
    private String beverage;

    //constructor
    public Catering(int orderId,String starter, String mainCourse, String beverage){
        System.out.println("const of catering");
        this.starter=starter;
        this.mainCourse=mainCourse;
        this.beverage = beverage;
    }
    public Catering() {}

    //set method
    public void setOrderId(int id) {this.orderId = id;}
    public void setStarter(String s) {this.starter = s;}
    public void setMainCourse(String mc){this.mainCourse = mc;}
    public void setBeverage(String b) {this.beverage = b;}
    //get method
    public int getOrderId(){return this.orderId;}
    public String getStarter() { return this.starter ;}
    public String getMainCourse() { return this.mainCourse ;}
    public String getBeverage() { return this.beverage ;}
}
