package Entity;

public class Wedding extends Event{
    private String bride;
    private String groom;

    //constructor
    public Wedding(int eventId,String venue, Date date, String bride, String groom){
        super(eventId,venue,date);
        System.out.println("const of wedding");

        this.bride = bride;
        this.groom = groom;
    }
    //getter and setters for the bride and groom fields
    public String getBride() { return bride;}
    public void setBride(String bride) {this.bride=bride;}
    public String getGroom() {return groom;}
    public void setGroom(String groom) {this.groom=groom;}
}