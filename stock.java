import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class stock {
    public static void add_stock(){
        Scanner s = new Scanner(System.in);
        stock producto = new stock();
        int code, unit;
        double price;
        String type;
        System.out.println("Introduce el código del producto: ");
        code = s.nextInt(); s.nextLine();
        producto.set_code(code);
        System.out.println("Introduce el tipo del producto: ");
        type = s.nextLine();
        producto.set_type(type);
        System.out.println("Introduce el precio del producto: ");
        price = s.nextDouble();
        producto.set_price(price);
        System.out.println("Introduce las unidades del producto: ");
        unit = s.nextInt(); s.nextLine();
        producto.set_unit(unit);
        return producto;
        s.close();
    }

    public static void save_stock(String fich_1, stock p){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fich_1, true));
            bw.write(p.code + ", " + p.type + ", " + p.price + "€, " + p.unit + "\n");
            bw.newLine();
            System.out.println("Producto agregado correctamente.");
            bw.close();
        }
        catch (IOException duende_del_Stock){
            System.out.println("Error al guardar el producto");
            duende_del_Stock.printStackTrace();
        }
    }
    
    public void display_stock(String fich_1){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fich_1));
            String line;
            boolean empty = true;
            while((line = br.readLine()) != null){
                System.out.println("--------------------------\n");
                System.out.println(line);
                empty = false;
            }
            if(empty){
                System.out.println("El inventario está vacío");
            }
        System.out.println("--------------------------\n");
        br.close();
        }
        catch (IOException duende_del_display){
            System.out.println("Hubo un error de lectura en el fichero boutique.txt");
            duende_del_display.printStackTrace();
        }
    }
    public static void remove_stock(String fich_1, String remove_code){
        File arch_original = new File(fich_1);
        File arch_AUX = new File("aux.txt");
        boolean found = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(arch_original));
            BufferedWriter bw = new BufferedWriter(new FileWriter(arch_AUX));
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(", ");
                String code = data[0];
                if(!code.equals(remove_code)){
                    bw.write(line);
                    bw.newLine();
                }
                else{
                    found = true;
                }
            }
            bw.close();
            br.close();
        }
        catch (IOException duende_del_remove){
            System.out.println("Error de borrado en el fichero boutique.txt");
            duende_del_remove.printStackTrace();
        }
        if (found){
            if(arch_original.delete()){
                if (arch_AUX.renameTo(arch_original)){
                    System.out.println("Código " + remove_code + " eliminado correctamente.");
                }
                else {
                    System.out.println("Error al renombrar el archivo.");
                }
            }
            else{
                System.out.println("Imposible eliminar el archivo original.");
            }
        }
        else{
            System.out.println("Código " + remove_code + " no encontrado.");
            arch_AUX.delete();
        }
    }
    
}
