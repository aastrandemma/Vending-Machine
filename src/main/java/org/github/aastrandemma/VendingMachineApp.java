package org.github.aastrandemma;

import org.github.aastrandemma.model.*;

import java.util.Arrays;

public class VendingMachineApp {
    public static void main(String[] args) {
        Candy snickers = new Candy(CandyType.SNICKERS, 2, false);
        Candy snickersSugarFree = new Candy(CandyType.SNICKERS, 2, true);
        Cookie punschRoll = new Cookie(CookieType.PUNSCH_ROLL, 2, false);
        Cookie chocoChip = new Cookie(CookieType.CHOCOLATE_CHIP_COOKIE, 2, true);
        Soda pepsiMaxMango = new Soda(SodaType.PEPSI_MAX, "Mango", 2);
        Soda lokaPear = new Soda(SodaType.LOKA, "Pear", 2);
        Soda festisCactus = new Soda(SodaType.FESTIS, "Cactus", 2);

        Product[] items = {snickers, snickersSugarFree, punschRoll, chocoChip, pepsiMaxMango, lokaPear, festisCactus};

        VendingMachineImpl impl = new VendingMachineImpl(items);

        System.out.println(pepsiMaxMango.getQuantity());
        System.out.println(impl.getBalance());
        impl.addCurrency(1);
        System.out.println();

        System.out.println(impl.getBalance());
        System.out.println(impl.getDescription(3));
        impl.request(3);
        System.out.println(pepsiMaxMango.getQuantity());
        System.out.println(impl.getBalance());
        System.out.println();
        System.out.println(Arrays.toString(impl.getProducts()));
        System.out.println();
        System.out.println(chocoChip.use());
    }
}