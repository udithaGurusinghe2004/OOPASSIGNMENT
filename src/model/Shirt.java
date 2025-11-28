package model;

public class Shirt extends Cloth{

    public String sleeveType;

    public Shirt (String id, String name,int quantity,double price,String color,String size,String sleeveType){
        super(id,name,quantity,price,color,size);
        this.sleeveType = sleeveType;
    }
    @Override
    public String getCategory() {
        return "Shrit";
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+sleeveType;
    }
}
