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

}
