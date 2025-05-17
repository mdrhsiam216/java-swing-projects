package Entity;

public class Decor extends Event{
    private double area;
    //constructor
    public Decor(int eventId,String venue, Date date, double area){
        super(eventId,venue,date);
        System.out.println("const of decor");

        this.area = area;
    }
    //set method
    public void setArea(double area) {this.area=area;}
    //get method
    public double getArea() {return this.area;}
}
