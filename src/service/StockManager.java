package service;

import model.Cloth;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockManager {

    // In-memory store: key = id, value = the Cloth object (Denim/Shirt/TShirt)
    private final Map<String, Cloth> items = new HashMap<>();

    // Add a new item to stock.
    public boolean add(Cloth item) {
        if (item == null) return false;
        String id = item.getId();
        if (id == null || id.isEmpty())
            return false;
        if (items.containsKey(id))
            return false;
        items.put(id, item);
        return true;
    }


    // Remove an item by id.
    public boolean remove(String id) {
        if (id == null || id.isEmpty()) return false;
        return items.remove(id) != null;
    }

    // Lookup helper (for tests)
    public Cloth findById(String id) {
        if (id == null || id.isEmpty()) return null;
        return items.get(id);
    }
    public void clear() {
        items.clear();
    }

    //Read-only view of all items
    public Collection<Cloth> listAll() {
        return Collections.unmodifiableCollection(items.values());
    }

    // Quick printer for debugging
    public void printAll() {
        for (Cloth item : items.values()) {
            System.out.println(item.getCategory());
            System.out.println(item);
            System.out.println("-----");
        }
    }

    // Update quantity to an exact value
    public boolean updateQuantity(String id, int newQty) {
        Cloth c = findById(id);
        if (c == null) return false;
        if (newQty < 0) return false; // prevent negative stock
        c.setQuantity(newQty);
        return true;
    }

    // Adjust stock
    public boolean increaseStock(String id, int delta) {
        if (delta <= 0) return false;
        Cloth c = findById(id);
        if (c == null) return false;
        c.setQuantity(c.getQuantity() + delta);
        return true;
    }

    public boolean decreaseStock(String id, int delta) {
        if (delta <= 0) return false;
        Cloth c = findById(id);
        if (c == null) return false;
        int newQty = c.getQuantity() - delta;
        if (newQty < 0) return false;
        c.setQuantity(newQty);
        return true;
    }

    // Update price
    public boolean updatePrice(String id, double newPrice) {
        Cloth c = findById(id);
        if (c == null) return false;
        if (newPrice < 0) return false; // prevent negative price
        c.setPrice(newPrice);
        return true;
    }

}
