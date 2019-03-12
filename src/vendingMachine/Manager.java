package vendingMachine;

import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private static HashMap<Integer, Product> products;
    private static HashMap<Integer, VendingMachine> machines;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        products = new HashMap<>();
        machines = new HashMap<>();

        fillProducts();
        runMachines();
        doBuys();
        printBills();
    }

    private static void fillProducts() {
        int n = scanner.nextInt();
        Product product;
        for (int i = 1; i <= n; i++) {
            product = new Product(scanner.nextInt(), scanner.next(), scanner.nextInt());
            products.put(product.getId(), product);
        }
    }

    private static void runMachines() {
        int m, n = scanner.nextInt();
        VendingMachine machine;
        for (int i = 1; i <= n; i++) {
            machine = new VendingMachine(i);
            m = scanner.nextInt();
            for (int j = 1; j <= m; j++)
                machine.addProduct(products.get(scanner.nextInt()), 1);
            machines.put(i, machine);
        }
    }

    private static void doBuys() {
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            machines.get(scanner.nextInt()).buy(products.get(scanner.nextInt()));
    }

    private static void printBills() {
        for (int i = 1; i <= machines.size(); i++)
            System.out.println(machines.get(i).bill());
    }
}
