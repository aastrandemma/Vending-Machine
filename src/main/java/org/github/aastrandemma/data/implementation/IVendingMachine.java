package org.github.aastrandemma.data.implementation;

import org.github.aastrandemma.data.model.Product;

public interface IVendingMachine {
    int[] PREDETERMINED_AMOUNT = {1,2,5,10,20,50,100,200,500,1000};

    void addCurrency(int amount);
    int getBalance();
    Product request(int id);
    int endSession();
    String getDescription(int id);
    String[] getProducts();
}
