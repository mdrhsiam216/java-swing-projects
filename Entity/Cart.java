package Entity;

import java.util.ArrayList;

public class Cart {
    public static ArrayList<Medicine> cart = new ArrayList<>();

    public static void clearCart() {
        cart.clear();
    }
}