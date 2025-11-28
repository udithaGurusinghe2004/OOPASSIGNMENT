
import model.Denim; // import your class
// import model.Cloth;  // only if you want to reference it polymorphically

public class Main {
    public static void main(String[] args) {
        Denim d = new Denim("D-001", "Blue Denim", 10, 4500.0, "Blue", "M", "SLIM");
        System.out.println(d.getCategory()); // prints: Denim
        System.out.println(d.toString());               // uses your Cloth.toString() + fit
    }
}