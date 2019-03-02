
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * 
 * @author Pablo Sao
 * @version 01/03/2019
 */

public class ImplementacionMAP {
    
    
    final static String DELIMITADOR = "\n";
    final static String DELIMITADOR_KEY = "|";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int opcion_map = 0, opcion_menu;
        String path_file = "";
        Map cartas = null;
        
        while(true){
            
            while(opcion_map != 4){
                //Desplegando primer menú 
                System.out.println("\n1)HashMAP\n2)TreeMAP\n3)LinkedHashMAP\n4)Salir");

                System.out.print("\nIngrese el número de la opción: ");
                opcion_map = Keyboard.readInt();
                
                if(opcion_map == 4){
                    
                    System.exit(0);
                }
                else if(0 < opcion_map && opcion_map < 4){
                    
                    // Solicitando la selección del path del archivo
                    System.out.print("Ingrese el path del archivo de cartas: ");
                    path_file = Keyboard.readString();
                    
                    
                    // Implementando MAP según la selección del usuario
                    switch(opcion_map){
                        case 1:
                            //Opcion para implementar HashMap
                            cartas = (new FactoryMaps()).MAPS("HM");
                            
                        case 2:
                            //Opcion para implementar TreeMap
                            cartas = (new FactoryMaps()).MAPS("TM");
                            
                        case 3:
                            //Opcion para implementar LinkedHashMap
                            cartas = (new FactoryMaps()).MAPS("LH");
                            
                        default:
                            //Cargando datos de las cartas guardadas en el archivo
                            
                            if((new FileManager(path_file)).getExists() && cartas != null){
                                cartas = loadCards(path_file);
                                System.out.println(cartas);
                            }
                            else{
                                System.out.println("\n\tEl archivo no se encontro en la ruta ingresada");
                            }
                            
                            
                        
                    }
                    
                    /*
                    Agregar repetición de menu
                    */
                    
                    
//                    
//                    // Desplegando menú de opciones
//                    System.out.println("1)Agregar una carta a colección.");
//                    System.out.println("2)Mostrar carta especifica.");
//                    System.out.println("3)Mostrar cartas de colección.");
//                    System.out.println("4)Mostrar carta de colección ordenada por tipo.");
//                    System.out.println("5)Mostrar nombre y tipo de cartas existentes.");
//                    System.out.println("6)Mostrar nombre y tipo de cartas existentes ordenada por tipo.");
//                    System.out.println("7)Cambiar Implementación de MAP.");
//                    System.out.println("8)Salir del programa.");
//                    
//                    System.out.print("Ingrese el número de la opción deseada: ");
//                    opcion_menu = Keyboard.readInt();
                    
                    
                }
            }
        }
    }
    
    
    private static Map loadCards(String path){
        Map maps = null;
        String[] separacion = null;
        String[] lectura;
        
        lectura = (new FileManager(path)).getDataFile().split(DELIMITADOR);
        
        for(int control = 0; control < lectura.length;control++){
            
            if(lectura[control].contains(DELIMITADOR_KEY)){
                               
                separacion = (lectura[control].toString()).split(Pattern.quote(DELIMITADOR_KEY));
                
                maps.put(separacion[0],separacion[1]);
            }
        }
         
        return maps;
    }
}
