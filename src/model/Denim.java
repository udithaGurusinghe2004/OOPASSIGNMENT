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

        return super.toString()+"Fit/Regular: "+fit+"\n";
    }
    @Override
    public String toCsv() {
        // For Denim, include 'fit' before 'category'
        return String.join(",",
                nullSafe(getId()),
                nullSafe(getName()),
                String.valueOf(getQuantity()),
                String.valueOf(getPrice()),
                nullSafe(getColor()),
                nullSafe(getSize()),
                nullSafe(getFit()),
                nullSafe(getCategory())
        );
    }
    private static String nullSafe(String s) {
        return s == null ? "" : s;
    }
}

