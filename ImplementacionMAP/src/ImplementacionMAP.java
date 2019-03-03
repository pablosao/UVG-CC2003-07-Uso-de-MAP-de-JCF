
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        int opcion_map = 0;
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
                            cartas_usuario = (new FactoryMaps()).MAPS("HM");
                            
                        case 2:
                            //Opcion para implementar TreeMap
                            cartas = (new FactoryMaps()).MAPS("TM");
                            cartas_usuario = (new FactoryMaps()).MAPS("TM");
                            
                        case 3:
                            //Opcion para implementar LinkedHashMap
                            cartas = (new FactoryMaps()).MAPS("LH");
                            cartas_usuario = (new FactoryMaps()).MAPS("LH");
                            
                        default:
                            //Cargando datos de las cartas guardadas en el archivo
                            
                            if((new FileManager(path_file)).getExists() && cartas != null){
                                
                                cartas = loadCards(cartas,path_file);
                                
                                System.out.println("\n\n\tSe ha cargado con éxito el listado de cartas\n");
                            }
                            else{
                                System.out.println("\n\tEl archivo no se encontro en la ruta ingresada");
                            }

                    }
                    
                    
                    int opcion;
                    
                    while(control_menu){
                        
                        // Desplegando menú de opciones
                        System.out.println("\n1)Agregar una carta a colección.");
                        System.out.println("2)Mostrar carta especifica.");
                        System.out.println("3)Mostrar cartas de la colección.");
                        System.out.println("4)Mostrar carta de colección ordenada por tipo.");
                        System.out.println("5)Mostrar nombre y tipo de cartas existentes.");
                        System.out.println("6)Mostrar nombre y tipo de cartas existentes ordenada por tipo.");
                        System.out.println("7)Cambiar Implementación de MAP.");
                        System.out.println("8)Salir del programa.");

                        System.out.print("\nIngrese el número de la opción deseada: ");
                        opcion = Keyboard.readInt();                       
                        
                        //Se termina la ejecución del programa
                        if(opcion == 8){
                            System.exit(0);
                        }
                        // Regresamos a la opción para que seleccione la implementación que desea
                        else if(opcion == 7){
                            control_menu = false;
                        }
                        else if(0 < opcion && opcion < 7){
                            
                            //Agregando una carta a la colección
                            if(opcion == 1){
                                System.out.print("\n\nIngrese el nombre de la carta a agregar: ");
                                String nueva_carta = Keyboard.readString();
                                    
                                if(!cartas_usuario.containsKey(nueva_carta.toUpperCase())){
                                    cartas_usuario.put(nueva_carta, cartas.get(nueva_carta.toUpperCase()));
                                    System.out.println("\n\t\tCarta agregada de forma satisfactoria.");
                                }
                                else{
                                    System.out.println("\n\tLa carta ya se encuentra en su colección.");
                                }
                            }
                            //mostrando datos de una carta en especifico dentro de la colección
                            else if(opcion == 2){
                                if(cartas_usuario.size() == 0){
                                    System.out.println("\n\t\tNo ha agregado cartas");
                                }
                                else{
                                    
                                    System.out.print("\n\nIngrese el nombre de la carta: ");
                                    String tempCard = Keyboard.readString();
                                    
                                    if(cartas_usuario.containsKey(tempCard.toUpperCase())){
                                        
                                        System.out.println("\n\t-------------------------------------------------\n");
                                        System.out.println("\tInformación de Carta");
                                        System.out.println("\t-------------------------------------------------\n");
                                        System.out.println("\t\tTipo: " + cartas_usuario.get(tempCard.toUpperCase()));
                                        System.out.println("\t\tCarta: " + tempCard);
                                        System.out.println("\t-------------------------------------------------\n");
                                        
                                    }
                                    else{
                                        System.out.println("\n\t\tLa carta ingresada no existe dentro de su colección");
                                    }
                                    
                                    
                                }
                            }
                            //Mostrando cartas de la colección
                            else if(opcion == 3){
                                if(cartas_usuario.size() == 0){
                                    System.out.println("\n\t\tNo ha agregado cartas");
                                }
                                else{
                                    System.out.println("\n\t-------------------------------------------------\n");
                                    System.out.println("\tCartas de la Colección");
                                    System.out.println("\t-------------------------------------------------\n");
                                    cartas_usuario.forEach((key, value) -> System.out.println("\t\t<> " + key ));
                                    System.out.println("\t-------------------------------------------------\n");
                                    
                                }
                            }
                            else if(opcion == 4){
                                
                            }
                            //Mostrando el tipo de carta y la carta dentro de la colección del usuario
                            else if(opcion == 5){
                                if(cartas_usuario.size() == 0){
                                    System.out.println("\n\t\tNo ha agregado cartas");
                                }
                                else{
                                    System.out.println("\n\t-------------------------------------------------\n");
                                    System.out.println("\tTipos de Cartas y Carta de la Colección\n");
                                    System.out.println("\t-------------------------------------------------\n");
                                    cartas_usuario.forEach((key, value) -> System.out.println("\t\t"+ value + " : " + key));
                                    System.out.println("\t-------------------------------------------------\n");
                                }
                            }
                            //Mostrando carta y tipo, ordenada por el tipo de carta
                            else if(opcion == 6){
                                if(cartas_usuario.size() == 0){
                                    System.out.println("\n\t\tNo ha agregado cartas");
                                }
                                else{
                                    System.out.println("\n\t-------------------------------------------------\n");
                                    System.out.println("\tTipos de Cartas y Carta de la Colección\n");
                                    System.out.println("\t-------------------------------------------------\n");
                                    
                                    Map<String,String> tempMap = ordenarPorValue(cartas_usuario);
                                    
                                    tempMap.forEach((key, value) -> System.out.println("\t\t"+ value + " : " + key));
                                    
//                                    cartas_usuario.entrySet()
//                                    .stream()
//                                    .sorted(Map.Entry.<String, String>comparingByValue())
//                                    .forEach(System.out::println);
                                    
                                    
                                    //cartas_usuario.forEach((key, value) -> System.out.println("\t\t"+ value + " : " + key));
                                    System.out.println("\t-------------------------------------------------\n");
                                }
                            }
                            
                        }
                        
                        
                    }
                    
                    //Regresando el estado a true para ingresar nuevamente al menú de operaciones de usuario
                    control_menu = true;

                }
            }
        }
    }
    
    /***
     * Metodo para retornar el maps lleno con la lista de las cartas
     * @param lista lista a implementar, seleccionada por el usuario
     * @param path path del archivo txt del listado de cartas
     * @return Map lleno con las cartas cargadas del txt
     */
    private static Map<String,String> loadCards(Map lista,String path){
        //pasando Map de la selección del usuario
        Map maps = lista;
        
        //Variables temporales para la separación del contenido del texto
        String[] separacion = null;
        String[] lectura;
        
        //Lectura del archivo con la separación de las cartas
        lectura = (new FileManager(path)).getDataFile().split(DELIMITADOR);
        
        for(int control = 0; control < lectura.length;control++){
            
            if(lectura[control].contains(DELIMITADOR_KEY)){
                
                //Separando el valor y la llave del string
                separacion = lectura[control].split(Pattern.quote(DELIMITADOR_KEY));
                //Guardando la información en el maps
                maps.put((String)separacion[0].toUpperCase(),(String)separacion[1]);
                
            }
        }
        return maps;
    }
    
    public static Map<String, String> ordenarPorKey(Map<String, String> mapa_ordenar) {
 
		Map<String, String> resultado = new LinkedHashMap<>();
		Stream<Map.Entry<String, String>> sequentialStream = mapa_ordenar.entrySet().stream();
 
		// comparingByKey() returns a comparator that compares Map.Entry in natural order on key.
		sequentialStream.sorted(Map.Entry.comparingByKey()).forEachOrdered(c -> resultado.put(c.getKey(), c.getValue()));
		return resultado;
    }
    
    public static Map<String, String> ordenarPorValue(Map<String, String> mapa_ordenar) {
 
		Map<String, String> resultado = new LinkedHashMap<>();
		Stream<Map.Entry<String, String>> sequentialStream = mapa_ordenar.entrySet().stream();
 
		// comparingByKey() returns a comparator that compares Map.Entry in natural order on key.
		sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> resultado.put(c.getKey(), c.getValue()));
		return resultado;
    }
    
}
