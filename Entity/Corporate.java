package Entity;

public class Corporate extends Event{
    private String theme;
    
    public Corporate(int eventId,String venue, Date date, String theme){
        super(eventId,venue,date);
        System.out.println("const of Corporate");

        this.theme = theme;
    }

    //set
    public void setTheme(String theme) {this.theme=theme;}
    //get
    public String getTheme() {return this.theme;}
}
