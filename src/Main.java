import model.*;
import service.StockManager;
import service.CsvStorage;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();

        // 1) Add one of each type
        manager.add(new Denim("D-001", "Blue Denim", 10, 4500.0, "Blue", "M", "SLIM"));
        manager.add(new Shirt("S-001", "Formal Shirt", 15, 3200.0, "White", "L", "Long"));
        manager.add(new Tshirt("T-001", "Graphic Tee", 25, 2200.0, "Black", "M", "Short"));
        manager.add(new CottonTrouser("C-001", "Cotton Pants", 12, 3800.0, "Khaki", "32"));

        // 2) Save to CSV
        String path = "inventory.csv";
        boolean saved = CsvStorage.save(path, manager.listAll());
        System.out.println("Saved CSV: " + saved);

        // 3) Clear current inventory
        manager.clear();

        // 4) Load back from CSV
        CsvStorage.load(path).forEach(manager::add);

        // 5) Print to verify everything reconstructed correctly
        manager.printAll();
    }
}

