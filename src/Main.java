
import model.Denim;
// import model.Shirt;
// import model.TShirt;
import service.StockManager;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();

        // Use your public constructors; test with Denim first if others aren’t done yet.
        Denim denim = new Denim("D-001", "Blue Denim", 10, 4500.0, "Blue", "M", "SLIM");

        // Add
        System.out.println("Add denim: " + manager.add(denim));        // true
        System.out.println("Add duplicate: " + manager.add(denim));     // false (same id)

        // Find
        System.out.println("Find D-001: " + manager.findById("D-001")); // prints your toString()

        // List/Print
        manager.printAll();

        // Remove
        System.out.println("Remove D-001: " + manager.remove("D-001")); // true
        System.out.println("Remove D-001 again: " + manager.remove("D-001")); // false

        // Verify empty
        manager.printAll();
    }
}
