package service;

import model.Cloth;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockManager {

    // In-memory store: key = id, value = the Cloth object (Denim/Shirt/TShirt)
    private final Map<String, Cloth> items = new HashMap<>();

    /**
     * Add a new item to stock.
     * @return true if added, false if item is null, id invalid, or id already exists.
     */
    public boolean add(Cloth item) {
        if (item == null) return false;

        String id = item.getId();
        if (id == null || id.isEmpty()) return false;

        if (items.containsKey(id)) return false; // Prevent duplicate IDs
        items.put(id, item);
        return true;
    }

    /**
     * Remove an item by id.
     * @return true if removed, false if id invalid or not found.
     */
    public boolean remove(String id) {
        if (id == null || id.isEmpty()) return false;
        return items.remove(id) != null;
    }

    /**
     * Lookup helper (optional, useful for tests).
     */
    public Cloth findById(String id) {
        if (id == null || id.isEmpty()) return null;
        return items.get(id);
    }

    /**
     * Read-only view of all items (optional).
     */
    public Collection<Cloth> listAll() {
        return Collections.unmodifiableCollection(items.values());
    }

    /**
     * Quick printer for debugging (optional).
     * Uses polymorphism: getCategory() comes from subclass; toString() prints your lines.
     */
    public void printAll() {
        for (Cloth item : items.values()) {
            System.out.println(item.getCategory());
            System.out.println(item);
            System.out.println("-----");
        }
    }
}
