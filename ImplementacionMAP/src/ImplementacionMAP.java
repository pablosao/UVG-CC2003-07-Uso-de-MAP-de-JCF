
/**
 * 
 * @author Pablo Sao
 * @version 01/03/2019
 */

public class ImplementacionMAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        boolean control_global = true;
        int opcion_map = 0, opcion_menu;
        String path_file = "";
        
        while(control_global){
            
            while(opcion_map != 4){
                //Desplegando primer menú 
                System.out.println("1)HashMAPn\2)TreeMAP\n3)LinkedHashMAP\n4)Salir");

                System.out.print("Ingrese el número de la opción: ");
                opcion_map = Keyboard.readInt();
                
                if(opcion_map == 4){
                    
                    control_global = false;
                
                }
                else if(0 < opcion_map && opcion_map < 4){
                    
                    // Implementando MAP según la selección del usuario
                    
                    
                    /*
                    Agregar repetición de menu
                    */
                    
                    // Solicitando la selección del path del archivo
                    System.out.print("Ingrese el path del archivo de cartas: ");
                    path_file = Keyboard.readString();
                    
                    // Desplegando menú de opciones
                    System.out.println("1)Agregar una carta a colección.");
                    System.out.println("2)Mostrar carta especifica.");
                    System.out.println("3)Mostrar cartas de colección.");
                    System.out.println("4)Mostrar carta de colección ordenada por tipo.");
                    System.out.println("5)Mostrar nombre y tipo de cartas existentes.");
                    System.out.println("6)Mostrar nombre y tipo de cartas existentes ordenada por tipo.");
                    System.out.println("7)Cambiar Implementación de MAP.");
                    System.out.println("8)Salir del programa.");
                    
                    System.out.print("Ingrese el número de la opción deseada: ");
                    opcion_menu = Keyboard.readInt();
                    
                    
                }
            }
        }
    }
}
