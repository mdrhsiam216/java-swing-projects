package Entity;

public class FoodCourt
{
    private String name;
    private String id;

    public FoodCourt(String name,String id){
        this.name = name;
        this.id=id;
    }
    //set method
    public void setName(String name) {this.name = name;}
    public void setId(String id) {this.id = id;}
    //get method
    public String getName() {return this.name;}
    public String getId(){ return this.id;}

    
}