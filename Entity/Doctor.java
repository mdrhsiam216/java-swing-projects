package Entity;

public class Doctor extends Person{
    private String specialty;
    private int fee;

    public Doctor(int id,String name,String fName,String mName,int age,String gender,String contact,String email, String specialty, int fee){
        super(id, name, fName, mName, age, gender, contact, email);
        this.specialty = specialty;
        this.fee = fee;
    }
    public String getSpecialty() { 
        return specialty; 
    }
    public void setSpecialty(String specialty) { 
        this.specialty = specialty; 
    }
    public int getFee() { 
        return fee; 
    }
    public  void setFee(int fee) { 
        this.fee = fee; 
    }
}
