package vendingMachine;

import java.util.HashMap;

public class VendingMachine {
    private int id;
    private int saleCount;
    private int saleAmount;
    private HashMap<Product, Integer> products;


    public boolean buy(Product product){
        int amount = products.get(product);
        if (amount > 0){
            saleAmount += product.getPrice();
            saleCount++;
            products.put(product, amount-1);
            return true;
        }else
            return false;
    }

    public void addProduct(Product product, int amount){
    }


}
