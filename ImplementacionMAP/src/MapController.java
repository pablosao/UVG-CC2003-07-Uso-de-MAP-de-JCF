
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Clase para el manejo de Map
 * @author pablo
 * @version 03/03/2018
 */
public class MapController {
    /***
     * Ordenamiento de Map por Key
     * @param mapa_ordenar map que se desea ordenar
     * @return map ordenado
     */
    public Map<String, String> ordenarPorKey(Map<String, String> mapa_ordenar) {
        //Creando isntancia de Map
	Map<String, String> resultado = new LinkedHashMap<>();
	
        //Creando Stream con los valores que se desean ordenar
        Stream<Map.Entry<String, String>> sequentialStream = mapa_ordenar.entrySet().stream();
 
        //Ordenando map por Key y colocandolos de forma ordenada dentro del map creado al inicio
	sequentialStream.sorted(Map.Entry.comparingByKey()).forEachOrdered(c -> resultado.put(c.getKey(), c.getValue()));
	
        return resultado;
    }
    
    
    /***
     * Ordenamiento de Map por value
     * @param mapa_ordenar Map que se desea ordenar
     * @return Map ordenado
     */
    public Map<String, String> ordenarPorValue(Map<String, String> mapa_ordenar) {
        //Creando isntancia de Map
	Map<String, String> resultado = new LinkedHashMap<>();
                
        //Creando Stream con los valores que se desean ordenar
	Stream<Map.Entry<String, String>> sequentialStream = mapa_ordenar.entrySet().stream();
                
        //Ordenando map por Value y colocandolos de forma ordenada dentro del map creado al inicio
	sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> resultado.put(c.getKey(), c.getValue()));
	
        return resultado;
    }
    
    /***
     * Metodo para retornar el maps lleno con la lista de las cartas
     * @param lista lista a implementar, seleccionada por el usuario
     * @param path path del archivo txt del listado de cartas
     * @return Map lleno con las cartas cargadas del txt
     */
    public Map<String,String> loadCards(Map lista,String path,String delimitador,String delimitador_key){
        //pasando Map de la selección del usuario
        Map maps = lista;
        
        //Variables temporales para la separación del contenido del texto
        String[] separacion = null;
        String[] lectura;
        
        //Lectura del archivo con la separación de las cartas
        lectura = (new FileManager(path)).getDataFile().split(delimitador);
        
        for(int control = 0; control < lectura.length;control++){
            
            if(lectura[control].contains(delimitador_key)){
                
                //Separando el valor y la llave del string
                separacion = lectura[control].split(Pattern.quote(delimitador_key));
                
                //validacion para comprobar la complejidad de map
//                if(!separacion[1].equals("Trampa")){
//                    //Guardando la información en el maps
//                    maps.put((String)separacion[0].toUpperCase(),(String)separacion[1]);
//                }
                
                //Validando que solo se agregen los 3 tipos de cartas soportados
                if(separacion[1].equals("Trampa") ||
                        separacion[1].equals("Hechizo") ||
                        separacion[1].equals("Monstruo")){
                    //Guardando la información en el maps
                    maps.put((String)separacion[0].toUpperCase(),(String)separacion[1]);
                } 
                
                
            }
        }
        return maps;
    }
    
    public void printMap(Map lista){
        lista.forEach((key, value) -> System.out.println("\t\t"+ value + " : " + key));
    }
}
