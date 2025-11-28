package model;

public class CottonTrouser extends Cloth{

    public CottonTrouser(String id, String name,int quantity,double price,String color,String size){
        super(id,name,quantity,price,color,size);
    }

    @Override
    public String getCategory() {
        return "CottonTrouser";
    }
    @Override
    public String toString(){
        return super.toString();
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
                "",
                "CottonTrouser"
        );
    }
    private static String nullSafe(String s) { return s == null ? "" : s; }


}
