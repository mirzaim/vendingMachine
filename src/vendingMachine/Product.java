package vendingMachine;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Product product  = (Product) obj;
        return (this.getId() == product.getId());
    }
}
