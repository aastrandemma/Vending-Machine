package org.github.aastrandemma.data.implementation;

import org.github.aastrandemma.data.model.Product;
import org.github.aastrandemma.util.FormatData;

public class VendingMachineImpl implements IVendingMachine {
    private final Product[] products;
    private int depositPool;
    private int dispenseChange;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    private int getSize() {
        return products.length;
    }

    @Override
    public void addCurrency(int amount) {
        int match = 0;
        for (int checkAmount : PREDETERMINED_AMOUNT) {
            if (amount == checkAmount) {
                match++;
                depositPool += amount;
            }
        }
        if (match == 0) {
            System.out.println("The vending machine can't accept: " + amount + ",00");
        }
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for (Product item : products) {
            if (id == item.getId()) {
                if(depositPool >= (int)item.getPrice()) {
                    depositPool = (int) (depositPool - item.getPrice());
                    System.out.println(item.use());
                } else {
                    int calculate = (int) item.getPrice() - depositPool;
                    System.out.println(item.getProductName() + " cost "
                            + FormatData.formatPrice((item.getPrice())) + "SEK, you need to deposit " + calculate + ",00SEK");
                }
                return item;
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        dispenseChange = dispenseChange + depositPool;
        System.out.println("Here is your change " + dispenseChange +",00SEK. Thank you, bye!");
        depositPool = 0;
        return depositPool;
    }

    @Override
    public String getDescription(int id) {
        for (Product item : products) {
            if (id == item.getId()) {
                return item.examine();
            }
        }
        return null;
    }

    @Override
    public String[] getProducts() {
        String[] examineProducts = new String[getSize()];
        int i = 0;
        for (Product item : products) {
            examineProducts[i] = "id: " + item.getId() + ", name: " + item.getProductName() + ", price: " + FormatData.formatPrice(item.getPrice());
            i++;
        }
        return examineProducts;
    }
}