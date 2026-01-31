//Tienda de ropa; productos disponibles, posibilidad agregar productos, ver el inventario y eliminar productos. 

import java.util.Scanner;


public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Almacen miAlmacen = new Almacen("boutique.txt");
        int op = 0;

        while(op != 4) {
            System.out.println("\n--- BOUTIQUE ---");
            System.out.println("1. Agregar | 2. Ver | 3. Eliminar | 4. Salir");

            op = sc.nextInt();
            sc.nextLine(); //Limpieza de Buffer

            switch(op){
                case 1: {
                    System.out.print("Introduce el código: "); int c = sc.nextInt(); sc.nextLine();
                    System.out.print("Introduce el tipo: "); String t = sc.nextLine();
                    System.out.print("Introduce el precio: "); double p = sc.nextDouble();
                    System.out.print("Introduce las unidades: "); int u = sc.nextInt();

                    Producto nuevo = new Producto(c,t,p,u); //Se crea el objeto

                    miAlmacen.add_product(nuevo); //se añade
                    break;
                }
                case 2: {
                    miAlmacen.display_product();
                    break;
                }
                case 3: {
                    System.out.print("Código a borrar: ");
                    String cod = sc.nextLine();

                    miAlmacen.remove_product(cod);
                    break;
                }
                case 4:
                    System.out.println("Saliendo...");
                    sc.close();
                    break;
            }
            
        }
    }
}
