package model;

public class ClothFactory {

    public static Cloth fromCsvRow(String[] cols) {
        if (cols == null || cols.length < 8) return null;

        String id       = cols[0];
        String name     = cols[1];
        int quantity    = parseInt(cols[2], 0);
        double price    = parseDouble(cols[3], 0.0);
        String color    = cols[4];
        String size     = cols[5];
        String extra    = cols[6]; // subtype-specific
        String category = cols[7];

        if (category == null) return null;

        switch (category) {
            case "Denim":
                // extra = fit
                return new Denim(id, name, quantity, price, color, size, extra);
            case "Shirt":
                // extra = sleeveType
                return new Shirt(id, name, quantity, price, color, size, extra);
            case "Tshirt":
                // extra = sleeveType
                return new Tshirt(id, name, quantity, price, color, size, extra);
            case "CottonTrouser":
                // extra unused
                return new CottonTrouser(id, name, quantity, price, color, size);
            default:
                // Unknown category
                return null;
        }
    }

    private static int parseInt(String s, int def) {
        try { return Integer.parseInt(s);
        } catch (Exception e) {
            return def;
        }
    }
    private static double parseDouble(String s, double def) {
        try { return Double.parseDouble(s);
        } catch (Exception e) {
            return def;
        }
    }
}

