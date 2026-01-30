public class Producto {
     //Atributos
    protected int code;
    protected String type;
    protected double price;
    protected int unit;
    
    //Setters
    public void set_code(int code){
        this.code = code;
    }
    public void set_type(String type){
        this.type = type;
    }
    public void set_price(double price){
        this.price = price;
    }
    public void set_unit(int unit){
        this.unit = unit;
    }
    
    //Getters
    public int get_code(){
        return code;
    }
    public String get_type(){
        return type;
    }
    public double get_price(){
        return price;
    }
    public int get_unit(){
        return unit;
    }
    
    
}
