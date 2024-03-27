package org.github.aastrandemma.model;

public class VendingMachineImpl implements IVendingMachine {
    private final Product[] products;
    private int depositPool;

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
            System.out.println("The vending machine can't accept: " + amount);
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
                    item.setQuantity(1);
                    depositPool = (int) (depositPool - item.getPrice());
                } else {
                    int calculate = (int) item.getPrice() - depositPool;
                    System.out.println(item.getProductName() + " cost "
                            + item.formatPrice(item.getPrice()) + "SEK, you need to deposit " + calculate + "SEK");
                }
                return item;
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        return depositPool = 0;
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
            examineProducts[i] = "Id: " + item.getId() + ", " + getDescription(item.getId());
            i++;
        }
        return examineProducts;
    }
}