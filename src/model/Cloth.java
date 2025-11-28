package model;

public abstract class Cloth {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String color;
    private String size;

    protected Cloth(String id, String name,int quantity,double price,String color,String size){
        this.id = id;
        this.name=name;
        this.quantity= quantity;
        this.price= price;
        this.color= color;
        this.size= size;
    }
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
    public String getSize(){
        return size;
    }

    public String toString(){
        return id+"\n"+name+"\n"+quantity+"\n"+price+"\n"+color+"\n"+size;
    }
    public abstract String getCategory();

    /** Serialize to CSV (include category so we can reconstruct the subclass later). */
    public String toCsv() {
        // Order: id,name,quantity,price,color,size,category
        return String.join(",",
                nullSafe(id),
                nullSafe(name),
                String.valueOf(quantity),
                String.valueOf(price),
                nullSafe(color),
                nullSafe(size),
                nullSafe(getCategory())
        );
    }
    private static String nullSafe(String s) {
        return s == null ? "" : s;
    }
}
