public class Producto {
     //Atributos


    private int code;
    private String type;
    private double price;
    private int unit;

    //Constructor: new Producto(...)

    public Producto(int code, String type, double price, int unit){
        this.code = code; //This.(...) el hueco de la clase 
        this.type = type; //(...) el dato que te pasan (Guarda el dato que me das en mi hueco interno)
        this.price = price;
        this.unit = unit;
    }
    
    //Método


    public String toFileString(){
        return code + ", " + type + ", " + price + ", " + unit;
    }

    //Getters
    //Como son private, se necesitan funciones para verlos desde fuera.
    public int getCode(){
        return code;
    }
    
    
}
