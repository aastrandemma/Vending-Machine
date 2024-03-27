package org.github.aastrandemma;

import org.github.aastrandemma.data.implementation.VendingMachineImpl;
import org.github.aastrandemma.data.model.Drink;
import org.github.aastrandemma.data.model.Product;
import org.github.aastrandemma.data.model.Sandwich;
import org.github.aastrandemma.data.model.Snack;

public class VendingMachine {
    public static void main(String[] args) {
        // Initialize products
        Drink orangeSoda = new Drink(20, "Fanta", true);
        Drink water = new Drink(20, "Imsdal", false);
        Snack chips = new Snack(15, "Potato chips", false);
        Snack chiliNuts = new Snack(18, "Chili nuts", true);
        Sandwich blt = new Sandwich(50, "BLT", true, true);
        Sandwich cheeseNoGluten = new Sandwich(35, "Gluten free cheese sandwich", false, true);
        Sandwich cheeseNoGlutenNoLactose = new Sandwich(35, "Gluten- and lactose free cheese sandwich", false, false);

        // Fill the product array
        Product[] addProducts = {orangeSoda, water, chips, chiliNuts, blt, cheeseNoGluten, cheeseNoGlutenNoLactose};

        // Implement Vending Machine
        VendingMachineImpl impl = new VendingMachineImpl(addProducts);
        impl.addCurrency(100);
        Product product = impl.request(5);
        int end = impl.endSession();
    }
}