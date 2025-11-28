
import model.Denim;
import service.StockManager;
import service.CsvStorage;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();

        // 1. Add items
        manager.add(new Denim("D-001", "Blue Denim", 10, 4500.0, "Blue", "M", "SLIM"));

        // 2. Save to CSV
        String path = "inventory.csv";
        boolean saved = CsvStorage.save(path, manager.listAll());
        System.out.println("Saved CSV: " + saved);

        // ✅ 3. Clear current inventory
        manager.clear();

        // ✅ 4. Reload from CSV
        CsvStorage.load(path).forEach(manager::add);

        // 5. Print to verify reload worked
        manager.printAll();
    }
}
