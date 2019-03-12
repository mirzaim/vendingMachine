package vendingMachine;

import java.util.HashMap;

public class VendingMachine {
    private int id;
    private int saleCount;
    private int saleAmount;
    private HashMap<Product, Integer> products;

    public VendingMachine(int id) {
        this.id = id;
        this.saleCount = 0;
        this.saleAmount = 0;
        products = new HashMap<>();
    }

    public boolean buy(Product product) {
        int amount = 0;
        if(products.containsKey(product))
            amount = products.get(product);
        if (amount > 0) {
            saleAmount += product.getPrice();
            saleCount++;
            products.put(product, amount - 1);
            return true;
        } else
            return false;
    }

    public void addProduct(Product product, int amount) {
        int count = (products.containsKey(product)) ? products.get(product) : 0;
        products.put(product, count + amount);
    }

    public String bill() {
        return id + ":" + saleCount + "," + saleAmount;
    }
}
