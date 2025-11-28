package model;

public class Denim extends Cloth{
    private String fit;

    public Denim(String id, String name,int quantity,double price,String color,String size,String fit){
        super(id,name,quantity,price,color,size);
        this.fit = fit;
    }

    public String getFit(){
        return fit;
    }

    @Override
    public String getCategory(){
        return "Denim";
    }
    @Override
    public String toString(){
        return super.toString()+"\n"+fit ;
    }

}
