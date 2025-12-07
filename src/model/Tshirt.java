package model;

public class Tshirt extends Cloth{
    public String sleeveType;

    public Tshirt(String id, String name,int quantity,double price,String color,String size,String sleeveType){
        super(id,name,quantity,price,color,size);
        this.sleeveType = sleeveType;
    }
    @Override
    public String getCategory() {
        return "Tshirt";
    }
    @Override
    public String toString() {
        return super.toString()+"Sleeve type: "+sleeveType+"\n";
    }

    @Override
    public String toCsv() {
        return String.join(",",
                nullSafe(getId()),
                nullSafe(getName()),
                String.valueOf(getQuantity()),
                String.valueOf(getPrice()),
                nullSafe(getColor()),
                nullSafe(getSize()),
                nullSafe(sleeveType),
                "Tshirt"
                );
    }
    private static String nullSafe(String s) {
        return s == null ? "" : s;
    }

}
