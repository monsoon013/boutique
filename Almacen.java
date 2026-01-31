import java.io.*;


public class Almacen {
    
    private String nombreFichero;

    public Almacen (String nombreFichero){
        this.nombreFichero = nombreFichero;
    }

    //Métodos

    //void - no devuelve nada, solo imprime el resultado

    //public int, String, una clase (Producto) - return (...) Devuelve algo.

    public void add_product(Producto x){ 
        //Try-with-resources; Intenta abrir el archivo. Pase lo que pase, ciérralo tú solo al acabar
        try (BufferedWriter bw = new BufferedWriter (new FileWriter(nombreFichero, true))){ //True para que no obrre lo anterior, sino que hace un append
            bw.write(x.toFileString());
            bw.newLine(); // para que haga /n por cada producto
            System.out.println("Producto guardado");
        } catch (IOException e){ //Si no existe
            System.out.println("Error al guardar");
        }

    }

    public void display_product(){
        try(BufferedReader br = new BufferedReader(new FileReader(nombreFichero))){
            String linea;
            boolean vacio = true; //Se asume que está vacío

            //Realizar un bucle while para que muestre todas las líneas mientras existan
            //br.readLine() lee una línea y la guarda en la variable línea
            //Si devuelve null, se acabó el archivo
            while((linea = br.readLine()) != null){
                //Si la línea no son solo espacios en blanco
                if(!linea.trim().isEmpty()){
                    System.out.println(linea);
                    vacio = false;
                } 
            }

            if(vacio) System.out.println("Inventario vacío");
        } catch (IOException e){
            System.out.println("Erro al leer el archivo.");
        }
    }


    //No se puede borrar un archivo. ENtonces se copia y se crea uno nuevo sin el producto borrado
    public void remove_product(String codigo){
        File original = new File(nombreFichero);
        File aux = new File("auxiliar.txt");

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(original));
             BufferedWriter bw = new BufferedWriter(new FileWriter(aux))){
                String linea;
                while((linea = br.readLine()) != null){
                    if(linea.trim().isEmpty()) continue; //Si es una línea vacía pasamos de ella

                    //Split para transformar en array y obtener el primer elemento
                    //Siendo este el código del producto

                    String[] datos = linea.split(", ");

                    if(datos[0].equals(codigo)){
                        found = true; //no lo escribo en el nuevo, porque así se borra
                    } else {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
             }catch (IOException e){
                System.out.println("Error al borrar");
             }

             if(found){
                original.delete();
                aux.renameTo(original); //Cambiar el nombre del archivo
                System.out.println("Producto eliminado");
             }else {
                aux.delete(); //Si no se encuentra, borra el auxiliar
                System.out.println("No se encontró el código");
             }
    }





}
