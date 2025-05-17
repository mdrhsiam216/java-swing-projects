package interfaces;
import java.lang.*;
import Entity.FoodItem;


public interface FoodItemOperations
{
    boolean insertFoodItem(FoodItem f);

    boolean removeFoodItem(FoodItem f);

    FoodItem searchFoodItem(String fid);

    void showAllFoodItems();
}
