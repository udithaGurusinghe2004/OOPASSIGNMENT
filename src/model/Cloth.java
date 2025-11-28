package model;

public abstract class Cloth {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String color;
    private String size;

    Cloth(String id, String name,int quantity,double price,String color,String size){
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
}
