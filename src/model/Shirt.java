package model;

public class Shirt extends Cloth{

    public String sleeveType;

    public Shirt (String id, String name,int quantity,double price,String color,String size,String sleeveType){
        super(id,name,quantity,price,color,size);
        this.sleeveType = sleeveType;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+sleeveType;
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
                "Shirt"
        // category (also fix getCategory to return "Shirt")
                );
    }
    private static String nullSafe(String s) {
        return s == null ? "" : s;
    }
    @Override
    public String getCategory() {
        return "Shirt";
    } // fix typo from "Shrit"
}
