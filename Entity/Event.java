package Entity;

public class Event {
    private int eventId;
    private String venue;
    private Date date;

    //constructor
    public Event(int eventId,String venue, Date date){
        this.eventId=eventId;
        this.venue = venue;
        this.date = date;
    }
    public Event(){ }

    //set method
    public void setEventId(int id){
        this.eventId=id;
    }
    public void setVenue(String v) {
        this.venue = v;
    }
    public void setDate(Date d) {
        this.date = d;
    }

    //get method
    public int getEventId(){
        return eventId;
    }
    public String getVenue() {
        return venue;
    }
    public Date getDate() {
        return date;
    }
}