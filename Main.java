//Tienda de ropa; productos disponibles, posibilidad agregar productos, ver el inventario y eliminar productos. 

import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main (String[] args) {
        String fich_1 = "boutique.txt";
        Scanner s = new Scanner(System.in);
        boolean content = true;
        int op = 0;
        stock sto = new stock();
        String remove_code;
        while(op != 4){
            System.out.println("   ***Boutique***   ");
            System.out.println("1.Agregar productos " + 
                               "\n2.Ver inventario" + 
                               "\n3.Eliminar productos" + 
                               "\n4.Salir");
            System.out.println("\t¿Qué deseas hacer?");
            op = s.nextInt(); s.nextLine();
            switch(op){
                case 1:
                    sto.add_stock();
                    sto.save_stock(fich_1, p);
                    break;
                case 2:
                    sto.display_stock(fich_1);
                    break;
                case 3:
                    System.out.println("Introduce el código del producto para eliminarlo:");
                    remove_code = s.nextLine();
                    sto.remove_stock(fich_1, remove_code);
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
            }
        }
        s.close();
    }
}
