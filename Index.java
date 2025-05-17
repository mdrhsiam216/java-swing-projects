import EntityList.ConsumableList;
import EntityList.OthersList;
import EntityList.SyrupList;
import GUI.*;

public class Index {
    
    public static void main(String[] args) {
        ConsumableList.loadConsumables();
        SyrupList.loadSyrups();
        OthersList.loadOthers();
        new Login();
    }
}