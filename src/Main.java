
import model.*;
import service.StockManager;
import service.CsvStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        String path = "inventory.csv";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1) Add Denim");
            System.out.println("2) Add Shirt");
            System.out.println("3) Add Tshirt");
            System.out.println("4) Add CottonTrouser");
            System.out.println("5) Update Quantity");
            System.out.println("6) Update Price");
            System.out.println("7) Increase Stock");
            System.out.println("8) Decrease Stock");
            System.out.println("9) Remove Item");
            System.out.println("10) Print All");
            System.out.println("11) Save CSV");
            System.out.println("12) Load CSV");
            System.out.println("0) Exit");
            System.out.print("Select: ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1": {
                        String id = prompt(sc, "ID");
                        String name = prompt(sc, "Name");
                        int qty = promptInt(sc, "Quantity");
                        double price = promptDouble(sc, "Price");
                        String color = prompt(sc, "Color");
                        String size = prompt(sc, "Size");
                        String fit = prompt(sc, "Fit (e.g., SLIM/REGULAR)");
                        boolean ok = manager.add(new Denim(id, name, qty, price, color, size, fit));
                        System.out.println("Added Denim: " + ok);
                        break;
                    }
                    case "2": {
                        String id = prompt(sc, "ID");
                        String name = prompt(sc, "Name");
                        int qty = promptInt(sc, "Quantity");
                        double price = promptDouble(sc, "Price");
                        String color = prompt(sc, "Color");
                        String size = prompt(sc, "Size");
                        String sleeve = prompt(sc, "Sleeve Type (Short/Long)");
                        boolean ok = manager.add(new Shirt(id, name, qty, price, color, size, sleeve));
                        System.out.println("Added Shirt: " + ok);
                        break;
                    }
                    case "3": {
                        String id = prompt(sc, "ID");
                        String name = prompt(sc, "Name");
                        int qty = promptInt(sc, "Quantity");
                        double price = promptDouble(sc, "Price");
                        String color = prompt(sc, "Color");
                        String size = prompt(sc, "Size");
                        String sleeve = prompt(sc, "Sleeve Type (Short/Long)");
                        boolean ok = manager.add(new Tshirt(id, name, qty, price, color, size, sleeve));
                        System.out.println("Added Tshirt: " + ok);
                        break;
                    }
                    case "4": {
                        String id = prompt(sc, "ID");
                        String name = prompt(sc, "Name");
                        int qty = promptInt(sc, "Quantity");
                        double price = promptDouble(sc, "Price");
                        String color = prompt(sc, "Color");
                        String size = prompt(sc, "Size");
                        boolean ok = manager.add(new CottonTrouser(id, name, qty, price, color, size));
                        System.out.println("Added CottonTrouser: " + ok);
                        break;
                    }
                    case "5": {
                        String id = prompt(sc, "ID");
                        int newQty = promptInt(sc, "New Quantity");
                        System.out.println("Updated qty: " + manager.updateQuantity(id, newQty));
                        break;
                    }
                    case "6": {
                        String id = prompt(sc, "ID");
                        double newPrice = promptDouble(sc, "New Price");
                        System.out.println("Updated price: " + manager.updatePrice(id, newPrice));
                        break;
                    }
                    case "7": {
                        String id = prompt(sc, "ID");
                        int delta = promptInt(sc, "Increase by");
                        System.out.println("Increase: " + manager.increaseStock(id, delta));
                        break;
                    }
                    case "8": {
                        String id = prompt(sc, "ID");
                        int delta = promptInt(sc, "Decrease by");
                        System.out.println("Decrease: " + manager.decreaseStock(id, delta));
                        break;
                    }
                    case "9": {
                        String id = prompt(sc, "ID");
                        System.out.println("Removed: " + manager.remove(id));
                        break;
                    }
                    case "10": {
                        manager.printAll();
                        break;
                    }
                    case "11": {
                        boolean ok = CsvStorage.save(path, manager.listAll());
                        System.out.println("Saved to " + path + ": " + ok);
                        break;
                    }
                    case "12": {
                        manager.clear();
                        CsvStorage.load(path).forEach(manager::add);
                        System.out.println("Loaded from " + path);
                        break;
                    }
                    case "0":
                        System.out.println("Bye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                // continue loop
            }
        }
    }

    // ---- Small helpers to read safely ----
    private static String prompt(Scanner sc, String label) {
        System.out.print(label + ": ");
        return sc.nextLine().trim();
    }
    private static int promptInt(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    private static double promptDouble(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String s = sc.nextLine().trim();
            try { return Double.parseDouble(s); } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}


