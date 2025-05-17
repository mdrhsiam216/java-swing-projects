package Entity;

public class Birthday extends Event{
    String name;
    //constructor
    public Birthday(int eventId,String venue, Date date, String name){
        super(eventId,venue,date);
        System.out.println("const of Bday");
        this.name=name;
    }
    //set method
    public void setName(String n) {this.name =n;}
    //get method
    public String getName() {return this.name;}
    
}
