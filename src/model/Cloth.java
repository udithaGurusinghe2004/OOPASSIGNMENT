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

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(double price) { this.price = price; }

    public void setColor(String color) { this.color = color; }

    public void setSize(String size) { this.size = size; }

    public void setName(String name) { this.name = name; }


    public String toString(){
        return"ID: "+id+"\nNAME: "+name+"\nQuantity: "+quantity+"\nPrice: "+price+"\nColour: "+color+"\nSize: "+size+"\n";
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
