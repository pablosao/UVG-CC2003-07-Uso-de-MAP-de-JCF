
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
        
        //Variables para el manejo dentro del sistema
        int opcion_map = 0, opcion_menu;
        String path_file = "";
        
        //Mapa de cartas
        Map cartas = null;
        
        //Mapa de las cartas del usuario
        Map cartas_usuario = null;
        
        
        boolean control_menu = true;
        
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
                                //cartas.forEach((key, value) -> System.out.println(key + ": " + value));
                                System.out.println(cartas);
                            }
                            else{
                                System.out.println("\n\tEl archivo no se encontro en la ruta ingresada");
                            }

                    }
                    
                    
//                    int opcion;
//                    
//                    while(control_menu){
//                        
//                        // Desplegando menú de opciones
//                        System.out.println("1)Agregar una carta a colección.");
//                        System.out.println("2)Mostrar carta especifica.");
//                        System.out.println("3)Mostrar cartas de la colección.");
//                        System.out.println("4)Mostrar carta de colección ordenada por tipo.");
//                        System.out.println("5)Mostrar nombre y tipo de cartas existentes.");
//                        System.out.println("6)Mostrar nombre y tipo de cartas existentes ordenada por tipo.");
//                        System.out.println("7)Cambiar Implementación de MAP.");
//                        System.out.println("8)Salir del programa.");
//
//                        System.out.print("\nIngrese el número de la opción deseada: ");
//                        opcion = Keyboard.readInt();                       
//                        
//                        if(opcion == 8){
//                            System.exit(0);
//                        }
//                        else if(opcion == 7){
//                            control_menu = false;
//                        }
//                        else if(0 < opcion && opcion < 6){
//                            
//                            switch(opcion){
//                                case 3:
//                                    if(cartas_usuario.size() == 0){
//                                        System.out.println("\nNo ha agregado cartas");
//                                    }
//                                    else{
//                                        cartas_usuario.forEach((key, value) -> System.out.println(key + ": " + value));
//                                    }                                    
//                            }
//                        }
//                        
//                        
//                    }
                    
//                    

                    
                    
                }
            }
        }
    }
    
    
    private static Map<String,String> loadCards(String path){
        Map<String,String> maps = null;
        String[] separacion = null;
        String[] lectura;
        String temp = "",key="",value="";
        
        lectura = (new FileManager(path)).getDataFile().split(DELIMITADOR);
        
        for(int control = 0; control < lectura.length;control++){
            
            if(lectura[control].contains(DELIMITADOR_KEY)){
                               
                temp = lectura[control];
                System.out.println(temp);
                
                separacion = temp.split(Pattern.quote(DELIMITADOR_KEY));
                
                if(separacion.length == 2){
                    System.out.println(separacion[0] + " <> " + separacion[1]);
                    key = separacion[0].toString();
                    value = separacion[1].toString();
                    maps.put(key,value);
                }
                
//                
            }
        }
         
        return maps;
    }
}
